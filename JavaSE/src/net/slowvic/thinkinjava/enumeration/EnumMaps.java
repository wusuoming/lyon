package net.slowvic.thinkinjava.enumeration;

import java.util.EnumMap;
import java.util.Map;

import static net.slowvic.thinkinjava.enumeration.AlarmPoints.*;

/**
 * 本例展示EnumMap的基本用法
 * 1、EnumMap需要指定Key的Class，Key必须为enum
 * 2、EnumMap按put元素的顺序排序
 */
public class EnumMaps
{
	public static void main(String[] args)
	{
		EnumMap<AlarmPoints,Command> em = new EnumMap<AlarmPoints,Command>(AlarmPoints.class);
		em.put(BATHROOM,new Command(){
			public void action(){
				System.out.println("浴室漏水了！");
			}
		});
		em.put(KITHEN,new Command(){
			public void action(){
				System.out.println("厨房起火了！");
			}
		});
		for(Map.Entry<AlarmPoints,Command> entry : em.entrySet()){
			entry.getValue().action();
		}
		em.get(LOBBY).action(); //--- NullPointerException
	}
}

interface Command
{
	void action();
}