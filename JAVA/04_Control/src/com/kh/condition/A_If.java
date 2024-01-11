package com.kh.condition;

import java.util.Scanner;

public class A_If {
	static Scanner sc = new Scanner(System.in);

	/*
	 * if문
	 * 
	 * if(조건식){ 조건식이 참(true)일 때 실행 }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산사를 주로 사용
	 */
	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		System.out.println("성적 입력 >");
		int score = Integer.parseInt(sc.nextLine());

		if (score >= 60) {
			System.out.println("합격입니다");
		} else
			;

//		    if(score >= 60) 
//			System.out.println("합격입니다");// 이방식 비추!
//			System.out.println("축하합니다.");//if 문 바깥(else)에 있는애로 인식함.

	}

	/*
	 * if-else 문
	 * 
	 * if(조건식){true일때 입력값} else {false 일때 입력값}
	 */
	public void method2() {
		// 입력받은 성적이 60점 이상이면 "합격입니다",
		// 아니면 "불합격 입니다." 출력
		System.out.print("성적 입력 >");
		int score = Integer.parseInt(sc.nextLine());

		if (score >= 60) {
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격 입니다.");
		}

		// 삼항연산자
		String result = 60 <= score ? "합격입니다" : "불합격입니다.";
		System.out.println(result);
	}

	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"

