package net.slowvic.thinkinjava;

import static java.lang.System.out;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 正则表达式
 *  ? 0次或1次
 *  + 一次或多次
 *  * 任意次数
 *  \\\\ 反斜线
 *  . 任意字符
 *  \s 空白(空格、Tab、换行、换页和回车) \S 非空白符
 *  \d 数字[0-9] \D 非数字
 *  \w 词字符[a-zA-Z0-9] \W 非词字符
 */
public class RegExp
{
	public static void main(String[] args)
	{
		out.println("\\".matches("\\\\")); //这格式，真恶心  \\正则转义
		out.println("23".matches("-?\\d+"));
		out.println("a".matches("."));
		
		Pattern p = Pattern.compile("^\\w{0,6}@\\w{0,10}\\.(com|net)");
		Matcher m = p.matcher("steiny@163.com");
		out.println(m.matches());
	}
}
