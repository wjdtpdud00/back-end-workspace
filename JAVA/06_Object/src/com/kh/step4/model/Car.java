package com.kh.step4.model;

public class Car {
	
	// private : 범위 같은 클래스 내에서만 접근 가능!
	private String color; // 색상
	private String gearType; // 자동 or 수동
	private int door; // 문의 개수
	
	
	// 생성자 오버로딩! > 매개변수만 다르게 넣는것
	public Car() {}
	
	public Car(String color, String gearType, int door) {
		//this : 자신을 가리키는 참조변수. 객체 주소가 저장되어있음
		this(color, gearType);
		this.door = door;
	}
	
	public Car(String color, String gearType) {}
	

	@Override //class Car에 대한 리턴값 재정의
	public String toString() {
		return "Car [color=" + color + ", gearType=" + gearType + ", door=" + door + "]";
	}

}