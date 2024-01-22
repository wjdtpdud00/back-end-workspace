package com.kh._interface.step1;

public class Taxi implements Vehicle {
	// Vehicle에 추상메서드 재정의 필요!
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}

	@Override
	public void turn() {
		System.out.println("택시가 돕니다.");
	}
	
	
	
}
