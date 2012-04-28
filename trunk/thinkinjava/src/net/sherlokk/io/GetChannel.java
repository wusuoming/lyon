package net.sherlokk.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio最重要的两个概念，Channel和ByteBuffer
 * 
 */
public class GetChannel {

	public static void main(String[] args) throws IOException {
		FileChannel fc = new FileOutputStream(
				"C:\\Documents and Settings\\xus\\桌面\\help.txt").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("\n试试看".getBytes()));
		fc.close();
	}
}
