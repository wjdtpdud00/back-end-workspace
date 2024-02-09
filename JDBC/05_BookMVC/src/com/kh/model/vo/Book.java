package com.kh.model.vo;

public class Book {

	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private int bkPrice;
	private int pubNo;
	
	private Publisher publisher;

	public Book() {
	}

	public Book(int bkNo, String bkTitle, String bkAuthor, int bkPrice, int pubNo, Publisher bublisher) {
		super();
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.bkPrice = bkPrice;
		this.pubNo = pubNo;
		this.publisher = bublisher;
	}

	public Book(String bkTitle, String bkAuthor) {
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
	}

	public int getBkNo() {
		return bkNo;
	}

	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}

	public String getBkTitle() {
		return bkTitle;
	}

	public void setBkTitle(String bkTitle) {
		this.bkTitle = bkTitle;
	}

	public String getBkAuthor() {
		return bkAuthor;
	}

	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}

	public int getBkPrice() {
		return bkPrice;
	}

	public void setBkPrice(int bkPrice) {
		this.bkPrice = bkPrice;
	}

	public int getPubNo() {
		return pubNo;
	}

	public void setPubNo(int pubNo) {
		this.pubNo = pubNo;
	}

	public Publisher getpublisher() {
		return publisher;
	}

	public void setpublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bkNo=" + bkNo + ", bkTitle=" + bkTitle + ", bkAuthor=" + bkAuthor + ", bkPrice=" + bkPrice
				+ ", pubNo=" + pubNo + ", publisher=" + publisher + "]";
	}
	

}
