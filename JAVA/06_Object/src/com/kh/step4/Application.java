package com.kh.step4;

/* [오버로딩(Overloading)]
 * 자바의 한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메소드가 
 * 있더라도 매개변수의 개수 또는 타입 또는 순서가 다르면, 같은 이름을 
 * 사용해서 메소드를 정의할 수 있다.
 * */

public class Application {

	void test(int a) {}
	
	void test(int a, String s) {}
	
	void test(String s, int a) {}

}



