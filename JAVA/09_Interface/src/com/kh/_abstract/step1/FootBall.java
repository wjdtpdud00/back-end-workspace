package com.kh._abstract.step1;

public class FootBall extends Sports {
	
	private int numberOfPlayers; //참여하는 사람의 수
	
	public FootBall(int numberOfPlayers) {
		super(numberOfPlayers);
	}
	
	public void rule() {
		System.out.println("FootBall의 선수의 수는 " + numberOfPlayers 
									 + "명, 손이 아닌 발로 공을 차야한다.");
	}  
}
