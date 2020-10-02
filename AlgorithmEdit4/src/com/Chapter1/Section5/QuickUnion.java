package com.Chapter1.Section5;

public class QuickUnion extends UnionFind{

	public QuickUnion(int N) {
		super(N);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int find(int i) {
		while(i != id[i]) {
			i = id[i];
		}
		
		
		countArrVistor += 2;
		return i;
	}
	
	public int PathCompressionFind(int i) {
		int fNode = find(i);
		while(i!= id[i]) {
			int tmp = i;
			i = id[i];
			id[tmp] = fNode;
		}
		return fNode;
	}

	@Override
	public void union(int p, int q) {
		int findP = find(p);
		int findQ = find(q);
		
		if(findP == findQ) return;
		
		id[findP] = findQ;
		countArrVistor ++;
		count --;
	}

	
	
}
