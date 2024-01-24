package com.kh.practice.model;

public class Book {
	private String title;// 도서명
	private boolean Coupon;//쿠폰
	private int accessAge;
	
	// 생성자 
	public Book(String title, boolean coupon) {
		this.title = title;
		this.Coupon = coupon;

	}
	
	public Book(String title, int accessAge) {
		this.title = title;
		this.accessAge = accessAge;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

// boolean getter기본형태 is사용
	public boolean isCoupon() {
		return Coupon;
	}

	public void setCoupon(boolean coupon) {
		Coupon = coupon;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", Coupon=" + Coupon + ", accessAge=" + accessAge + "]";
	}
	
	

}
