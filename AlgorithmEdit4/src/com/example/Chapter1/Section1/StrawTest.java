package com.example.Chapter1.Section1;

import org.junit.Test;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdDraw;

public class StrawTest {

	@Test
	public void test1() {
		int N = 100;
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0, N * N);
		
		StdDraw.setPenRadius(0.01);
		
		for(int i = 1; i < N; i ++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i * i);
			StdDraw.point(i, i * Math.log(i));
		}
	}
	
	@Test
	public void test2() {
		
	}
	
	public static void main(String[] args) {
		Draw draw = new Draw();
		draw.setXscale(0,10);
		draw.setYscale(0,10);
		StdDraw.setPenRadius(0.01);
		draw.line(3, 4, 2, 7);
	}
}
