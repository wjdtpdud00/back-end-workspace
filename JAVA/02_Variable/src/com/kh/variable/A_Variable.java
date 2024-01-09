package com.kh.variable;

public class A_Variable {
//#1 메인 메소드 생성됨

	/*
	 * 변수(Variable) - 값을 저장하는 "공간"
	 */

//#3 출력방법 알고가기	데이터타입, 변수명 = new 변수() ;
	public static void main(String[] args) {
		// 실행할 메소드가 있는 클래스를 생성(new)
		A_Variable variable = new A_Variable();

		// 생성한 클래스로 메소드 실행(호출)
//		variable.printValue();
		//variable.variableTest();
		variable.constant();
	}

// #2 안뜨는이유 : 메인메소드에 있는것만 실햄하기 때문이다.
//	public void printValue() { // 메서드명 같은게 있으면 어떤걸 호출할지 못 찾아서 안됨!
//		System.out.println("TEST");
//	}

// #4 변수이용 예시	
	public void printValue() {

		// Console에 원의둘레와 원의 넓이를 출력하시오.
		// 원의 둘레 = 반지름(10) x 2 x 3.121592
		// 원의 넓이 = 반지름(10) x 반지름(10) x 3.141592

		// 변수를 사용하지 않으면서
		System.out.println(10 * 2 * 3.141592);
		System.out.println(10 * 10 * 3.141592);

		System.out.println("----------------------------------");

		// 변수를 사용하면
		int r = 10;
		double pi = 3.141592;

		System.out.println(r * 2 * pi);
		System.out.println(r * r * pi);
	}
	// #5 새로운 메소드 생성
	public void variableTest() {
		/*
		 * * 변수의 선언 
		 * 
		 *  자료형 변수명;
		 *  
		 *  - 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리를 할당 받을지에 대한 정보가 담긴다.
		 *  - 변수명 : 변수의 이름으로 값을 읽고, 쓰고, 지우는 작업을 할 때 사용
		 *  
		 *  * 변수의 초기화 
		 *  
		 *  변수명 = 값; 
		 *  
		 *  - 변수에 처음으로 값을 저장하는 것
		 *  - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자
		 *  
		 * */
		
		//* 기본 자료형(Primitive type) : 실제 값을 저장
		// 스택 메모리에 생성된 공간에 실제 변수값이 저장
		//1. 논리형 : 1byte(=8bit)
		boolean isTrue; // 변수 선언
		isTrue = true; // 변수 초기화
		
		boolean isFalse = false;
		// isFalse = 1; 데이터타입 미지정 에러발생!
		
		// 2. 문자형 ("" 사용 x, 두글자 이상 x) : 2byte(=16bit)
		char ch = 'a'; 
		// ch = 'ab'; 두글자 사용으로 에러발생! 
		
		// 3. 정수형 
		byte bNum = 1; // 1byte 일때 (-128 ~127 | 256 = 2^8) 까지만 사용가능
		// bNum = 128; 에러 발생! -> 오버플로우(Overflow)
		short sNum = 128; // 2byte 
		int iNum = 922337283; // 4byte (기본)
		long lNum = 922337283458L; // 8byte - 숫자 뒤에 L(l)을 입력
		
		System.out.println(lNum);
		
		// 4. 실수형
		float fNum = 1.2F; // 4byte - 숫자 뒤에 F(f)를 입력
		double dNum = 1.2; // 8byte (기본)
		
		System.out.println(fNum);
		
		// * 참조 자료형 :  4byte, 기본형을 제외한 나머지 (클래스) - 주소 값을 저장
		// 실제 데이터 값은 힙 메모리에 저장하고,
		// 스택 메모리의 변수 공간에는 실제 변수값이 저장된 힙 메모리의 위치값을 저장
		String name = "이상현";
		String name2 = new String("이상현");
		System.out.println(name2);
		
		// 변수의 네이밍 규칙
		// 1. 대소문자 구분한다.
		int number; 
		//String number; 자료형이 달라도 변수명이 같으면 에러 발생
		int NUMBER;
		int Number;
		
		// 2. 숫자로 시작하면 안 된다.
		//int 1age; 
		int a2g3e4;
		
		// 3. 특수 문자는 '_', '$'만 사용이 가능하다.
		int _age;
		int a_g_e;
		int age$;
		//int %age; 위의 특수문자 외엔 불가
		//int age@;
		
		// 4. 예약어(Reserved word)를 사용하면 안 된다.
		//int public;
		//int void;
		// int int;
		// int class;  - class2는 명령어가 아니라 가능!
		
		// 5. (권장사항) 낙타표기법(카멜케이스)
		// 첫글자는 항상 소문자, 여러 단어가 오면 대문자로 구분
		int maxnumber; // 예시문
		int max_number;// 자바에서 X
		int maxNumber; // 낙타표기법
	}
	public void constant() {
		/*
		 * 상수
		 * 
		 * final 자료형 변수명;
		 * 
		 * - 변하지 않는 값으로 특정 변수의 값이 변경되는 걸 원하지 않을 때 사용
		 * - 초기화 이후에는 값을 변경할 수 없다.
		 * 
		 * */
		int age = 20;
		age = 25;
		System.out.println(age);
		
		final int AGE = 30;
//		AGE = 35;  에러 발생, 자바는 에러 난 부분을 빨간텍스트로 알려줌.
		System.out.println(AGE); 
		
	}
}















































