package com.example.Chapter1;

import java.util.Iterator;

/**
 * 
* @Description 基于动态数组的双向队列   
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Sep 27, 20208:31:08 PM  
*
 */
public class Deque<Item> implements Iterable<Item>{
	private int first;
	private int last;
	private int N;
	private Item[] a;
	
	
	
	
	public Deque() {
		a = (Item[]) new Object[2];
		first = -1;
		last = -1;
		N = 0;
	}

	public int getCapacity() {
		return a.length;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isFull() {
		return N == a.length;
	}
	
	public void resize(int size) {
		
		//如果不为满，不需要扩容。
		if(!isFull()) return;
		
		//创建新底层实现， 容量为原来的两倍
		Item[] tmp = (Item[])new Object[size];
		int index = 0;
		if(first < last) {
			//情况1， first在last左边，first一定为0， last为a.length - 1.
			for(int i = first; i <= last; i ++) {
				tmp[index ++] = a[i];
			}
		} else {
			//情况2， first在last右边， first在last右边一格位置。
			for(int i = first; i < a.length; i ++) {
				tmp[index ++] = a[i];
			}
			for(int i = 0; i <= last; i ++) {
				tmp[index ++] = a[i];
			}
		}
		//重置first、last索引
		first = 0;
		last = index - 1;
		
		a = tmp;
	}
	
	
	public void pushLeft(Item item) {
		if(isFull()) {
			resize(N * 2);
		}
		
		if(isEmpty()) {
			first = -1;
			last = -1;
		}
		
		if(first <= 0) {
			first = a.length;
		}
		
		a[--first] = item;
		N ++;
		if(N == 1 && last == -1) {
			last = first;
		}
	}

	public void pushRight(Item item) {
		if(isFull()) {
			resize(N * 2);
		}
		if(isEmpty()) {
			first = -1;
			last = -1;
		}
		if(last >= a.length - 1) {
			last = -1;
		}
		a[++last] = item;
		N ++;
		
		if(N == 1 && first == -1) {
			first = last;
		}
	}
	
	public void popLeft() {
		if(isEmpty()) {
			System.out.println("没有内容，无法pop");
			return;
		}
		a[first ++] = null;
		N --;
		if(first == a.length) 
			first = 0;
	}
	
	public void popRight() {
		if(isEmpty()) {
			System.out.println("没有内容，无法pop");
			return;
		}
		a[last --] = null;
		N --;
		
		if(last < 0) {
			last = a.length - 1;
		}
	}
	
	public void printInfo() {
		System.out.println("first: " + first);
		System.out.println("last: " + last);
		System.out.println("N: " + N);
	}
	
	
	
	
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	};
	
	public void printElements() {
		if(first < last) {
			//情况1， first在last左边，first一定为0， last为a.length - 1.
			for(int i = first; i <= last; i ++) {
				System.out.print(a[i] + " ");
			}
		} else if(first > last){
			//情况2， first在last右边， first在last右边一格位置。
			for(int i = first; i < a.length; i ++) {
				System.out.print(a[i] + " ");
			}
			for(int i = 0; i <= last; i ++) {
				System.out.print(a[i] + " ");
			}
		} else {
			System.out.println(a[first]);
		}
	}
}
