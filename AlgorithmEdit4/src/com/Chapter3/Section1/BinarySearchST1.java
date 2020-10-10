package com.Chapter3.Section1;

import java.util.NoSuchElementException;

public class BinarySearchST1<Key extends Comparable<Key>, Value>{
	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] vals;
	private int n = 0;
	
	public BinarySearchST1() {
		this(INIT_CAPACITY);
	}

	public BinarySearchST1(int initCapacity) {
		keys = (Key[])new Comparable[initCapacity];
		vals = (Value[])new Object[initCapacity];
		
	}
	
	private void resize(int capacity) {
		assert capacity >= n;
		
		Key[] tmpk = (Key[])new Comparable[capacity];
		Value[] tmpv = (Value[])new Object[capacity];
		
		for(int i = 0; i < n; i ++) {
			tmpk[i] = keys[i];
			tmpv[i] = vals[i];
		}
		
		keys = tmpk;
		vals = tmpv;
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean contains(Key key) {
		if(key == null) throw new IllegalArgumentException("key argument in contains() can't be null!");
		
		return get(key) != null;
	}

	private Value get(Key key) {
		if(key == null) throw new IllegalArgumentException("key argument in get() can't be null!");
		
		if(isEmpty()) return null;
		
		int i = rank(key);
		
		if(i < n && keys[i].compareTo(key) == 0)
			return vals[i];
		
		return null;
	}

	private int rank(Key key) {
		if(key == null) throw new IllegalArgumentException("key argument in rank() can't be null!");
		
		int lo = 0, ho = n - 1;
		while(lo <= ho) {
			int mid = lo + (ho - lo) / 2;
			int cmt = key.compareTo(keys[mid]);
			if(cmt < 0) ho = mid - 1;
			else if(cmt > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	
	public void put(Key key, Value value) {
		if(key == null) throw new IllegalArgumentException("key argument in put() can't be null!");
		
		if(value == null) {
			delete(key);
			return;
		}
		
		int i = rank(key);
		
		if(i < n && keys[i].equals(key)) {
			vals[i] = value;
			return;
		}
		
		if(size() == keys.length)
			resize(size() * 2);
		
		for(int j = n; j > i; j --) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		
		keys[i] = key;
		vals[i] = value;
		n ++;	
		
		assert check();
	}

	private void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;

		int i = rank(key);
		
		if(i == n || keys[i].compareTo(key) != 0) {
			return;
		}
		
		for(int j = i; j < n - 1; j ++) {
			keys[j] = keys[j + 1];
			vals[j] = vals[j + 1];
		}
		
		n --;
		keys[n] = null;
		vals[n] = null;
		
		if(n > 0 && n == keys.length / 4) {
			resize(keys.length / 2);
		}
	}
	
	public void deleteMax() {
		/*
		 * keys[n - 1] = null; vals[n - 1] = null; n --;
		 */
		
		if(isEmpty()) throw new NoSuchElementException("ST为空，无法删除");
		
		delete(max());
	}

	private Key max() {
		if(isEmpty()) throw new NoSuchElementException("ST为空");
		return keys[n - 1];
	}
	
	public void deleteMin() {
		if(isEmpty()) throw new NoSuchElementException("ST为空，无法删除");
		delete(min());
	}

	private Key min() {
		if(isEmpty()) throw new NoSuchElementException("ST为空，没有元素");
		return keys[0];
	}
	
	public Key select(int k) {
		if(k < 0) throw new IllegalArgumentException("参数不可以为负数！");
		if(k >= n) throw new java.lang.ArrayIndexOutOfBoundsException(k);
		return keys[k];	
	}
	/**
	 * 
	* @Description   (find the largest key that is 
	* less than or equal to the given key)
	* @author zhongyikang  
	* @date Oct 10, 202012:55:42 PM  
	* @param key
	* @return
	 */
	public Key floor(Key key) {
		
		if(key == null) throw new IllegalArgumentException("key can't be null");
		
		int i = rank(key);
		
		
		//1.大于所有arry中的key
		if(i >= n) return keys[n - 1];
		
		//2.小于所有arry中的key
		if(i == 0 && key.compareTo(keys[i]) < 0) {
			return null;
		}
		
		//3. 找到了这个key
		if(i < n && key.compareTo(keys[i]) == 0) {
			return keys[i];
		}
		
		//4. 找到了大于这个key的最小元素
		return keys[i - 1];
	}
	
	
}
