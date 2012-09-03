package net.sherlokk.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * flip和clear方法的使用虽然有点拙劣，但的确可以提高速度
 */
public class ChannelCopy {
	private static final int BSIZE = 1024;

	@SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream(
				"C:\\Documents and Settings\\xus\\桌面\\help.txt").getChannel();
		// 文件不存在会自动创建
		FileChannel out = new FileOutputStream(
				"C:\\Documents and Settings\\xus\\桌面\\1.txt").getChannel();
		// 分配buffer的容量
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while (in.read(buffer) != -1) {
			// 准备写
			buffer.flip();
			out.write(buffer);
			// 准备读
			buffer.clear();
		}
	}
}
