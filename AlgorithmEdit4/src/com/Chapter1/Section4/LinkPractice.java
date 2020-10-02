package com.Chapter1.Section4;

import java.util.Iterator;

public class LinkPractice<Item> implements Iterable<Item>{
	private Node first;
	private int N;
	private class Node {
		private Item item;
		private Node next;
		public Node(Item item) {
			super();
			this.item = item;
		}
		
	}
	
	/**
	 * 
	* @Description   1.3.19
	* @author zhongyikang  
	* @date Sep 27, 20207:10:02 PM
	 */
	public void deleteLastNode() {
		Node p = first;
		if(isEmpty()) 
			System.out.println("No last Node because it's a empty link");
		
		if(N == 1) 
			first = null;
		
		while(p.next.next != null) {
			p = p.next;
		}
		p.next = null;
		
		N --;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	/**
	 * 
	* @Description   删除第i个Node
	* @author zhongyikang  
	* @date Sep 27, 20207:21:44 PM  
	* @param index
	 */
	public void deleteNodeNumberI(int index) {
		if(index > N || index <= 0) return;
		Node p = first;
		
		//删除第一个元素
		if(index == 1)
			first = first.next;
		else if(index == N) {
			deleteLastNode();
		} else {
			//删除第i个元素。 寻找第i - 1个元素， 指向 i + 1.
			for(int i = 1; i < index - 1; i ++) {
				p = p.next;
			}
			p.next = p.next.next;
			
		}
		N --;
	}
	
	/**
	 * 
	* @Description   寻找value为参数item的node
	* @author zhongyikang  
	* @date Sep 27, 20207:23:39 PM  
	* @param item
	* @return true： 找到了； false： 没有找到。
	 */
	public boolean findEle(Item item) {
		Node p = first;
		while(p != null) {
			if(p.item.equals(item)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}
	
	/**
	 * 
	* @Description   removeAfter移除这个节点后面的节点
	* @author zhongyikang  
	* @date Sep 27, 20207:28:09 PM  
	* @param node
	* @return
	 */
	public boolean removeAfter(Node node) {
		if(node == null || node.next == null) return false;
		node.next = null;
		return true;
	}
	
	/**
	 * 
	* @Description   提供两个链表节点， 把第第二个节点插入到第一个节点后面
	* @author zhongyikang  
	* @date Sep 27, 20207:29:51 PM  
	* @param node1
	* @param node2
	* @return
	 */
	public boolean insertAfter(Node node1, Node node2) {
		Node tmp = node1.next;
		node1.next = node2;
		node2.next = tmp;
		return true;
	}
	/**
	 * 
	* @Description 删除所有域为key的Node, 使用队列， 符合条件的放入队列，然后一个一个排。
	* @author zhongyikang  
	* @date Sep 27, 20207:33:39 PM  
	* @param key
	 */
	public void remove(Item key) {
		Queue<Node> queue = new Queue<Node>();
		Node p = first;
		while(p != null) {
			if(!p.item.equals(key)) {
				queue.enqueue(p);
			}
			p = p.next;
		}
		first = null;
		Node node = new Node(null);
		p = node;
		while(!queue.isEmpty()) {
			p.next = queue.dequeue();
			p = p.next;
			p.next = null;
		}
		first = node.next;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkIterator();
	}
	
	private class LinkIterator implements Iterator<Item> {
		
		private Node p = first;
		@Override
		public boolean hasNext() {
			return first != null;
		}

		@Override
		public Item next() {
			Node tmp = p;
			p = p.next;
			return tmp.item;
		}
		
	}

	@Override
	public String toString() {
		System.out.println("-----------------This Link------------");
		Iterator<Item> iterator = this.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		return "";
	}
	
	
}
