package com.Chapter1.Section4;


import java.util.Iterator;
/**
 * 
* @Description  用链表实现优先队列， 在尾部入队， 在头部出队 
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Sep 27, 20206:56:52 PM  
*
 */
public class Queue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;
	private class Node {
		Item item;
		Node next;
		public Node(Item item) {
			super();
			this.item = item;
		}
		
		
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		Node node = new Node(item);
		if(isEmpty()) {
			last = node;
			first = node;
		} else {
			last.next = node;
			last = last.next;
		}
		
		N ++;
	}
	
	public Item dequeue() {
		Node tmp = first;
		first = first.next;
		N --;
		
		if(isEmpty()) {
			last = null;
		}
		
		return tmp.item;
		
	}
	
	

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
