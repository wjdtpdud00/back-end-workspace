package com.kh._abstract.step1;

public class BasketBall extends Sports {
	
	protected int numberOfPlayers; //참여하는 사람의 수
	
	public BasketBall(int numberOfPlayers) {
		super(numberOfPlayers);
	}
	
	
	public void rule() {
		System.out.println("BasketBall의 선수의 수는" + this.numberOfPlayers 
												  + "명, 공을 던져서 링에 넣어야한다.");
	
	}
}
