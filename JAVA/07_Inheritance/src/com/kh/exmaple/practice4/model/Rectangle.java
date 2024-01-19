package com.kh.exmaple.practice4.model;

import com.kh.exmaple.practice4.model.Point;

public class Rectangle extends Point {
	private int width;
	private int height;
	
	public Rectangle () {
		
	}
	public Rectangle (int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "위치 : ()" + super.getX() +"," + super.getY() + "), 너비 : "+ width +  
				"높이 :" + height + "/";
	}

	

}
