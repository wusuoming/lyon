package net.slowvic.thinkinjava;

import static java.lang.System.out;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * ������ʽ
 *  ? 0�λ�1��
 *  + һ�λ���
 *  * �������
 *  \\\\ ��б��
 *  . �����ַ�
 *  \s �հ�(�ո�Tab�����С���ҳ�ͻس�) \S �ǿհ׷�
 *  \d ����[0-9] \D ������
 *  \w ���ַ�[a-zA-Z0-9] \W �Ǵ��ַ�
 */
public class RegExp
{
	public static void main(String[] args)
	{
		out.println("\\".matches("\\\\")); //���ʽ�������  \\����ת��
		out.println("23".matches("-?\\d+"));
		out.println("a".matches("."));
		
		Pattern p = Pattern.compile("^\\w{0,6}@\\w{0,10}\\.(com|net)");
		Matcher m = p.matcher("steiny@163.com");
		out.println(m.matches());
	}
}
