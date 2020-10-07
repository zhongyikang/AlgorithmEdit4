package com.Chapter2.Section4;

import java.util.Comparator;

public class MaxPQ1<Key>{
	 	private Key[] pq;                    // store items at indices 1 to n
	    private int n;                       // number of items on priority queue
	    private Comparator<Key> comparator;  // optional comparator
	    
	    public MaxPQ1(int initCapacity) {
	    	pq = (Key[]) new Object[initCapacity + 1];
	    	n = 0;
	    }
	    
	    public void insert(Key key) {
	    	pq[++n] = key;
	    	swim(n);
	    }

		private void swim(int k) {
			while(k != 1 && less(k / 2, k)) {
				exch(k/2, k);
				k /= 2;
			}
		}
		
		public Key delMax() {
			if(n == 0) {
				System.out.println("Empty queue and nothing to delete");
				return null;
			}
			Key tmp = pq[1];
			exch(1, n--);
			pq[n + 1] = null;
			sink(1);
			return tmp;
			
		}

		private void sink(int k) {
			while(2 * k <= n) {
				//找 两个子节点中最大的
				int j = k * 2;
				if(j < n && less(j, j + 1)) j = j + 1;
				
				//k >= j, 结束sink
				if(!less(k, j)) break;
				
				//非以上情况， 交换。
				exch(k, j);
				k = j;
			}
		}

		private void exch(int i, int j) {
			Key tmp = pq[i];
			pq[i] = pq[j];
			pq[j] = tmp;
			
		}

		private boolean less(int i, int j) {
			return comparator.compare(pq[i], pq[j]) < 0;
		}

	    
}
