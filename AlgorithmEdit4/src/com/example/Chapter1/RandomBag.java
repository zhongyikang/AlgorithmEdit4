package com.example.Chapter1;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item>{
	private Item[] a;
	private int N;
	public RandomBag() {
		a = (Item[])new Object[20];
		N = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void add(Item item) {
		if(isFull()) 
				resize(N * 2);
		a[N ++] = item;
	}
	
	public boolean isFull() {
		return N == a.length;
	}
	
	public void resize(int max) {
		Item[] tmp = (Item[]) new Object[max];
		for(int i = 0; i < N; i ++) {
			tmp[i] = a[i];
		}
		a = tmp;
	}
	
	public void printInfo() {
		System.out.println("Print all Ele in the Bag");
		for(int i = 0; i < N; i ++) {
			System.out.print(a[i] + " ");
		}
	}
	
	@Override
	public Iterator<Item> iterator() {
		
		return new RandomBagIterator();
	}
	
	private class RandomBagIterator implements Iterator<Item> {

		int i = 0;
		
		public RandomBagIterator() {
			for(int i = 0; i < N; i ++) {
				int index1 = (int)(Math.random() * N);
				int index2 = (int)(Math.random() * N);
				Item tmp = a[index1];
				a[index1] = a[index2];
				a[index2] = tmp;
			}
		}

		@Override
		public boolean hasNext() {
			return i < N;
		}

		@Override
		public Item next() {
			Item tmp = a[i];
			i ++;
			return tmp;
			
		}
		
	}
}
