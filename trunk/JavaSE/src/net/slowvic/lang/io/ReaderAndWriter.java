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
 * readTxt��������txt�ĵ����ݶ�ȡ���������̨
 * ���ʹ��IO�е�װ��ģʽ
 */
public class ReaderAndWriter
{
	public static void main(String[] args) throws IOException
	{
		ReaderAndWriter raw = new ReaderAndWriter();
		
		String path = "F:/�����ĵ�/Memo.txt";
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
			System.out.println("�Ҳ����ļ����޷���ȡ");
		}
		catch(IOException e)
		{
			System.out.println("��ȡ�ļ�����");
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
		in.close();//������ر�����������ѭ��������رգ����ӡ�������ݻᱻ���ǡ�
	}
}
