package net.slowvic.lang.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegPattern
{
	public static void main(String[] args)
	{
		Pattern p = Pattern.compile("\\d"); //定义正则表达式
		String s = "2b3c4d";
		Matcher m = p.matcher(s);         //输入希望匹配的字符串
		while(m.find())   //查找匹配
		{
			int start = m.start();
			int end = m.end();
			System.out.println(s.substring(start,end));
		}
	}
}
