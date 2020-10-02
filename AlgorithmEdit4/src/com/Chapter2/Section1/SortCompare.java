package com.Chapter2.Section1;

import com.Chapter2.Section2.Quick;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
	/**
	 * 
	* @Description   返回使用固定方式排序一个数组花费的时间
	* @author zhongyikang  
	* @date Sep 29, 20209:46:50 PM  
	* @param alg
	* @param a
	* @return
	 */
	public static double time(String alg, Integer[] a, Integer M) {
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Insertion")) Insertion.sort(a);
		if(alg.equals("Selection")) Selection.sort(a);
		if(alg.equals("Quick")) Quick.QuicksortWithInsert(a, M);
		if(alg.equals("Merge")) Merge.sort(a);
		if(alg.equals("MergeUF")) MergeUF.sort(a);
		
		return timer.elapsedTime();
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	/**
	* @Description   将T个长度为N的数组排序
	* @author zhongyikang  
	* @date Sep 29, 20209:43:28 PM  
	* @param alg
	* @param N
	* @param T
	* @return
	 */
	public static double timeRandomInput(String alg, int N, int T,int M) {
		
		//1.生成随机数组
		Integer[] arr = new Integer[N];
		Double timeSpend = 0.0;
		//2. 排序
		for(int i = 0; i < T; i ++) {
			//1. 生成数组
			for(int j = 0; j < N; j ++) {
				arr[j] = StdRandom.uniform(N);
			}
			timeSpend += time(alg, arr,M);
			//show(arr);
		}
		//3. 重复T次
		return timeSpend;
	}
	
	public static void RandomArray(Integer[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = StdRandom.uniform(arr.length);
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(timeRandomInput("Quick",10000,100));
		
		  StdDraw.setXscale(0, 512); 
		  StdDraw.setYscale(0.0, 1000000);
		  StdDraw.setPenRadius(.01); 
		  for(int i = 1; i <= 512; i ++) {
			  Integer[] a = new Integer[i];
			  RandomArray(a);
			  MergeUF.sort(a);
			  StdDraw.point(i, MergeUF.count);
			  MergeUF.count = 0;
		  }
		  
		  for(int i = 1; i <= 512; i ++) {
			  Integer[] b = new Integer[i];
			  RandomArray(b);
			  Merge.sort(b);
			  StdDraw.point(i, Merge.count);
			  Merge.count = 0;
			  
			  StdDraw.point(i, i * 6 * Math.log10(i));
		  }
		 
	}
}