//		// 삼항 연산자
//		System.out.println("이름 >");
//		String name = sc.nextLine();
//		// Sting -> 참조형 변수 (클래스 변수)는 주소값을 저장!
//		String result = (name == "정세영") ? "본인이다" : "본인이 아니다";
//	    System.out.println(result);

		// (쌤풀이) 삼항 연산자

		System.out.print("이름 >");
		String name = sc.nextLine();

		System.out.println("name의 주소값 :" + System.identityHashCode(name));

		String result = (name == "정세영") ? "본인이다" : "본인이 아니다";
		System.out.println(result);// false
		// Sting -> 참조형 변수 (클래스 변수)는 주소값을 저장!
		System.out.println(name.equals("정세영"));// true

		// if 문
		System.out.println("이름 >");
		String name2 = sc.nextLine();

		if (name2.equals("정세영")) {
			System.out.println("본인이다.");
		} else {
			System.out.println("본인이 아니다.");
		}
	}

	public void method4() {
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0"이다, 작으면 "음수" 출력
//		System.out.println("숫자를 입력하시요 >");
//		int num1 = sc.nextInt();
//		
//		if(0 < num1) {
//			System.out.println("양수");
//		}else System.out.println("음수");

		// (강사님 풀이)

		System.out.println("숫자를 입력하시요 >");
		int num1 = Integer.parseInt(sc.nextLine()); // 문자를 숫자로 바꿔줌.

		// 삼항 연산자
		String result = num1 > 0 ? "양수" : num1 == 0 ? "0이다" : "음수";

		// if문
		if (num1 > 0) {
			System.out.println("양수");
		} else {
			if (num1 == 0) {
				System.out.println("0이다");
			} else {
				System.out.println("음수");
			}
		}

	}
	/*
	 * if-else if else문
	 * 
	 * if(조건식1){ 조건식1이 참(true)일 때 실행 } else if(조건식2) { 조건식1이 거짓(false) 이면서 조건식2가
	 * 참(true)일 때 실행 } else { 조건식1, 조건식2 모두 거짓(false)일 때 실행 }
	 * 
	 * - else if 수는 제한이 없다.
	 * 
	 */

	public static void method5() {

		System.out.println("숫자를 입력하시요 >");
		int num1 = Integer.parseInt(sc.nextLine()); // 문자를 숫자로 바꿔줌.

		// 삼항 연산자
		String result = num1 > 0 ? "양수" : num1 == 0 ? "0이다" : "음수";

		// if문
		if (num1 > 0) {
			System.out.println("양수");
		} else {
			if (num1 == 0) {
				System.out.println("0이다");
			} else {
				System.out.println("음수");
			}
		} // ctrl + shift + f : 자동정렬해줌.

	}

	public void practice1() {
		/*
		 * 사용자에게 점수(0~100)를 입력받아서 점수별로 등급을 출력 - 90점 이상은 A 등급 - 90점 미만 80점 이상은 B 등급 - 80점
		 * 미만 70점 이상은 C 등급 - 70점 미만 60점 이상은 D 등급 - 60점 미만 F 등급
		 */
		System.out.println("점수를 입력하시오 >");
		int score = Integer.parseInt(sc.nextLine());

//		if (score >= 90) {
//			System.out.println("A등급");
//		} else if (90 > score && score >= 80) {
//			System.out.println("B등급");
//		} else if (80 > score && score >= 70) {
//			System.out.println("C등급");
//		} else if (70 > score && score >= 60) {
//			System.out.println("D등급");
//		} else
//			System.out.println("F등급");
//	}
	
	// (강사님 풀이)
	String grade = "";
     if(score >= 90) {
    	 grade = "A";
    	 }else if(score >= 80) {
    	 grade = "B";
    	 }else if(score >= 70) {
    	 grade = "C";
    	 }else if(score >= 60) {
    	 grade = "D";
    	 }else{
    	 grade = "F";
    	 }
    System.out.println(grade);
     
     }
	public void practice2() {
		/*
		 * 세 정수를 입력 했을 때 짝수만 출력
		 * 
		 * num1 입력 > 3 num2 입력 > 4 num3 입력 > 6 4 6 3은 짝수가 아닙니다.
		 */

		// (짝수 true인 조건식) ? 트루일때 입력값 : false일때 입력값

//		 System.out.println(num1%2 == 0 ? num1 : "");
//		 System.out.println(num2%2 == 0 ? num2 : "");
//		 System.out.println(num3%2 == 0 ? num3 : "");
		
		
		System.out.println("숫자를 입력하시오>");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("숫자를 입력하시오>");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.println("숫자를 입력하시오>");
		int num3 = Integer.parseInt(sc.nextLine());
		
//		// if문 하나가지고 ! 비추천
//		if(num1 % 2 == 0) {
//			System.out.println(num1);
//		}else {
//			if(num2 % 2 == 0) {
//				System.out.println(num2);
//		}else {
//				if(num3 % 2 == 0) {
//					System.out.println(num3);}
		
		// if ~ else if 사용! 중첩 X -> 비추천!!!!
//		if(num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0) {
//			System.out.println(num1);
//			System.out.println(num2);
//			System.out.println(num3);
//		}else if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 != 0) {
//			System.out.println(num1);
//			System.out.println(num2);
//		}else if (num1 % 2 == 0 && num2 % 2 != 0 && num3 % 2 == 0) {
//			System.out.println(num1);
//			System.out.println(num3);
//		}else if (num1 % 2 == 0 && num2 % 2 != 0 && num3 % 2 != 0) {
//			System.out.println(num1);
//		}else if (num1 % 2 != 0 && num2 % 2 == 0 && num3 % 2 == 0) {
//			System.out.println(num2);
//			System.out.println(num3);
//		}else if (num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 == 0) {
//			System.out.println(num2);
//			System.out.println(num3);
//		}

		
		// (답안)
		if(num1 % 2 == 0) System.out.println(num1);
		if(num2 % 2 == 0) System.out.println(num2);
		if(num3 % 2 == 0) System.out.println(num3);
		
		
	}
	
	public void practice3() {
		/*
		 * 정수 1개를 입력했을 때 음수(minus)/양(plus)/0(zero), 짝(even)/홀(odd) 출력
		 * 
		 * 정수 입력 > -3 minus odd
		 */
		System.out.print("정수 입력 > ");
		int number = sc.nextInt();
		String result = "";
		String result2 = "";

		if(number > 0) {
			result = "plus";
		}else if(number < 0) {
			result = "minus";
		}else {
			result = "zero";
		}
		
		if(number == 0) {
			result2 = "";
		} else if(number % 2 == 0){
			result2 = "even";
		} else {
			result2 = "odd";
		}
		
		System.out.println(result);
		System.out.println(result2);
	}

	public static void main(String[] args) {
		A_If a = new A_If();
//		a.method1();
//		a.method2();
		a.method3();
//		a.method4();
//		a.method5();
//		a.practice1();
//		a.practice2();
		//a.practice3();
	}

}
