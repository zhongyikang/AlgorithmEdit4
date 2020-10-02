package com.example.Chapter1;
/**
 * 
* @Description   自动发牌器，使用RandomQueue。
* @author zhongyikang  Email:2472082117@qq.com 
* @version   
* @date Sep 29, 20202:21:21 PM  
*
 */
public class AutomaticDealer {
	public static void main(String[] args) {
		RandomQueue<String> queue = new RandomQueue<String>();
		for(int i = 0; i < 13; i ++) {
			for(int j = 0; j < 4; j ++) {
				String color = "";
				String number = "";
				String Card;
				switch(i + 1) {
				case 1: number = "A"; break;
				case 11: number = "J"; break;
				case 12: number = "Q"; break;
				case 13: number = "K"; break;
				default: number = "" + i;
				}
				switch(j + 1) {
				case 1: color = "梅花"; break;
				case 2: color = "红心"; break;
				case 3: color = "方片"; break;
				case 4: color = "黑桃"; break;
				}
				Card = color + number;
				queue.enqueue(Card);
			}
		}
		
		for(int i = 0; i < 4; i ++) {
			System.out.println("Number" + i + "'cards:");
			for(int j = 0; j < 13; j ++) {
				String item = queue.dequeue();
				System.out.print(item + " ");
				if(j == 9) {
					System.out.println();
				}
			}
			System.out.println();
		}
	
	}
}
