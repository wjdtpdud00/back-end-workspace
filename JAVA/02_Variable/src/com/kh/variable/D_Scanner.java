package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {

	//#1.
	/*
	 * Scanner 
	 * - 화면(Console)으로부터 데이터를 "입력"받는 클래스
	 * 
	 * 1. import java.util.Scanner; 추가
	 * 
	 * 2. Scanner 객체 생성
	 * 	  Scanner sc = new Scanner(System.in);
	 * 
	 * 3. Scanner 메서드 사용 
	 * 	  입력값이
	 * 	  - 문자열일 때 : sc.next() - 공백이 있을 경우 공백 이전까지 
	 * 					sc.nextLine(); - 공백 포함 엔터 전까지 --> 얘만 사용하는 것을 권장!
	 * 	  - 정수일 때 : sc.nextInt();
	 * 	  - 실수일 때 : sc.nextFloat(), sc.nextDouble()	
	 * */
	
	//#2. Scanner 사용
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름은 무엇입니까? > "); // > 콘솔 결과값에 이름 입력할수 있음// enter 처리 X
		String name = sc.next(); // 변수값 생성
		sc.nextLine();// enter 처리
		
		// 엔터처리를 안해줘서 들어가는것임
		System.out.print("당신의 집은 어디십니까? > ");
		String addr = sc.nextLine();
		
		System.out.print("당신의 나이는 몇살입니까? > ");
		int age = sc.nextInt(); // enter X // nextline을 만날때까지 무한재생되어 오류뜸.
		
		System.out.print("당신의 키는 몇입니까?(소수점 첫째 자리까지 입력하세요.) > ");
		double height = sc.nextDouble();
		sc.nextLine(); // enter  
		
		System.out.print("당신의 성별은 무엇입니까? (남/여) > ");
		String input = sc.nextLine();
		char gender = input.charAt(0);// 한글자만 오게끔 만들어줌.
		
		System.out.println("당신의 이름은 " + name 
							+ "이고 사는 곳은" + addr 
							+ ",나이는 " + age 
							+ "살, 키는 " + height
							+ "cm, 성별은 " + gender + "입니다.");
							
		// --> printf 변경!
		// System.out.printf("출력하고자하는형식(포맷)", 출력하고자하는값, 값, ...);
		// 출력하고자하는 값들이 제시한 형식에 맞춰서 출력만 진행
		
		/*
		 * 포맷으로 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 * */
		System.out.printf("당신의 이름은 %s이고 사는 곳은%s,나이는 %d살, 키는 %.1fcm, 성별은 %c입니다.",
				name, addr, age, height, gender);
		
	}

}







