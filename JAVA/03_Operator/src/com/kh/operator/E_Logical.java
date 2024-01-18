package com.kh.operator;

import java.util.Scanner;

// #1 논리 연산자 사용
public class E_Logical {

	public static void main(String[] args) {
		E_Logical e = new E_Logical();
//		e.method1();
		//e.method2();
		e.practice();
	}
	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100 사이의 값인지 확인
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값을 입력해 주세요 >");
		int number = sc.nextInt();
		boolean result = 1 <= number && number <= 100; 
		
		System.out.printf("%d는 1 부터 100 사이의 값인가요? : %b", number, result);
		
	}
	
	public void method2() {
		// Short Cut Evaluation
		int number = 10;
		boolean result = false;// boolean의 초기값 기본은 false
		// --> 변수들 초기화부터 지정하고자 할 때!
		
		// &&(그리고) 적용 예시
		// true && true = true
		// true && false = false
		// false && true = false
		// false && false = false
		
		// && 연산자를 기준으로 앞에서 이미 false이기 때문에 굳이 뒤쪽의 연산은 수행하지 않는다.	
		result = (number < 5) && (++number > 0); // false && true = false -- false가 뜨면 뒤에는 계산X
		System.out.println(result); //false
		System.out.println(number);// 10
		
		// ||(또는) 적용 예시
		// true || true = true
		// false || true = true
		// true || false = true
		// false || false = false
		
		result = (number < 20) || (++number > 0);// 앞이true일때, 뒤에 계산 x
		
		System.out.println(result);// true
		System.out.println(number);// 10 
		
		// 예시 -> 로그인
	}
	
	//#2. 실습문제 - 코드를 치면서 복습!, 수업 순서 표시해놓기!
	/*
	 * 실습문제
	 * 
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기
	 * A ~ Z : 65 ~ 90 , a ~ z : 97 ~ 122
	 * */
	public void practice() {
		
		Scanner sc = new Scanner(System.in); // $문자를 읽어준다.
		char ch = '\u0000';
		boolean result = false;
		
		System.out.print("문자 입력 >");
		//String text = sc.nextLine(); // ch = text.charAt(0)를 합침.(아래)
		ch = sc.nextLine().charAt(0); // 한글자만 담겠다.
		
		
		result = ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z');
		System.out.println(result);
		
	}
}




















