package com.kh.operator;

import java.util.Scanner;

public class D_Comparison {
	

	
	public static void main(String[] args) {
		D_Comparison d = new D_Comparison();
		//d.method1();
		d.method2();
		
	}
	public void method1() {
		int a = 10;
		int b = 25;
		
		System.out.println("a == b : " + (a == b));//false
		System.out.println("a <= b :" + (a <= b));//true
		
		boolean result = a> b;
		System.out.println("result : " + result);//false
		
		System.out.println((a * 2) > (b / 5));//true
		
		// 2로 나눴을 때의 나머지가 0인 경우 => 짝수
		// 나머지가 1인 경=> 홀수
		
		System.out.println("a가 짝수인가? : " + (a % 2 == 0)); // true
		System.out.println("b가 홀수인가?" + (b % 2 != 0));// true
		System.out.println("b가 홀수인가?" + !(b % 2 == 0));// !false =>true
		System.out.println("b가 홀수인가?" + (b % 2 == 1));// true
		
	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 입력>");
		// num1에 입력값을 저장
		int num1 = sc.nextInt();
		
		System.out.println("두번째 정수 입력 >");
		int num2 = sc.nextInt();
		
		System.out.println("첫번째 수가 두번째 수보다 큽니까" + (num1 > num2));
		System.out.println("첫번쨰 수가 짝수입니까 :" + (num1 % 2 == 0));
		
		// 문자와 숫자간의 대소비교 가능! // 숫자에도 교유값이 있음.
		System.out.println(num2 > 'A'); // A ~ Z : 65 ~ 90, a ~ z : 91 ~ 122
	}

}






