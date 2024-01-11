package 정세영;

import com.kh.variable.A_Variable;

public class 연습용 {

	public static void main (String[] args){
		연습용 b = new 연습용();   
		//b.autoCasting();
		b.casting();

	}
	
	public static void autoCasting() {
		
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
		System.out.println(result);
		
		
		int result2 = b + s;  // 10 + 10  byte, short > int로 바뀜.
		
		long result4 = 30 + 30L; // LONG 단위로 다 바뀜. >> 인트와 롱 경우처럼 큰 단위로 바뀜.
	}	
	
	public void casting() {

	    // char <-> int :  각 문자들마다 고유한 숫자가 지정되어 있기 때문에
	    // 쌍방향으로 형변환 가능
	    // char는 음수값 저장 불가 => 값으 범위가 0 ~ 6553
	    
	    int num = /*(int)*/'a'; // 자동 형변환 그리고 숫자별 고유값이 있다.( a -> 97 , A -> 65)
	    System.out.println(num);
	    
	    char ch = 52143;
	    System.out.println(ch); // 
	}

}








