package net.slowvic.lab;

import java.math.BigDecimal;

public class SciNotation {
	public static void main(String[] args){
		//int值大约超过21亿就超出范围了，double值超过1千万就会以科学记数法表示
		double d = 10000000;
		Double dd = new Double(d);
		BigDecimal bd = new BigDecimal(dd);
		System.out.println(bd);
	}
}
