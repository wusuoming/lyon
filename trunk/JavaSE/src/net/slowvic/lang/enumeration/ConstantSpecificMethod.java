package net.slowvic.lang.enumeration;

import java.text.DateFormat;
import java.util.Date;

/**
 * 每个enum实例都可以实现自己的特殊方法
 * 只需要声明一个abstract方法并让每个实例实现它即可
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
