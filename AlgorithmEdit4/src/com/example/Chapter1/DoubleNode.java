package com.example.Chapter1;

public class DoubleNode<Item> {
	public class Node {
		private Item value;
		private Node next;
		private Node pre;
		public Node(Item value) {
			super();
			this.value = value;
		}
	}
	
	private Node first;
	private Node last;
	
	public void insertAtHead(Node node) {
		node.next = first;
		node.pre = null;
		first.pre = node;
		first = node;
	}
	
	
	
}
