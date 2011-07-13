package net.slowvic.lang.enumeration;

import java.util.EnumSet;

/**
 * ����չʾEnumSet��һЩ�����÷�
 * 1�������ض����͵Ŀ�EnumSet
 * 2���������Ԫ�� addAll
 * 3��of,allOf����
 * 4��removeAll,range
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