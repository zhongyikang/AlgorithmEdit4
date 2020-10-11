package com.Chapter3.Section1;

import java.util.NoSuchElementException;

/**
 * 
* @Description   链表实现有序符号表
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Oct 11, 202011:29:43 AM  
*
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
	
	//Node, 内部类
	 private class Node {
	        private Key key;
	        private Value val;
	        private Node next;

	        public Node(Key key, Value val, Node next)  {
	            this.key  = key;
	            this.val  = val;
	            this.next = next;
	        }
	  }
	 
	 private Node head;
	 private int N;
	 //private static final int DEFAULT_INIT_CAPACITY = 2; 不需要任何CAPACITY和resize()方法
	 
	 public OrderedSequentialSearchST() {
		 head = null;
		 N = 0;
	 }
	 
	 public void put(Key key, Value val) {
		 if(key == null) throw new IllegalArgumentException("Key can't be null!");
		 if(val == null) delete(key);
		 
		 Node tmp = new Node(key,val,null);
		 
		 if(N == 0) {
			head = tmp;
			N ++;
			return;
		 }
		 
		 Node node = selectNode(key);
		 int cmt = node.key.compareTo(key);
		 if(cmt == 0) node.val = val;
		 else if(cmt > 0) {
			 //
			 tmp.next = head;
			 head = tmp;
			 N ++;
		 } else {
			 //没找到，夹在两个node之间； 或者到了list的尾部
			 Node nextNode = node.next;
			 node.next = tmp;
			 tmp.next = nextNode;
			 N ++;
		 }
		 
	 }
	 
	 /**
	  * 发现delete无法用selectNode来解决问题，所以自己写一个遍历
	 * @Description   
	 * @author zhongyikang  
	 * @date Oct 11, 202012:29:35 PM  
	 * @param key
	  */
	 public void delete(Key key) {
		 checkKeyIsNull(key);
		 if(N == 0) throw new IllegalArgumentException("数组为空，无法删除");
		 Node p = head;
		 Node q = p.next;
		 
		 //从下标为0开始
		 if(p.key.equals(key)) {
			 head = head.next;
			 N --;
		 }
		 
		 while(q != null) {
			 if(q.key.equals(key)) {
				 p.next = q.next;
				 N --;
				 return;
			 }
			 p = q;
			 q = q.next;
		 }
		 
		 
	 }

	 
	 /**
	  * selectNode是linked list imp ST中最重要部分， 其重要性类似于Array实现中的rank().
	  * 
	 * @Description 查找key对应的node。   
	 * @author zhongyikang  
	 * @date Oct 11, 202012:17:49 PM  
	 * @param key
	 * @return
	  */
	 public Node selectNode(Key key) {
		 //key不能为空
		 checkKeyIsNull(key);
		 
		 Node p = head;
		
		 
		 //head.key > key， 
		 if(key.compareTo(head.key) < 0) return head;
		 		 
		 while(p.next != null) {
			 
			 //p.key 相等于 p.val的情况
			 if(p.key.equals(key)) return p;
			 
			 //p.key < key的情况， 分为两种， p为最后一个元素， 或者p小于但是p.next大于key。
			 if(p.next.key.compareTo(key) > 0) {
				 return p;
			 }
			 
			 p = p.next;
		 }
		 
		 //p.next == null, list'last element < key
		 return p;
		 
		 
		
	 }
	 
	 public Value get(Key key) {
		 checkKeyIsNull(key);
		 Node node = selectNode(key);
		 if(node.key.equals(key)) return node.val;
		 return null;
	 }
	
	/**
	 * 因为链表没有索引，只能通过遍历查找，复杂度为O(N). 
	 * 同时，不像Array实现的Ordered Symbol Table， rank无法为其他方法提供帮助。
	* @Description   找到小于key的键数量
	* @author zhongyikang  
	* @date Oct 11, 202011:37:07 AM  
	* @param key
	 */
	
	public boolean contains(Key key) {
		checkKeyIsNull(key);
		
		return selectNode(key).equals(key);
	}
	

	
	
	public void checkKeyIsNull(Key key) {
		if(key == null) throw new IllegalArgumentException("Key can't be null!");
	}
	
	
	public void printInfo() {
		Node p = head;
		while(p != null) {
			System.out.println(p.key + " " + p.val);
			p = p.next;
		}
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public Key min() {
		if(N == 0) throw new NoSuchElementException("链表为空，没有最小元素");
		return head.key;
	}
	
	public Key max() {
		if(N == 0) throw new NoSuchElementException("链表为空，没有最大元素");
		Node p = head;
		while(p.next != null) {
			p = p.next;
		}
		return p.key;
	}
	
	/**
	 * 
	* @Description 寻找小于等于 key的maxKey   
	* @author zhongyikang  
	* @date Oct 11, 202012:51:02 PM  
	* @param key
	* @return
	 */
	public Key floor(Key key) {
		Node node = selectNode(key);
		//三种情况的汇集：1.等于， 直接返回； 2. 小于， 两种情况。 a.最后一个元素node.key < key, 返回的是最后一个元素， 符合题意。
		//b.夹在两个元素中间， 返回的是小的那个元素。
		if(node.key.compareTo(key) <= 0) return node.key;
		
		//找到了head， key 小于 head.key的情况
		return null;
	}
	
	
	public Key ceiling(Key key) {
		checkKeyIsNull(key);
		Node node = selectNode(key);
		
		int cmp = node.key.compareTo(key);
		
		if(cmp >= 0) return node.key;
		else if(node.next == null) return null;
		else return node.next.key;
	}
	
	
	public int rank(Key key) {
		checkKeyIsNull(key);
		int count = 0;
		Node p = head;
		while(p != null) {
			if(p.key.compareTo(key) < 0) 
				count ++;
			else {
				break;
			}
			p = p.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		OrderedSequentialSearchST<Integer,Integer> st = new OrderedSequentialSearchST<Integer, Integer>();
		st.put(2, 3);
		st.put(4, 1);
		st.put(3, 1);
		st.put(0, 1);
		st.put(5, 1);
		
		st.put(-1, 3);
		st.put(1, 2);
		st.put(6, 0);
		st.printInfo();
		
		System.out.println("------------");
		st.delete(6);
		st.delete(-1);
		st.delete(7);
		st.printInfo();
		System.out.println(st.N);
		
		System.out.println("Max Key:" + st.max());
		System.out.println("Min Key:" + st.min());
		
		System.out.println("floor Key of -10:" + st.floor(-10));
		System.out.println("floor Key of 4:" + st.floor(4));
		System.out.println("floor Key of 100:" + st.floor(100));
		
		
		System.out.println("ceiling Key of -10:" + st.ceiling(-10));
		System.out.println("ceiling Key of 4:" + st.ceiling(4));
		System.out.println("ceiling Key of 100:" + st.ceiling(100));
		
		System.out.println("Ranking num of key 5:" +  st.rank(5));
		System.out.println("Ranking num of key 100:" +  st.rank(100));
		System.out.println("Ranking num of key -1:" +  st.rank(-1));
	}
	 
	 
	 
}
