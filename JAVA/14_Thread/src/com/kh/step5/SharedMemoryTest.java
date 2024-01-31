package com.kh.step5;

// 스레드들은 공유자원을 서로 공유한다
public class SharedMemoryTest {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(cal);
		user1.start();
		User2 user2 = new User2();
		user2.setCalculator(cal);
		user2.start();
		/*
		 *  이렇게 나오는 이유??? ##모르겠음  
		 *  uesr1 = 100, user2 = 50 일때,
			CalculatorUser1 : 50
			CalculatorUser2 : 50
		*/
	}

}
