// 클래스 이름 : com.kh.practice.VariablePractice
// FQCN(Fully Qualified Class N)
package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		//v.method1();
		//v.method2();
		//v.method4();
		//v.method5();
		//v.method6();
		//v.method7();
		//v.method8();
		//v.method9();
		//v.method10();
		v.method11();
		
	}
	/*
	 * 영화관의 요금표 문제
	 * - 성인 10000dnjs
	 * */

	
	public void method1() {
		
		int adultPrice = 10000;
		int teenPrice = 7000;
		int adultCount = 2;
		int teenCount = 3;
		
		int adultTotal = adultPrice * adultCount;
		int teenTotal = teenPrice * teenCount;
		
		System.out.printf("성인 2명 : %d원\n", adultCount, adultTotal);
		System.out.printf("청소년 %d명 : %d원\n\n", teenCount, teenTotal);
		System.out.printf("총 금액 : %d원", adultTotal + teenTotal);
		
		
	}
	
	public void method2() {
		
		int x = 5;
		int y = 7;
		int z = 9;
		
		int tmp = x; //임시 변수 저장
		x = y;
		y = z;
		z = tmp;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);	
		
	}
	
	//영어 문자열 값을 키보드로 입력 받아 문자에서 첫번째 글자와 마지막 글자를 출력하세요.
	public void method3() {
		System.out.println("문자열을 입력하세요 :");
		String str = sc.nextLine();
		
		System.out.println("첫번째 문자 :" + str.charAt(0));
		System.out.println("마지막 문자 :" + str.charAt(str.length()-1));
		
	}
	
	//casting practice팩키지 따로 만들기
	public void method4() {
		System.out.println("문자 :");
		char ch = sc.nextLine().charAt(0);
		
		int num =  ch; 
		System.out.println(ch + "unicode : " + num);
		
		char ch2 = (char)(num + 1); //char로 형변환 시키기.
		System.out.println(ch2 + "unicode :" + (int)ch2);	
	}
	
	public void method5() {
		
		System.out.println("국어 : ");
		int kScore = sc.nextInt();
		System.out.println("영어 : ");
		int eScore = sc.nextInt();
		System.out.println("수학 : ");
		int mScore = sc.nextInt();
		
		int sum = kScore + eScore + mScore;
		System.out.println("총점 : " + sum);
		System.out.printf("평균 : %.2f" + (double)sum / 3);
		 	
	}
	
	// operator 패키지
	public void method6() {
		System.out.print("인원 수 : ");
		int person = sc.nextInt();
		
		System.out.print("연필 개수 : ");
		int pencil = sc.nextInt();
		
		System.out.println("1인당 연필 개수 : " + (pencil / person));
		System.out.println("남은 연필 개수 :" + (pencil % person));
	}
	public void method7() {
		System.out.println("숫자 : ");
		int num = sc.nextInt();
		
		System.out.println((num / 100) * 100);
	}
	public void method8() {
		System.out.print("첫번째 수 :");
		int num1 = sc.nextInt();
		
		System.out.println("두번째 수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("세번째 수");
		int num3 = sc.nextInt();
		
		boolean result = num1 == num2 && num2 == num3;
		System.out.println(result);
	}
	
	public void method9() {
		System.out.println("정수 : ");
		int num = sc.nextInt();
		
		String str = num % 2 == 0 ? "짝수다" : "홀수다";
		System.out.println(str);	
	}
	public void method10() {
		System.out.println("나이 입력: ");
		int age = sc.nextInt();
		
		String str = age <= 13 ? "어린이" : age <= 19 ? "청소년" : "성인";
		str = age > 19 ? "성인" :  age > 13 ? "청소년" : "어린이";
		System.out.println(age);
	}	
	public void method11() {
		System.out.print("사과의 개수 : ");
		int apple = sc.nextInt();
		
		System.out.println("바구니 1개당 들어가는 사과의 개수 : ");
		int count = sc.nextInt();
		
		// 나누어떨어졌을 때는 문제X, 나누어 떨어지지 않았을 때 +1
		System.out.println(apple / count + (apple % count == 0 ? 0 : 1));
		

	}	

	
	
	
	
	
	
	
	
	
	
	
}





