package net.slowvic.lang.enumeration;

import java.util.EnumSet;

/**
 * 本例展示EnumSet的一些基本用法
 * 1、建立特定类型的空EnumSet
 * 2、批量添加元素 addAll
 * 3、of,allOf方法
 * 4、removeAll,range
 */
public class EnumSets
{
	public static void main(String[] args)
	{
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(AlarmPoints.BATHROOM);
		System.out.println(points);
		points.addAll(EnumSet.of(AlarmPoints.KITHEN,AlarmPoints.LOBBY));
		System.out.println(points);
		points = EnumSet.allOf(AlarmPoints.class);
		System.out.println(points);
		points.removeAll(EnumSet.range(AlarmPoints.BATHROOM,AlarmPoints.OFFICE));
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);
	}
}

enum AlarmPoints
{
	BATHROOM,KITHEN,STAIR1,OFFICE,LOBBY;
}