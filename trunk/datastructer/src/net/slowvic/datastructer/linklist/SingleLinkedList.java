package net.slowvic.datastructer.linklist;

import java.text.DecimalFormat;

public class SingleLinkedList {

	public static void main(String[] args) {
		double d = 123456789d;
		DecimalFormat df = new DecimalFormat("0.000");
		System.out.println(df.format(d));
	}
}
