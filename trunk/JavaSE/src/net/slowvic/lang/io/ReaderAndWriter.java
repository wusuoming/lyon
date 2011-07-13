package net.slowvic.lang.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * readTxt方法，将txt文档内容读取输出到控制台
 * 充分使用IO中的装饰模式
 */
public class ReaderAndWriter
{
	public static void main(String[] args) throws IOException
	{
		ReaderAndWriter raw = new ReaderAndWriter();
		
		String path = "F:/个人文档/Memo.txt";
		String s = raw.readTxt(path);
		//raw.writeToConsole(s);
		raw.readMemory(s);
	}
	
	public String readTxt(String path) throws IOException
	{
		BufferedReader in = null;
		StringBuilder sb = null;
		try
		{
			in = new BufferedReader(new FileReader(path));
			sb = new StringBuilder(256);
			String temp;
			while((temp=in.readLine())!=null)
				sb.append(temp).append("\n");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("找不到文件，无法读取");
		}
		catch(IOException e)
		{
			System.out.println("读取文件错误");
		}
		finally
		{
			in.close();
		}
		return sb.toString();
	}
	
	public void writeToConsole(String s) throws IOException
	{
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		pw.write(s);
		pw.close();
	}
	
	public void readMemory(String s) throws IOException
	{
		StringReader in = new StringReader(s);
		int c;
		while((c=in.read())!=0)
			System.out.print((char)c);
		in.close();//如果不关闭流，将无限循环。如果关闭，则打印出的内容会被覆盖。
	}
}
