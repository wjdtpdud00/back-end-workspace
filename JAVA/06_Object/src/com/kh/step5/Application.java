package com.kh.step5;

import com.kh.step5.model.Book;

public class Application {

	public static void main(String[] args) {
		Book b = new Book();
		
		// set으로 값 보내기
		b.setTitle("처음부터 시작하는 주식투자 단타전략");
		b.setAuthor("홍인기");
		b.setPrice(21000);
		b.setDiscountRate(0.2);
		
		Book b2 = new Book("나는 메트로폴리탄 미술관의 경비원 입니다", 17500, 0.1, "패트릭 브링리");
		
		int discount = (int)(b.getPrice() - (b.getPrice() * b.getDiscountRate()));
		int discount2 = (int)(b2.getPrice() - (b2.getPrice() * b2.getDiscountRate()));
		
		// [b객체에 저장된 데이터 활용]
		System.out.println(b.getTitle() + "의 원래 가격은 " 
				+ b.getPrice() + ", 할인된 가격은 " + discount);
		// 처음부터 시작하는 주식투자 단타전략의 원래 가격은 21000, 할인된 가격은 16800
		
		//[b2객체에 저장된 데이터 활용]
		System.out.println(b2.getTitle() + "의 원래 가격은 "
				+ b2.getPrice() + ", 할인된 가격은 " + discount2);
		// 나는 메트로폴리탄 미술관의 경비원 입니다의 원래 가격은 17500, 할인된 가격은 15750
	}
	

}