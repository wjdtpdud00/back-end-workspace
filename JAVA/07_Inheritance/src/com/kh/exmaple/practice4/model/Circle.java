package com.kh.exmaple.practice4.model;

public class Circle extends Point{
	private int radius;
	
	public Circle () {
		
	}
	public Circle (int x, int y, int radius) {
		// 값을 받아옴.
		super(x, y);
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		return "위치 : " + "(" + super.getX() + ", " + super.getY() + "), 반지름 : " + radius + " "
				+ " " + "/ ";
	}

	
	
}
