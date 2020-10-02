package com.example.Chapter2.Section2;

import com.example.Chapter2.Section1.Insertion;

public class Quick {

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		// show(a);

	}

	private static void sort(Comparable[] a, int l, int r) {

		
		if (l >= r)
			return;
		// System.out.println(r - l + 1);
		Comparable v = a[l];
		int i = l + 1, j = r;

		while (true) {
			while (i <= r && less(a[i], v)) {
				i++;
			}

			while (j > l && less(v, a[j])) {
				j--;
			}
			// System.out.println("OK");
			if (i < j) {
				
				exch(a, i, j);
				i++;
				j--;
			}

			else
				break;
			
		}

		exch(a, l, j);
		
		sort(a, l, j - 1);
		sort(a, j + 1, r);

	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{3,2,1} ;
		sort1(arr, 0, arr.length - 1);
		Quick.show(arr);
		System.out.println(Quick.isSorted(arr));
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (less(a[i + 1], a[i])) {
				return false;
			}
		}
		return true;
	}

	private static void sort1(Comparable[] a, int l, int r) {
		if (l >= r)
			return;
		int i = l + 1, j = r;
		Comparable v = a[l];
		//show(a);
		while (i <= j) {
			while (i <= r && less(a[i], v))
				i++;
			while (j > l && less(v, a[j]))
				j--;

			if (i <= j) {
				exch(a, i, j);
				i++;
				j--;
			}
		}

		exch(a, l, j);
		//show(a);
		//System.out.println("l == " + l + " r == " + r + " " + " j == " + j + " and v == " + v);

		sort1(a, l, j - 1);
		sort1(a, j + 1, r);
	}
	/**
	 * 
	* @Description   含有插入排序的快速排序
	* @author zhongyikang  
	* @date Sep 30, 20207:34:35 PM  
	* @param a
	* @param M 当数组长度小于M的时候， 执行快排
	 */
	public static void QuicksortWithInsert(Comparable[] a, int M) {
		QuicksortWithInsert(a, 0, a.length - 1, M);
	}
	
	public static void QuicksortWithInsert(Comparable[] a,int l, int r,int M) {
		if (l >= r)
			return;
		// System.out.println(r - l + 1);
		Comparable v = a[l];
		int i = l + 1, j = r;

		while (true) {
			while (i <= r && less(a[i], v)) {
				i++;
			}

			while (j > l && less(v, a[j])) {
				j--;
			}
			// System.out.println("OK");
			if (i < j) {
				
				exch(a, i, j);
				i++;
				j--;
			}

			else
				break;
			
		}

		exch(a, l, j);
		
		if(j - l <= M)
			Insertion.sort(a, l, j - 1);
		else
			sort(a, l, j - 1);
		
		if(r - j<= M)
			Insertion.sort(a, j + 1, r);
		else
			sort(a, j + 1, r);

	}
}
