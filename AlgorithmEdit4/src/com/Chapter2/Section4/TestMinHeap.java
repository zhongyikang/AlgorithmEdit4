package com.Chapter2.Section4;

public class TestMinHeap {
	public static boolean isMinHeap(Comparable[] pq) {
		for(int i = 0; i < pq.length / 2; i ++) {
			int j = i * 2 + 1; //left child
			if(j + 1 < pq.length && pq[j].compareTo(pq[j + 1]) > 0) {
				j = j + 1;
			}
			if(pq[i].compareTo(pq[j]) > 0) {
				return false;
			}
		}
		return true;
	}
}
