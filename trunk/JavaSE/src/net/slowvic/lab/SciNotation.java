package net.slowvic.lab;

import java.math.BigDecimal;

public class SciNotation {
	public static void main(String[] args){
		//intֵ��Լ����21�ھͳ�����Χ�ˣ�doubleֵ����1ǧ��ͻ��Կ�ѧ��������ʾ
		double d = 10000000;
		Double dd = new Double(d);
		BigDecimal bd = new BigDecimal(dd);
		System.out.println(bd);
	}
}
