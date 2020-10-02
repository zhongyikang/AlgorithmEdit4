package com.example.Chapter1;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 
* @Description 以栈为目标的队列， 可以实现： pop、push、enqueue， 基于链表。   
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Sep 27, 20208:15:12 PM  
*
 */
public class Steque<Item> {
	public Node first;
	public int N;
	public class Node {
		Item item;
		Node next;
		public Node(Item item) {
			super();
			this.item = item;
		}
		
		
	}
	
	//pop， 头部pop， 删除头部元素
	public Item pop() {
		if(isEmpty()) {
			return null;
		}
		Node p = first;
		first = first.next;
		N --;
		
		return p.item;
	}
	
	//push， 头部push， 头部添加节点
	public void push(Item item) {
		Node node = new Node(item);
		node.next = first;
		first = node;
		N ++;
	}
	
	//入队， 尾部入队。
	public void enqueue(Item item) {
		Node node = new Node(item);

		Node p = first;
		while(p != null && p.next != null) {
			p = p.next;
		}
		
		if(p == null) first = node;
		else {
			p.next = node;
		}
		
		N ++;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	
}
