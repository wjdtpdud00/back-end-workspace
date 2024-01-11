package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 변수 선언 = 클래스 주소
		OperatorPractice p = new OperatorPractice();
		//p.method1();
		//p.method2();
		//p.method3();
		//p.method4();
		//p.method5();
		p.method6();
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 키보드로 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.println("인원 수 입력");
		int people = sc.nextInt();
		System.out.println("연필 수 입력");
		int pencil = sc.nextInt();
		
		System.out.println("인당 연필 개수 : "+(pencil/people)+", 남은 연필 개수 : "+(pencil%people));
		
	}
	
	//키보드로 입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		// 산술연산자 : + 1 * / % 
		System.out.print("값을 입력하시오 >");
		// 변수 선언 = 스캐너 생성
        int number1 = sc.nextInt();
        
        System.out.println("십의 자리 이하 탈락 :");
        System.out.println((number1 - (number1%100)));
        // 432% 어떤수  > 나머지
	}
	
	//3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		// 논리연산자 boolean
		System.out.print("값을 입력하세요 >");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		System.out.println((num1 == num2) && (num2 == num3));
		
	}
	
	//키보드로 입력 받은 하나의 정수가 짝수이면 “짝수다“, 짝수가 아니면 “홀수다“를 출력하세요.
	public void method4() {
    	System.out.print("값을 입력하시오 >");
//		//변수 선언 = 입력
        int num1 = sc.nextInt();
        String result = (num1 % 2) == 0 ? "짝수다" : "홀수다";
        System.out.println(result);
//		// 입력값 % 2 = 0  짝수 != 홀수 
		// 삼항연산자 | 변수선언 = 원하는식 ? true일때  :  false 일때
		
	}
	
	//나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method5() {
		System.out.println("나이를 입력하시오 >");
		
		int age = sc.nextInt();
		
		String result = "";

		if(age <= 13) {
			result = "어린이 입니다.";
		}else if(13 < age && age <= 19) {
			result = "청소년 입니다.";
		}else {
			result = "성인 입니다.";
		}
		System.out.println(result);
		
		
	}
	
	//키보드로 사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method6() {
		System.out.println("사과의 개수는? >");
		// 바구니 크기 / 사과개수 

		
		int app = sc.nextInt();
		System.out.println("바구니의 크기는? >");
		int bas = sc.nextInt();
		int result = app%bas != 0 ? (app/bas)+1 : app/bas;
		// 사과 12 / 바구니 10 몫 1 + 1
		
		System.out.println(result + "개 의 바구니가 필요합니다.");
		// result != 0 ? ++1 : ++0
	}
	
	
	
	
	
	
	
} // 파일로 제출!