package com.kh.operator;

import java.util.Scanner;

// #1 논리 연산자 사용
public class E_Logical {
	E_Logical e = new E_Logical();
	

public void method1() {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("정수값을 입력해 주세요 >");
	//number에 입력값 저장
	int number = sc.nextInt();
	boolean result =  1 <= number && number <= 100;
	
	System.out.printf("%d는 1부터 100 사이의 값인가요? : %b", number, result );
}

}


















