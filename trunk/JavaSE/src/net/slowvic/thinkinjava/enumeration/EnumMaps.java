package net.slowvic.thinkinjava.enumeration;

import java.util.EnumMap;
import java.util.Map;

import static net.slowvic.thinkinjava.enumeration.AlarmPoints.*;

/**
 * ����չʾEnumMap�Ļ����÷�
 * 1��EnumMap��Ҫָ��Key��Class��Key����Ϊenum
 * 2��EnumMap��putԪ�ص�˳������
 */
public class EnumMaps
{
	public static void main(String[] args)
	{
		EnumMap<AlarmPoints,Command> em = new EnumMap<AlarmPoints,Command>(AlarmPoints.class);
		em.put(BATHROOM,new Command(){
			public void action(){
				System.out.println("ԡ��©ˮ�ˣ�");
			}
		});
		em.put(KITHEN,new Command(){
			public void action(){
				System.out.println("��������ˣ�");
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