package com.Chapter3.Section1;

public class Exercise1 {
	public static void main(String[] args) {
		BinarySearchST<String, Double> chart = new BinarySearchST<String,Double>(11);
		chart.put("A+", 4.33);
		chart.put("A", 4.00);
		chart.put("A-", 3.67);
		chart.put("B+", 3.33);
		chart.printInfo();
		
	}

}
