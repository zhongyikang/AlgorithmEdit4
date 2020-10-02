package com.example.Chapter1;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 
* @Description ��ջΪĿ��Ķ��У� ����ʵ�֣� pop��push��enqueue�� ��������   
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
	
	//pop�� ͷ��pop�� ɾ��ͷ��Ԫ��
	public Item pop() {
		if(isEmpty()) {
			return null;
		}
		Node p = first;
		first = first.next;
		N --;
		
		return p.item;
	}
	
	//push�� ͷ��push�� ͷ����ӽڵ�
	public void push(Item item) {
		Node node = new Node(item);
		node.next = first;
		first = node;
		N ++;
	}
	
	//��ӣ� β����ӡ�
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
