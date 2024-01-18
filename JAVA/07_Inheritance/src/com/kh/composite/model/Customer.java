package com.kh.composite.model;

/*
 * 클래스 간의 관계 : 상속 vs 포함
 * - 상속 관계 : ~은 ~이다. (is-a)
 * - 포함 관계 : ~은 ~을 가지고 있다. (has-a)
 * - 자바는 단일상속만 허용(C++는 다중 상속 허용)
 * - 클래스 간의 관계를 많이 맺을수록 재사용을 높이고 관리하기 쉽게 한다.
 * */

public class Customer {
	// 인스턴스 변수들은 DB에서 컬럼들과 매칭된다.
	protected String name; // 고객 이름
	protected String grade;// 고객 등급
	protected int bonusPoint; // 보너스 포인트
	protected double bonusRatio; //포인트 적립 비율
	
	Product product;// 포함관계
	
	
	public Customer() {
		System.out.println("기본생성자로 만듦");
	}
	public Customer(String name) {
		this.name = name;
		this.grade = "SILVER";
		this.bonusRatio = 0.01;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", grade=" + grade + ", bonusPoint=" + bonusPoint + ", bonusRatio="
				+ bonusRatio + "]";
	}
	@Override// <- 어노테이션! '이 메서드는 재정의된 메서드이다.'라고 명확히 알려주는 역할
	public boolean equals(Object obj) {
		// 매개변수 받기
		// customer로 형변환 > 변수에 저장
		Customer c = (Customer) obj;// 다형성!
		return this.name == c.name;
	}
	
	// calcPrice만든후 가격넣기
	public int calcPrice(int price) {
		this.bonusPoint += price * bonusRatio;// 보너스 포인트 계산 포함
		return price;
		
	}
}
