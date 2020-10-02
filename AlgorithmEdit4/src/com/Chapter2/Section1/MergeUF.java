package com.Chapter2.Section1;

public class MergeUF {
	
	public static int count = 0;
	
	public static void sort(Comparable[] a) {
		for(int sz = 1; sz < a.length; sz = sz + sz) {
			for(int l = 0; l < a.length - sz; l += sz * 2) {
				merge(a, l, l + sz - 1, Math.min(l + sz * 2 - 1, a.length - 1));
			}
		}
	}
	
	private static void merge(Comparable[] a, int l, int mid, int r) {
		if(l >= r) return;
		
		Comparable[] tmp = new Comparable[a.length];
		
		for(int i = 0; i < a.length; i ++) {
			tmp[i] = a[i];
			count += 1;
		}
		
		int i = l, j = mid + 1;
		for(int k = l; k <= r; k ++) {
			if(i > mid) 
				a[k] = tmp[j ++];
			else if(j > r) 
				a[k] = tmp[i ++];	
			else if(less(tmp[i],tmp[j])) {
				a[k] = tmp[i ++];
				count += 1;
			}
				
			else
				a[k] = tmp[j ++];

			count += 2;
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{8,7,6,5,4,3,2,1,1,23,2,1,2,2,1,1,1,2,2,2,3,3,4,4,5,1,1,1,2,3,7,8,5,4,3,4,5,0} ;
		sort(arr);
		show(arr);
		System.out.println(isSorted(arr));
		System.out.println(count);
		count = 0;
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
