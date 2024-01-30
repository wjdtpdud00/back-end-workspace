package com.kh.step3;

import com.kh.step3.model.Calculator;

public class Application {

	public static void main(String[] args) {
		/*
		 * 변수 호출 방법
		 * - 참조변수.변수;
		 * 
		 * 메서드 호출 방법
		 * - 참조변수.메서드명(); // 매개변수가 없는 경우
		 * - 참조변수.메서드명(값1, 값2, ....); // 매개변수가 있는 경우 
		 * */
		
		// Calculator에 대한 객체생성
		Calculator c = new Calculator();
		
		// Calculator 클래스 안에 변수 초기값 설정
		c.a = 3;
		c.b = 98;
		
		// [메소드 호출방법 익히기]
		System.out.println("더하기 : " + c.add());
		System.out.println("빼기 : " + c.substract());
		// [매개변수가 있는 메소드 호출] : 전달할 값을 넣기!필수!
		System.out.println("곱하기 : " + c.multiply(100, 20) );
		System.out.println("나누기 : " + c.divide(800, 10));
		/*
		 * 팩토리얼!
		 * 1! = 1
		 * 2! = 2 x 1 = 2
		 * 3! = 3 x 2 x 1 = 6
		 * n! = n x (n-1) x (n-2) x .... x 1
		 * */
		System.out.println("팩토리얼 : " + c.factorial(10));

	}

}





