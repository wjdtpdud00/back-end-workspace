package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {
	
	/*
	 * 변수 : 하나의 공간에 하나의 값을 담음
	 * 배열 : 하나의 공간에 "여러개의 값"(같은 자료형의 값)을 담음
	 * 
	 * 1. 배열의 선언
	 * 	
	 * 	  자료형[] 배열명; 
	 * 	  자료형 배열명[];
	 * 
	 * 	  - 배열을 선언한다고 해서 값을 저장할 공간이 생성되는 것이 아니라 
	 *      배열을 다루는데 필요한 변수가 생성
	 * 
	 * 2. 배열의 초기화
	 * 
	 * 	  배열명 = new 자료형[배열크기];
	 * 
	 * 	  - 생성된 배열에 처음으로 값을 저장 
	 * 
	 * 3. 배열의 선언과 초기화 동시 진행
	 * 
	 * 	  자료형[] 배열명 = new 자료형[배열크기];
	 * 	  자료형 배열명[] = new 자료형[배열크기];
	 * */
	
	/*
	 * [변수의 초기값]
	 * 
	 * 1. 클래스 변수(클래스에 위치)
	 * - static : null
	 * 2. 인스턴스 변수(클래스에 위치)
	 * - (정수형 : 0, 실수형 : 0.0, 문자형 : \u0000, 논리형 : false, 참조형 : null)
	 * 3. 지역 변수(메소드안에 위치)
	 * - (정수형 : 0, 실수형 : 0.0, 문자형 : \u0000, 논리형 : false, 참조형 : null)
	 * */
	
	/*
	 * [자료형 종류]
	 * 1. 원시 자료형
	 * - string, boolean, int 등..
	 * - null값을 가짐
	 * 2. 참조 자료형
	 * - array, java기본함수
	 * - 초기값 필요없음
	 * */
	// ---------------------------------------------------------------------------------------------------------------
	//[ 배열의 선언 및 초기화 살펴보기]
	public void method1() {
		int[] nums = new int[5];
		System.out.println(nums);
		
		// [배열의 기본값]
		// 배열은 heaps에서 주소로 저장됨, String으로 바꿔야 값으로 보임.
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		
		// 기본값 넣어보자
		nums[0] = 100;
		nums[1] = 70;
		nums[2] = 90;
		nums[3] = 80;
		nums[4] = 60;
		
		// 값이 넣어지는것 확인!
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		
	}
	
	// [배열 선언과 동시에 값들 초기화]
	public void method2() {
		int[] nums = {100, 70, 90, 80, 60};
		
		// for문으로 전체 확인
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	/*
	 * 3명의 키를 입력받아 배열에 저장하고 3명의 키의 평균값을 구하시오
	 * 키 입력 > 180
	 * 키 입력 > 177.3
	 * 키 입력 > 168.2
	 * 175.2
	 * */
	/*
	 * printf 사용법
	 * %d : 정수
	 * %f : 실수 
	 * %c : 문자
	 * %s : 문자열
	 * 
	 *\n : 줄바꿈
	 *\t : tab
	 * */
	public void method3() {
		// 3명의 값을 받는다.
		Scanner sc = new Scanner(System.in);
		double[] arr = new double[3];
		// 평균값 담을 변수 
		double sum = 0;
		
		// 끝이 명확히 있는 반복은 for
		// 3번 돌아감
		for(int i = 0; i < arr.length; i++) {
			System.out.println(" 키 입력 > ");
			arr[i] = sc.nextInt();
			
			sum += arr[i];
			
		// printf를 이용하여 평균값으로 나타내기
		} System.out.printf("%.1f", sum/arr.length);

	}
	
	//[배열의 복사]
	// 1. 얕은 복사 : 배열의 주소만 복사
	public void method4() {
		int[] number = {1, 2, 3, 4, 5};
		
		// 다른 변수에 담아보는중
		int[] copy = number;
		
		// 결과 확인 > 주소만 복사됨.
		System.out.println(number);
		System.out.println(copy);
		
		// 주소값으로 들어가서 number만 바뀌는 상태이다.
		copy[1] = 20;
		System.out.println(Arrays.toString(number));	
		System.out.println(Arrays.toString(copy));	
	}

	// 2. 깊은 복사 : 동일한 새로운 배열을 하나 생성해서 내부 값들도 함께 복사
	// 1) for 문을 이용한 깊은 복사
	
	//(얘만 알면 됨!) 배열의 clone() 메서드를 이용한 깊은 복사 
	public void method8() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = number.clone();
		
		System.out.println(number);
		System.out.println(copy);
		
		copy[3] = 20;
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
	}
	
	public void method5() {
		// copy에 number의 방개수 복사
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int[number.length];
		
		// copy방 안에 하나씩 넣는중
		for(int i=0; i<number.length; i++) {
			copy[i] = number[i];
		} 
		System.out.println(number);
		System.out.println(copy);
		
		copy[1] = 20;
		
		// number와 copy값이 다르다! 즉, copy에 값이 복사된 것이다.
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}
	
	
	// 2) System 클래스에서 제공하는 arraycopy() 메서드를 이용한 깊은 복사 
	//    System.arraycopy(원본배열, 복사시작인덱스, 복사본배열, 복사시작인덱스, 복사할길이);
	public void method6() {
		// 방 복사
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int[number.length];
		
		// 배열 값  복사!
		// System.arraycopy(원본배열, 복사시작인덱스, 복사본배열, 복사시작인덱스, 복사할길이);
		System.arraycopy(number, 0, copy, 0, number.length);
		
		// 확인!
		System.out.println(number);
		System.out.println(copy);
		
		// copy배열에 값 넣기
		copy[2] = 30;
		
		// 확인! > 배열값이 서로 다름! 
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}
	
	// 3) Arrays 클래스에서 제공하는 copyOf() 메서드를 이용한 깊은 복사
	//    Arrays.copyOf(원본배열, 복사본배열길이);
	public void method7() {
		
		// copyOf 함수를 이용한 깊은 복사 시도
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = Arrays.copyOf(number, number.length);
		
		// 주소값 다름 확인!
		System.out.println(number);
		System.out.println(copy);
		
		// copy에 값 넣기
		copy[3] = 10;
		
		// 깊은복사 확인
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}

	public static void main(String[] args) {
		A_Array a = new A_Array();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.method7();
		a.method8();

		
	}

}