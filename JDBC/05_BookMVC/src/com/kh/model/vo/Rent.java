package com.kh.model.vo;

import java.util.Date;

public class Rent {
	private int rentNo;
	private int bkNo;
	private Book Book;
	private Date rentDate;
	public Rent() {
	}
	public Rent(int rentNo, int bkNo, com.kh.model.vo.Book book, Date rentDate) {
		super();
		this.rentNo = rentNo;
		this.bkNo = bkNo;
		Book = book;
		this.rentDate = rentDate;
	}
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public int getBkNo() {
		return bkNo;
	}
	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}
	public Book getBook() {
		return Book;
	}
	public void setBook(Book book) {
		Book = book;
	}
	public Date getRentDate() {
		return rentDate;
	}
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	@Override
	public String toString() {
		return "Rent [rentNo=" + rentNo + ", bkNo=" + bkNo + ", Book=" + Book + ", rentDate=" + rentDate + "]";
	}
	
	
}
