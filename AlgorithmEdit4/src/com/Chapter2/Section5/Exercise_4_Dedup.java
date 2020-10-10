package com.Chapter2.Section5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise_4_Dedup {
	public static String[] dedup(String[] a) {
		if(a == null || a.length == 0) return a;
		
		Arrays.sort(a, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(a[0]);
		for(int i = 1; i < a.length; i ++) {
			if(!a[i].equals(a[i - 1])) {
				list.add(a[i]);
			}
		}
		
		return list.toArray(a);
	}
	
	public static void main(String[] args) {
		String[] strings = {"you","are","here","for","reason"};
		dedup(strings);
		for(String str: strings) {
			System.out.print(str + " ");
		}
	}
}
