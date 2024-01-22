package com.kh._abstract.step1;

// 추상클래스 | 추상메서드 세트임.
public abstract class Sports {
	private int numberOfPlayers; //참여하는 사람의 수
	
	public Sports(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	// 추상메서드 -> (강제성)자식 클래스에서 무조건 재정의 해주어야한다.
	public abstract void rule(); 
}
