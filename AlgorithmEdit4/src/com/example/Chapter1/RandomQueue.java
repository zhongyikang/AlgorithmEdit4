package com.example.Chapter1;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item>{
	private Item[] a;
	int N;
	public RandomQueue() {
		a = (Item[]) new Object[10];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void enqueue(Item item) {
		if(isFull()) 
			resize(N * 2);
		a[N ++] = item;
	}
	
	public Item dequeue() {
		int random = (int)(Math.random() * N);
		Item tmp = a[random];
		a[random] = a[N - 1];
		a[N - 1] = tmp;
		
		tmp = a[N - 1];
		a[N - 1] = null;
		N --;
		return tmp;
	}
	
	public Item sample() {
		int random = (int)(Math.random() * N);
		return a[random];
	}

	private void resize(int max) {
		// TODO Auto-generated method stub
		Item[] tmp = (Item[]) new Object[max];
		for(int i = 0; i < N; i ++) {
			tmp[i] = a[i];
		}
		a = tmp;
	}

	private boolean isFull() {
		// TODO Auto-generated method stub
		return N == a.length;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<Item> {
		
		int[] arr = new int[N];
		int i = 0;
		
		public RandomQueueIterator() {
			//0 ~ N - 1
			for(int i = 0; i < arr.length; i ++) {
				arr[i] = i;
			}
			
			//´òÂÒ²Ù×÷
			for(int i = 0; i < arr.length; i ++) {
				int index1 = (int)(Math.random() * N);
				int index2 = (int)(Math.random() * N);
				int tmp = arr[index1];
				arr[index1] = arr[index2];
				arr[index2] = tmp;
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			int tmp = i;
			i ++;
			return a[arr[tmp]];
		}
		
	}
	
}
