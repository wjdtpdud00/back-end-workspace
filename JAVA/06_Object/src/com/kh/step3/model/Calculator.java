package com.kh.step3.model;

public class Calculator {

	/*
	 * 메서드(method)
	 * - 작업을 수행하기 위한 명령문의 집합
	 * - 어떤 값을 입력받아서 처리하고 그 결과를 돌려준다.
	 * - 단, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음.
	 * - 하나의 메서드는 한 가지 기능만 수행하도록 작성하는 것을 권고 
	 * 
	 * 리턴타입 메서드이름(타입 변수명, 타입 변수명, ...) { <-- 여기가 입력받는 곳!
	 * 		// 메서드 호출시 수행될 코드
	 * 		return 결과값; <-- 출력하는 곳!
	 * }
	 * 
	 * return 문
	 * - 메서드에서 return문을 만나면 종료
	 * - 반환값이 없는(void) 경우 return문만 사용!
	 * - 반환값이 있는 경우 return 문 뒤에 반환값을 지정해야 함
	 * 
	 * */
	public static void main(String[] args) {
		Calculator c = new Calculator();
		// return이 있는 메소드는, 값으로 반환되기 때문에 
		// print로 출력하면됨. + 매개변수가 있으면 값을 넣여야함.
//		System.out.println(c.factorial(5));
		System.out.println(c.factorial2(3));
	}
	
	// 인스턴스 변수 선언!
	public int a, b;
	
	// 인스턴스 메서드 생성!
	public int add() {
		return a + b;
	}
	
	// 두 수의 차를 구하는 기능 : substract
	public int substract() {
		return a - b;
	}
	
	// 두 수의 곱을 구하는 기능 : multiply
	public int multiply(int a, int b) {
		return a * b;
	}
	
	// 두 수의 몫과 나머지를 구하는 기능 : divide
	// 결과값 : 몫은 3, 나머지는 2
	//[클래스 메소드 생성]
	public static String divide(int a, int b) {
		return "몫은 " + quotient(a, b) + ", 나머지는 " + remainder(a, b);
	}
	
	// 두 수의 몫을 구하는 기능 : quotient
	public static int quotient(int a, int b) {
		return a / b;
	}
	
	// 두 수의 나머지를 구하는 기능 : remainder
	public static int remainder(int a, int b) {
		return a % b;
	}
	
	/*
	 * 팩토리얼!
	 * 1! = 1
	 * 2! = 2 x 1 = 2
	 * 3! = 3 x 2 x 1 = 6
	 * n! = n x (n-1) x (n-2) x .... x 1
	 * */
	public int factorial(int n) {
		int result = 1;
		
		for(int i =n; i > 0; i--) {
			result *= i;
		}
		
		return result;
	}
	
	//[재귀함수 예시]
	// 자기 자신을 계속 호출하는 함수임
	public int factorial2(int n) {
		int result = 1;
		
		if(n!=1) result = n * factorial2(n-1);
		
		return result;
	}
	
	
	
}