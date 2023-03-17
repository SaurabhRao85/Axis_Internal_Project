package com.axis.service;

import java.util.Random;

public class CardNumber {

	
	public static void main(String[] args) {
		long cardNumber =0l;
		Random rand = new Random();
		
		cardNumber = (rand.nextLong(1000000)+1000000000000000l)+(rand.nextInt(900)+100);
		System.out.println(cardNumber);
	}
}
