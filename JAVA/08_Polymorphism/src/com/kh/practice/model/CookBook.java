package com.kh.practice.model;

public class CookBook extends Book{
	
	public CookBook(String title, boolean coupon) {
		super(title, coupon);
	}

	private boolean coupon;//요리 쿠폰 유무
	
}