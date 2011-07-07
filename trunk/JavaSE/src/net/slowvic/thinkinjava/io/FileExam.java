package net.slowvic.thinkinjava.io;

import java.io.File;
import java.io.FilenameFilter;

public class FileExam 
{
	public static void main(String[] args)
	{
		String path = "E:/ѧϰ�鼮";
		FileExam fe = new FileExam();
		fe.listDirectory(path);
	}
	
	//���õݹ��г�ָ��Ŀ¼������pdf�ļ�
	public void listDirectory(String path)
	{
		File dir = new File(path);
		if(dir.isDirectory())
		{
			String[] arr = dir.list(new DirFilter(".pdf"));
			for(String s : arr)
			{
				listDirectory(path+"/"+s);
			}
		}
		else
			System.out.println(dir.getName());
	}
}

class DirFilter implements FilenameFilter
{
	private String name ;
	DirFilter(String name)
	{
		this.name = name;
	}
	public boolean accept(File dir, String name)
	{
		File file = new File(dir.getAbsolutePath()+"/"+name);
		if(file.isDirectory() || name.endsWith(this.name))
			return true;
		else
			return false;
	}
}