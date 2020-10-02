package com.example.Chapter1;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
	private Node first;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		Node oldNode = first;
		first = new Node();
		first.item = item;
		first.next = oldNode;
		N ++;
	}
	
	public Item pop() {
		Item popItem = first.item;
		first = first.next;
		N --;
		return popItem;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item> {

		private Node p = first;
		@Override
		public boolean hasNext() {
			return p != null;
		}

		@Override
		public Item next() {
			Node q = p;
			p = p.next;
			return q.item;
		}
		
	}

}
