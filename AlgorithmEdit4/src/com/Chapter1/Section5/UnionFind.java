package com.Chapter1.Section5;

public class UnionFind {
	protected static final int DEFAULT_INIT_SIZE = 10;
	
	protected int[] id;
	protected int count = DEFAULT_INIT_SIZE;
	protected int countArrVistor;
	
	public UnionFind() {
		id = new int[DEFAULT_INIT_SIZE];
		for(int i = 0; i < DEFAULT_INIT_SIZE; i ++) {
			id[i] = i;
		}
		countArrVistor = 0;
	}
	
	public UnionFind(int N) {
		id = new int[N];
		for(int i = 0; i < N; i ++) {
			id[i] = i;
		}
		countArrVistor = 0;
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	protected int find(int i) {
		resize(i);
		// TODO Auto-generated method stub
		countArrVistor ++;
		return id[i];
	}
	
	public void union(int p, int q) {
		int findP = find(p);
		int findQ = find(q);
		if(findP == findQ) return;
		
		id[findP] = findQ;
		countArrVistor ++;
		for(int i = 0; i < id.length; i ++) {
			if(id[i] == findP) {
				id[i] = findQ;
				countArrVistor += 2;
			}
		}
		count --;
	}
	
	public int getCountArrVistor() {
		return countArrVistor;
	}
	
	private void resize(int max) {
		if(max < id.length) return;
		int size;
		if(id.length * 2 < max) {
			size = max + 1;
		} else {
			size = id.length * 2; 
		}
		count += size - id.length;
		int[] tmp = new int[size];
		for(int i = 0; i < id.length; i ++) {
			tmp[i] = id[i];
		}
		id = tmp;
		
	}
	
}
