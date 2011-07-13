package net.slowvic.lang.concurrency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask来统计多线程运算结果
 */
public class FileCounter
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("请输入目录：");
		String directory = in.nextLine();
		System.out.println("请输入关键字：");
		String keyword = in.nextLine();
		
		MatchCounter counter = new MatchCounter(new File(directory),keyword);
		FutureTask<Integer> task = new FutureTask<Integer>(counter);
		Thread t = new Thread(task);
		t.start();
		try
		{
			System.out.println(task.get()+"个匹配文件");
		}
		catch(ExecutionException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			
		}
	}
}

class MatchCounter implements Callable<Integer>
{
	private File directory;
	private String keyword;
	private int count;
	
	public MatchCounter(File directory,String keyword)
	{
		this.directory = directory;
		this.keyword = keyword;
	}
	
	@Override
	public Integer call() throws Exception
	{
		count = 0;
		try
		{
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<Future<Integer>>();
			
			for(File file : files)
			{
				if(file.isDirectory())
				{
					MatchCounter counter = new MatchCounter(file,keyword);
					FutureTask<Integer> task = new FutureTask<Integer>(counter);
					results.add(task);
					Thread t = new Thread(task);
					t.start();
				}
				else
				{
					if(search(file,keyword))
						count++;
				}
			}
			for(Future<Integer> result : results)
			{
				try
				{
					count += result.get();
				}
				catch(ExecutionException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(InterruptedException e)
		{
			
		}
		return count;
	}
	
	private boolean search(File file,String keyword)
	{
		boolean found = false;
		try
		{
			Scanner in = new Scanner(new FileInputStream(file));
			found = false;
			if(!found && in.hasNextLine())
			{
				String line = in.nextLine();
				if(line.contains(keyword))
					found = true;
			}
			in.close();
		} 
		catch (FileNotFoundException e)
		{
			return false;
		}
		return found;
	}
}