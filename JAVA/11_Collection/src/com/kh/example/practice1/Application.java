package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Application {

	
	public static void main(String[] args) {
		

		 //로또 번호가 들어갈 방 만들기
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		
//		ArrayList<Integer> lotto = new ArrayList<>();
//		Collections.sort(lotto);
		
		// set의 특징 : 1. 중복 못들어감 2. 순서가 없음
		// 랜덤값 6개 필요
		// for(int i=0; lotto.size() < 6; i++){}로 대체 가능!
		while(lotto.size() < 6){
			int num = (int)(Math.random() * 45 + 1);
			
//			if(!lotto.contains(num)) {
//				lotto.add(num);
//			}
			// 로또에 num집어넣기
			lotto.add(num);
		}
		// 중복 되었을때 5개만 들어가는 경우 생김 > 
		// 사이즈가 채워지는 함수가 필요함(조건에 lotto.size() < 6)
//		System.out.println(lotto);
		// myLotto만 무한반복 실행중!
		int count = 0;
		while(true) {
//		ArrayList<Integer> myLotto = new ArrayList<>();
		// 번호 추출 하기! 담는 공간 생성!
		TreeSet<Integer> myLotto = new TreeSet<>();
		
		while(myLotto.size() < 6) {
			int num = (int)(Math.random() * 45 + 1);
			// myLotto에 num 즉 랜덤값을 add메서드를 통해 넣는중임.
			
//			if(!myLotto.contains(num)) {
//				myLotto.add(num);
//			}
			
			myLotto.add(num);
			}
			// count로 실행 횟수 세기!
			count++;
			
			System.out.println("로또 번호 : " + lotto);
			System.out.println("내 번호 : " + myLotto);
			
			/* list타입의 배열에서만 쓰임, 정렬해주는 메소드
				Collections.sort(lotto)
				Collections.sort(myLotto);;*/
			
			//멈추는 조건 : 로또 번호와 내 번호가 정확히 일치!
			// lotto와 myLotto를 비교함.
			if(lotto.equals(myLotto)) {
				System.out.println("횟수 : " + count);
				break;
			}
			System.out.println(myLotto);
		}
		
		
	}

}
