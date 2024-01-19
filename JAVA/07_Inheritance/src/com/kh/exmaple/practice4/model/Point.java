package com.kh.exmaple.practice4.model;

public class Point {

	private int x;
	private int y;

	public Point() {
		
	}
// 부모클래스에 단축키로 super, field, getset, to String 생성 
	public Point(int x, int y) {
		// 값의 위치 지정
		this.x = x;
		this.y = y;
	
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "위치 : (" + x +", "+ y +"), ";
	}

	public static void Point(int x2) {
	}
	
	
}

