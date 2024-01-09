package com.kh.variable;

// # 1 형변환 
public class B_Casting {
	/*
	 * 형 변환(Casting)
	 * - 값의 타입을 다른 타입으로 변환하는 것
	 * - boolean을 제외한 7개의 기본형은 서로 형변환이 가능
	 * */
	
	public static void main(String[] args) {
		B_Casting b = new B_Casting();
		// b.autoCasting();
		b. casting();
	}
	/*
	 * 자동 형 변환(묵시적 형 변환)
	 * - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환하지 않아도 된다.
	 * */
	public void autoCasting() {
		// 정수
		byte b = 10; // 1byte
		short s = b;//2byte :  byte -> short 자동 형 변환
		int i = s;//4byte : short -> int
		long l = i;//8byte : int -> long
		// 실수
		float f = 1; // 4byte
		double d = f; // 8byte : float -> double
		
		d = i; // int -> double
		
		f = l; // long(8) -> float(4)
		// => 표현 가능한 수의 범위가 더 크기 때문에
		
		double result = 12 + 3.3;
		System.out.println(result);// 15.3
		int result2 = b + s; // byte, short 타입의 데이터는 연산시 무조건 int 타입으로 변환
		System.out.println(result2); //20
		long result3 = 30 + 30; // 30+30 = 60, 60을 long 타입으로 형 변환 (60L) --> 계산순서 : 30+ 30부터 계산이 되고,long을 만남.
		System.out.println(result3);
		long result4 = 30 + 30L; // 30L + 30L = 60L
		System.out.println(result4);
	}

/*
 * 강제 형 변환(명시적 형 변환)
 * 
 * (자료형) 데이터;
 * 
 * - 범위가 큰 크기의 자료형의 데이터를 
 *   작은 크기의 자료형으로 변환하려고 할 때 사용
 * */
public void casting() {
	double d = 4.1234568904567890; // 15자리
	System.out.println(d);
	
	float f = (float)d; // 6자리 
	System.out.println(f); // 4.123457
	
	int i = (int)f;
	System.out.println(i);// 4
	
	int sum = (int)(i + d);// 4.0 + 4.123456789012345 = 8.123456789012345
	System.out.println(sum);//8
	
	
	int sum2 = i + (int)d; // 4+4 = 8
    System.out.println(sum2);// 8
    
    int number = 128;
    byte bNumber = (byte) number;
    
    System.out.println(bNumber);// -128 // -128~127에서 해결못하니, 컴퓨터가 -128로 돌아감
    
    // char <-> int :  각 문자들마다 고유한 숫자가 지정되어 있기 때문에
    // 쌍방향으로 형변환 가능
    // char는 음수값 저장 불가 => 값으 범위가 0 ~ 6553
    
    int num = /*(int)*/'a'; // 자동 형변환 그리고 숫자별 고유값이 있다.( a -> 97 , A -> 65)
    System.out.println(num);
    
    char ch = 52143;
    System.out.println(ch); // 52143 -> 쮯
}

}


















