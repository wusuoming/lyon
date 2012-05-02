package net.sherlokk.concurrent.blocked;

import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * IO类型的阻塞，可以通过释放其底层资源达到中断目的(调用相关的close()方法)
 */
public class CloseResource {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		InputStream socketInput = new Socket("localhost", 80).getInputStream();
		InputStream in = System.in;
		exec.execute(new IOBlocked(in));
		exec.execute(new IOBlocked(socketInput));
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("关闭所有线程");
		exec.shutdownNow();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("关闭SocketInput");
		socketInput.close();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("关闭System.in");
		in.close();// 无法关闭
	}
}
