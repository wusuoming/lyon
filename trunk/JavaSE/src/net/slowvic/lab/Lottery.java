package net.slowvic.lab;

import java.util.Random;

class LotterySelect
{
	private static final int COUNT = 6;
	private Random rnd = new Random();
	
	private int randomNo(int limit)
	{
		return rnd.nextInt(limit);
	}
	
	private int[] gen6RedBalls(int limit)
	{
		int min = 0;
		int temp = 0;
		int i = 0;
		int[] redBalls = new int[COUNT];
		while(i<COUNT)
		{
			while(temp <= min || temp > (limit+i-COUNT))
				temp = randomNo(limit);
			min = temp;
			temp = 0;
			redBalls[i] = min;
			i++;
		}
		return redBalls;
	}
	
	private String genBlueBall(int limit)
	{
		int temp = 0;
		while(temp==0)
			temp = randomNo(limit);
		return temp<10?"0"+temp:String.valueOf(temp);
	}
	
	private String concatDoubleColorBalls(int[] redBalls,String blueBall)
	{
		StringBuilder sb = new StringBuilder(64);
		for(int i=0;i<redBalls.length;i++)
		{
			int temp = redBalls[i];
			String part = null;
			if(temp<10)
				part = "0" + temp;
			else
				part = String.valueOf(temp);
			if(i==0)
				sb.append(part);
			else
				sb.append("  ").append(part);
		}
		
		return sb.append(" , ").append(blueBall).toString();
	}
	
	public void genDoubleColorBalls(int redBallLimit,int blueBallLimit,int num)
	{
		int i = 0;
		StringBuilder sb = new StringBuilder(256);
		int[] redBalls = null;
		String blueBall = null;
		while(i<num)
		{
			redBalls = gen6RedBalls(redBallLimit);
			boolean flag = true;
			for(int j=0;j<redBalls.length;)
			{
				int sum = redBalls[j]+redBalls[j+1];
				int restrict = (int)(redBallLimit*2.3/(COUNT/2-j/2));
				if(sum > restrict)
				{
					flag = false;
					break;
				}
				j += 2;
			}
			if(flag)
			{
				blueBall = genBlueBall(blueBallLimit);
				sb.append(concatDoubleColorBalls(redBalls,blueBall)).append("\n");
				i++;
			}
		}
		System.out.println(sb.toString());
	}
}

public class Lottery
{
	public static void main(String[] args)
	{
		LotterySelect l = new LotterySelect();
		l.genDoubleColorBalls(33,16,1);
	}
}