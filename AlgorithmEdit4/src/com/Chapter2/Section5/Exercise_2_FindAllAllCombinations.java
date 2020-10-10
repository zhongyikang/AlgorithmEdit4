package com.Chapter2.Section5;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * time complexity is N with 2 power.
* @Description   
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Oct 7, 20205:34:14 PM  
*
 */
public class Exercise_2_FindAllAllCombinations {
	public static String[] findAllAllCombinations(String[] a) {
		if(a == null || a.length == 0 || a.length == 1) return a;
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < a.length - 1; i ++) {
			for(int j = i + 1; j < a.length; j ++) {
				String str1 = a[i] + a[j];
				String str2 = a[j] + a[i];
				
				if(!set.contains(str1)) {
					set.add(str1);
					list.add(str1);
				}
				
				if(!set.contains(str2)) {
					set.add(str2);
					list.add(str2);
				}
			}
		}
		
		return list.toArray(a);
	}
	
	public static void main(String[] args) {
		String[] arr = {"you", "should","not","be","be"};
		String[] strings = findAllAllCombinations(arr);
		for(String str : strings) {
			System.out.println(str);
		}
	}
}
