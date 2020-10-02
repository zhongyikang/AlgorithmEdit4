package com.example.Chapter2.Section1;

import com.example.Chapter2.Section2.Quick;

public class Merge {

	public static int count = 0;
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	
	
	
	private static void sort(Comparable[] a, int l, int r) {
		if(l >= r) return;
		int mid = l + (r - l) / 2;
		
		Comparable[] tmp = new Comparable[a.length];
	
		sort(a, l, mid);
		sort(a, mid + 1, r);

		for(int i = 0; i < a.length; i ++) {
			tmp[i] = a[i];
			count ++;
		}
		
		int i = l, j = mid + 1;
		for(int k = l; k <= r; k ++) {
			if(i > mid) 
				a[k] = tmp[j ++];
			else if(j > r) 
				a[k] = tmp[i ++];	
			else if(less(tmp[i],tmp[j])) {
				count += 1;
				a[k] = tmp[i ++];
			}
			else
				a[k] = tmp[j ++];
			
			count += 1;
			
		}
	}
	



	public static void main(String[] args) {
		Integer[] arr = new Integer[]{8,7,6,5,4,3,2,1,1,23,2,1,2,2,1,1,1,2,2,2,3,3,4,4,5,1,1,1,2,3,7,8,5,4,3,4,5,0} ;
		sort(arr);
		Merge.show(arr);
		System.out.println(Merge.isSorted(arr));
		System.out.println(count);
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
}
