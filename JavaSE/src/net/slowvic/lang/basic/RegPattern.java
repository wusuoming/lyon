package net.slowvic.lang.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegPattern
{
	public static void main(String[] args)
	{
		Pattern p = Pattern.compile("\\d"); //����������ʽ
		String s = "2b3c4d";
		Matcher m = p.matcher(s);         //����ϣ��ƥ����ַ���
		while(m.find())   //����ƥ��
		{
			int start = m.start();
			int end = m.end();
			System.out.println(s.substring(start,end));
		}
	}
}
