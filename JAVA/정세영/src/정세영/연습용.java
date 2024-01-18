package 정세영;

import java.util.Scanner;

import com.kh.variable.A_Variable;

public class 연습용 {
	
	public static void main(String[] args) {
		연습용 d = new 연습용();
		
	}
	
	public void method1() {
		int a = 10;
		int b = 25;
		
		System.out.println("a == b :" + (a == b)); // true
		System.out.println("a <= b :" + (a <= b)); // true
		
		boolean result = a > b;
		System.out.println("result :" + result); // false
		
		System.out.println((a * 2) > (b / 5));// 10 * 2 > 5 = 20 > 5// true
	
		System.out.println("a가 짝수인가? :" + (a % 2 == 0));//true
		
		System.out.println("b가 홀수인가?" + (b % 2 != 0));//
		

	}
		
	
	}
	










