package com.Chapter1.Section4;

import java.util.Iterator;
/**
 * 
* @Description   �ܹ���̬���������С��ջ
* @author zhongyikang  Email:2472082117@qq.com 
* @version  1.0 
* @date Sep 27, 20206:30:58 PM  
*
*�Լ�дһ���࣬ ʵ����Iterable�ӿڣ� ��һ���ڲ��࣬ ʵ����Iterator�ӿڡ�
*�ڲ���ĺô��ǣ� ����ʹ���ⲿ������Ժͷ�����
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
	private Item[] a= (Item[])new Object[1];
	private int N = 0;
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	private void resize(int maxSize) {
		Item[] tmp = (Item[])new Object[maxSize];
		for(int i = 0; i < N; i ++) {
			tmp[i] = a[i];
		}
		a = tmp;
	}
	
	public void push(Item item) {
		if(isFull()) {
			resize(N * 2);
		}
		a[N++] = item;
	}
	
	public Item pop() {
		if(isEmpty()) {
			System.out.println("Ϊnull�� ����Pop");
		}
		Item item = a[--N];
		a[N] = null;
		
		if(N > 0 && N < a.length / 4) {
			resize(a.length / 2);
		}
		
		return item;
	}
	
	
	public boolean isFull() {
		return N == a.length;
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = N;
		@Override
		public boolean hasNext() {
			return i != 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		
	}
}
