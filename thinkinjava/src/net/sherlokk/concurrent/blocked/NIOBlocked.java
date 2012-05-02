package net.sherlokk.concurrent.blocked;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NIOBlocked implements Runnable {

	private SocketChannel sc;

	public NIOBlocked(SocketChannel sc) {
		this.sc = sc;
	}

	public void run() {
		try {
			System.out.println("等待输入：" + this);
			sc.read(ByteBuffer.allocate(1));
		} catch (ClosedByInterruptException e) {

		} catch (AsynchronousCloseException e) {

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("NIO线程正常退出，" + this);
	}

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		InetSocketAddress isa = new InetSocketAddress("localhost", 80);
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);
		Future<?> f = exec.submit(new NIOBlocked(sc1));
		exec.execute(new NIOBlocked(sc2));
		// 注意shutdown和shutdownNow的区别
		exec.shutdownNow();
		TimeUnit.SECONDS.sleep(1);
		// NIO操作可直接中断
		f.cancel(true);
		TimeUnit.SECONDS.sleep(1);
		// 也可通过关闭底层资源来中断
		sc2.close();
	}
}