package com.kh.step2;
/*
 * 변수의 종류
 * 1. 클래스 변수
 * - static이 들어감
 * 
 * 2. 인스턴스 변수
 * - static 외
 * 
 * 3. 로컬 변수 
 * - 메소드 안에 만들어진 변수
 * */
import com.kh.step2.model.Card;

public class Application {
	public static void main(String[] args) {
		//[클래스 변수 호출]
		// Card클래스에 public static으로 변수 만들었음
		System.out.println("width : " + Card.width);
		System.out.println("height : " + Card.height);
		
		// [클래스 변수에 초기값 설정 가능]
		// Card클래스에 대한 객체 생성
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 3;
		
		Card.width = 50;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}