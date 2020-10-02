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
	* @Description   ɾ����i��Node
	* @author zhongyikang  
	* @date Sep 27, 20207:21:44 PM  
	* @param index
	 */
	public void deleteNodeNumberI(int index) {
		if(index > N || index <= 0) return;
		Node p = first;
		
		//ɾ����һ��Ԫ��
		if(index == 1)
			first = first.next;
		else if(index == N) {
			deleteLastNode();
		} else {
			//ɾ����i��Ԫ�ء� Ѱ�ҵ�i - 1��Ԫ�أ� ָ�� i + 1.
			for(int i = 1; i < index - 1; i ++) {
				p = p.next;
			}
			p.next = p.next.next;
			
		}
		N --;
	}
	
	/**
	 * 
	* @Description   Ѱ��valueΪ����item��node
	* @author zhongyikang  
	* @date Sep 27, 20207:23:39 PM  
	* @param item
	* @return true�� �ҵ��ˣ� false�� û���ҵ���
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
	* @Description   removeAfter�Ƴ�����ڵ����Ľڵ�
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
	* @Description   �ṩ��������ڵ㣬 �ѵڵڶ����ڵ���뵽��һ���ڵ����
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
	* @Description ɾ��������Ϊkey��Node, ʹ�ö��У� ���������ķ�����У�Ȼ��һ��һ���š�
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
