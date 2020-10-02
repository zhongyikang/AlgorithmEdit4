package com.example.Chapter2.Section1;

public class Insertion {
	
	public static void sort(Comparable[] a) {
		for(int i = 0; i < a.length - 1; i ++) {
			for(int j = i + 1; j > 0 && less(a[j], a[j - 1]); j --) {
				exch(a, j, j - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1,3,5,2,3,4,5,6,2,3,4};
		sort1(arr);
		Insertion.show(arr);
		System.out.println(Insertion.isSorted(arr));
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
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	private static boolean isSorted(Comparable[] a) {
		for(int i = 0; i < a.length - 1; i ++) {
			if(less(a[i + 1],a[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void sort1(Comparable[] a) {
		for(int i = 0; i < a.length - 1; i ++) {
			for(int j = i + 1; j > 0 && less(a[j], a[j - 1]); j --) {
				exch(a, j - 1, j);
			}
 		}
	}
	
	public static void sort(Comparable[] a, int l, int r) {
		for(int i = l; i < r; i ++) {
			for(int j = i + 1; j > l && less(a[j], a[j - 1]); j --) {
				exch(a, j, j - 1);
			}
		}
	}
}
