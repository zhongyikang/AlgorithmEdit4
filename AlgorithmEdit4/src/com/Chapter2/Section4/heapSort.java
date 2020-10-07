package com.Chapter2.Section4;
/**
 * 
* @Description 使用Example模板自己实现的heapSort   
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Oct 7, 20201:05:53 PM  
*
 */
public class heapSort {
	
	/**
	 * 
	* @Description   sort分为两部分：1. 通过sink前n/2个key， 让这个arr是heapOrded的。
	* 								2. 不断把第一个key放入当前heap的尾部， 然后执行sink()。
	* @author zhongyikang  
	* @date Oct 7, 20201:17:32 PM  
	* @param a 待排序的数组
	 */
	public static void sort(Comparable[] a) {
		int n = a.length;
		
		for(int k = n / 2; k >= 1; k --) {
			sink(a,a.length, k);
		}
		
		
		while(n != 1) {
			exch(a, 0, --n);
			sink(a,n,1);
		}
	}
	
	
	//测试
	public static void main(String[] args) {
		System.out.println("OK");
		
		  String str = "H E A P S O R T A B D E Q S T F K L N Y F E D G J C"; 
		  String[] arr = str.split(" ");
		  
		  sort(arr); 
		  System.out.println(isSorted(arr)); 
		  show(arr);
		  
		  System.out.println(TestMinHeap.isMinHeap(arr));
		 
	}
	


	/**
	 * 
	* @Description   
	* @author zhongyikang  
	* @date Oct 7, 20201:19:53 PM  
	* @param a 待sink的heap
	* @param n 当前heap的长度
	* @param k
	 */
	private static  void sink(Comparable[] a,int n, int k) {
		while(k * 2 < n) {
			int j = k * 2;
			if(less(a, j - 1, j)) j = j + 1;
			
			if(!less(a, k - 1, j - 1)) 
				break;
			
			
			exch(a, k - 1, j - 1);
			k = j;
		}
	}

	private static boolean less(Comparable[] arr, int i, int j) {
		return arr[i].compareTo(arr[j]) < 0;
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
			if(less(a, i + 1, i)) {
				return false;
			}
		}
		return true;
	}

}
