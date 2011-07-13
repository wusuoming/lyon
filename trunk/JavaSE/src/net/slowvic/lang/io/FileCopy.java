package net.slowvic.lang.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 本例使用nio中的FileChannel类来实现一个简单的文件拷贝工作
 * 注意ByteBuffer的使用
 */
public class FileCopy {
	public static void copyFile(String from,String to) throws IOException
	{
		FileChannel fic = new FileInputStream(from).getChannel();
		FileChannel foc = new FileOutputStream(to).getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		while(true)
		{
			buffer.clear();
			int r = fic.read(buffer);
			if(r==-1)
			{
				break;
			}
			buffer.flip();
			foc.write(buffer);
		}
		fic.close();
		foc.close();
	}
	
	public static void main(String[] args) throws IOException
	{
		copyFile("E:/个人使用/摘录.txt","E:/个人使用/摘录.sql");
	}
}
