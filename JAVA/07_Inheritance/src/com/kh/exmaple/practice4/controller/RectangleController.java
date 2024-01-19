package com.kh.exmaple.practice4.controller;

import com.kh.exmaple.practice4.model.Rectangle;
import com.kh.exmaple.practice4.model.Point;

public class RectangleController extends Point{
	// 
	Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		// 넓이 : 너비 * 높이
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r + "넓이 :" + (height * width);
	}
	public String calcPerimeter(int x, int y, int height, int width) {
		// 둘레 : 2 *(너비 + 높이)
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r + "둘레 :" + (2*(height * width));
	}
}
