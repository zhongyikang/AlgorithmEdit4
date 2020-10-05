package com.Chapter2.Section4;

import java.util.Comparator;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int n;
	
	public OrderedArrayMaxPQ(int capacity) {
		pq = (Key[])(new Comparable[capacity]);
		n = 0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public Key delMax() {
		if(n == 0) {
			System.out.println("Priority queue is empty and nothing to delete");
			return null;
		}
			
		else 
			return pq[--n];
	}
	
	public void insert(Key newEle) {
		int i = n - 1;
		/*
		 * while(i != 0) { if(less(pq[i], pq[i - 1])) { swap(pq, i, i - 1); i --; } else
		 * break; }
		 */
		//Refactor: it OK to compare keys first instead of inserting
		//the key to array first
		while(i >= 0 && less(newEle, pq[i])) {
			pq[i + 1] = pq[i];
			i --;
		}
		pq[i + 1] = newEle;
		n ++;
		
		
	}

	private void swap(Key[] arr, int i, int j) {
		Key tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private boolean less(Key key, Key key2) {
		return key.compareTo(key2) < 0;
	}

	private void printInfo() {
		for(Key k:pq) {
			System.out.print(k + " ");
		}
	}
	
	
	public static void main(String[] args) {
		OrderedArrayMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>(10);
		for(int i = 10; i >= 1; i --) {
			pq.insert(i);
			if(i == 5)
				pq.delMax();
		}
		pq.printInfo();
	}
	
}
