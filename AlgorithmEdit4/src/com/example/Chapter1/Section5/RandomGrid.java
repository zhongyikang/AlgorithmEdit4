package com.example.Chapter1.Section5;

import java.util.Iterator;

import com.example.Chapter1.RandomBag;

import edu.princeton.cs.algs4.StdIn;

public class RandomGrid {
/**
 * 1. ����һ������N
 * 2. ��N* N�ֶ�
 * 3. ����Connection����ʽ�����RandomBag�С�
 */
	
	public static Collection[] generate(int N) {
		RandomBag<Collection> bag = new RandomBag<>();
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j ++) {
				bag.add(new Collection(i, j));
			}
		}
		
		Collection[] res = new Collection[N * N];
		int index = 0;
		Iterator<Collection> iterator = bag.iterator();
		while(iterator.hasNext()) {
			res[index ++] = iterator.next();
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		Collection[] collections = generate(N);
		for(int i = 0; i < collections.length; i ++) {
			System.out.println(collections[i]);
		}
	}
}
