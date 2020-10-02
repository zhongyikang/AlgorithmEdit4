package com.example.Chapter2.Section1;

import java.util.Comparator;

/**
 * 
* @Description   ����ÿ�������㷨��ģ��
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Sep 29, 20208:49:59 PM  
*
 */
public class Example {
	/**
	 * 
	* @Description �����㷨����   
	* @author zhongyikang  
	* @date Sep 29, 20208:50:49 PM  
	* @param a
	 */
	public static void sort(Comparable[] a) {
		
	}
	
	/**
	 * 
	* @Description   �Ƚ����������Ĵ�С�� ���Ƕ�ʵ����Comparable�ӿ�
	* @author zhongyikang  
	* @date Sep 29, 20208:51:51 PM  
	* @param v ������1
	* @param w ������2
	* @return �Ƚϴ�С����� ���v С�� w�� ����true�� ��֮�� ����false
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
