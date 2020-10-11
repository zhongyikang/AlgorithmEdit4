package com.Chapter3.Section1;
/**
 * 
* @Description   使用数组实现无需符号表及其API
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Oct 11, 202011:16:00 AM  
*
 */
public class ArrayST<Key, Value> {
	private Key[] keys;
	private Value[] vals;
	private int n;
	private static final int DEFAULT_INIT_CAPACITY = 2; 
	
	public ArrayST() {
		this(DEFAULT_INIT_CAPACITY);
	}
	

	public ArrayST(int capacity) {
		keys = (Key[])new Object[capacity];
		vals = (Value[])new Object[capacity];
		n = 0;
	}
	
	public void put(Key key, Value val) {
		if(key == null) throw new IllegalArgumentException("Key can't be null!");
		for(int i = 0; i < n; i ++) {
			if(key.equals(keys[i])) {
				vals[i] = val;
				break;
			}
		}
		//不考虑resize
		keys[n] = key;
		vals[n] = val;
		n ++;
		
	}
	
	public Value get(Key key) {
		if(key == null) throw new IllegalArgumentException("Key can't be null!");
		for(int i = 0; i < n; i ++) {
			if(key.equals(keys[i])) {
				return vals[i];
			}
		}
		return null;
	}
	
}
