package com.example.Chapter2.Section1;

import java.util.Comparator;

/**
 * 
* @Description   本节每个排序算法的模板
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Sep 29, 20208:49:59 PM  
*
 */
public class Example {
	/**
	 * 
	* @Description 排序算法核心   
	* @author zhongyikang  
	* @date Sep 29, 20208:50:49 PM  
	* @param a
	 */
	public static void sort(Comparable[] a) {
		
	}
	
	/**
	 * 
	* @Description   比较两个变量的大小， 他们都实现了Comparable接口
	* @author zhongyikang  
	* @date Sep 29, 20208:51:51 PM  
	* @param v 操作数1
	* @param w 操作数2
	* @return 比较大小结果， 如果v 小于 w， 返回true； 反之， 返回false
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	private static boolean isSorted(Comparable[] a) {
		for(int i = 0; i < a.length - 1; i ++) {
			if(!less(a[i + 1],a[i])) {
				return false;
			}
		}
		return true;
	}
}
