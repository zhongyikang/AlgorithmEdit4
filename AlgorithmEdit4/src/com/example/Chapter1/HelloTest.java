package com.example.Chapter1;



import java.util.ArrayList;

import java.util.Iterator;

import org.junit.Test;

import com.example.Chapter1.Section5.PathCompressionWeightQuickUnionUF;
import com.example.Chapter1.Section5.QuickUnion;
import com.example.Chapter1.Section5.UnionFind;
import com.example.Chapter1.Section5.WeightQuickUnionUF;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stopwatch;



public class HelloTest {
	public static void main(String[] args) {
		//int N = StdIn.readInt();
		//PathCompressionWeightQuickUnionUF uf = new PathCompressionWeightQuickUnionUF(N);
		//WeightQuickUnionUF uf = new WeightQuickUnionUF(N);
		UnionFind uf = new UnionFind();
		//QuickUnion uf = new QuickUnion(N);
		Stopwatch timer = new Stopwatch();
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
		}
		System.out.println(uf.count());
		
		System.out.println("Time consuming:" + timer.elapsedTime());
		
		System.out.println("Times of Array access:" + uf.getCountArrVistor());
		
		
		
	}
	
	@Test
	public void test() {
		
	}
}
