package com.Chapter1.Section5;

public class WeightQuickUnionUF extends QuickUnion{
	int[] right;
	
	public WeightQuickUnionUF(int N) {
		super(N);
		// TODO Auto-generated constructor stub
		right = new int[N];
		for(int i = 0; i < N; i ++) {
			right[i] = 1;
		}
	}

	

	@Override
	public void union(int p, int q) {
		int findP = find(p);
		int findQ = find(q);
		
		if(findP == findQ) return;
		if(right[findP] >= right[findQ]) {
			id[findQ] = findP;
			right[findP] += right[findQ];
		} else {
			id[findP] = findQ;
			right[findQ] += right[findP];
		}
		countArrVistor += 1;
		count --;
		
	}
	
	
	
	
	
}
