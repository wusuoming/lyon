package net.slowvic.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * É¸Ñ¡Æ÷
 */
public class Sizer {
	private static final int SIZE = 6;

	public void filter(Integer[] arr, int count) {
		List<Integer> list = Arrays.asList(arr);
		int len = arr.length - 1;
		Random rnd = new Random(47);
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			int temp = rnd.nextInt(len);
			for (int j = 0; j < SIZE; j++) {
				while (result.contains(list.get(temp))) {
					temp = rnd.nextInt(len);
				}
				result.add(list.get(temp));
			}
			Object[] objs = result.toArray();
			Arrays.sort(objs);
			System.out.println(Arrays.toString(objs));
			result.clear();
		}
	}
	
	public static void main(String[] args){
		Integer[] arr = new Integer[]{1,4,5,8,10,11,12,13,18,21,27,28,30,33};
		int count = 15;
		Sizer s = new Sizer();
		s.filter(arr,count);
	}
}
