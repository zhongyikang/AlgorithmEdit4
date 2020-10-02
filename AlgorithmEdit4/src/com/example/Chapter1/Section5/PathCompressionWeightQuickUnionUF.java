package com.example.Chapter1.Section5;

public class PathCompressionWeightQuickUnionUF extends WeightQuickUnionUF{

	public PathCompressionWeightQuickUnionUF(int N) {
		super(N);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int find(int i) {
		//1. find the parent Node
		int fNode = super.find(i);
		//2. refind and connect the son nodes to the parent node
		while(i != id[i]) {
			int tmp = i;
			i = id[i];
			id[tmp] = fNode;
			countArrVistor += 3;
		}
		
		return fNode;
	}
	
	
}
