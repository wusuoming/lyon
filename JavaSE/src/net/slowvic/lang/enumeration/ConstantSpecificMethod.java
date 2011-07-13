package net.slowvic.lang.enumeration;

import java.text.DateFormat;
import java.util.Date;

/**
 * ÿ��enumʵ��������ʵ���Լ������ⷽ��
 * ֻ��Ҫ����һ��abstract��������ÿ��ʵ��ʵ��������
 */
public enum ConstantSpecificMethod
{
	DATE_TIME{
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");
		}
	},
	VERSION{
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	abstract String getInfo();
	
	public static void main(String[] args)
	{
		for(ConstantSpecificMethod method : values())
			System.out.println(method.getInfo());
	}
}
