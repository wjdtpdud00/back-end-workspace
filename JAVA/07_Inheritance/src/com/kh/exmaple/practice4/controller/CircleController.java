package com.kh.exmaple.practice4.controller;

import com.kh.exmaple.practice4.model.Circle;

// circle 조작 먼저하고 > rectangle > application 할거임.
public class CircleController {
	

	private Circle c = new Circle();
	
	// 담을 매개변수 틀 만들기
	// return 오류 > 데이터타입이 있어야 반환가능함으로 타입지정해줘야함.
	public String calcArea(int x, int y, int radius) {
		//둘레 : PI * 반지름 * 2
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return "위치 : " + "(" + x + ", " + y + "), 반지름 : " + radius + " "
				+ " " + "/ "+ "넓이 : " + (Math.PI * radius * radius);
	}
	
	public String calcCircum(int x, int y, int radius) {
		//둘레 : PI * 반지름 * 2
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return "위치 : " + "(" + x + ", " + y + "), 반지름 : " + radius + " "
				+ " " + "/ " + "둘레 : " + (Math.PI * radius * 2);
	}



}
