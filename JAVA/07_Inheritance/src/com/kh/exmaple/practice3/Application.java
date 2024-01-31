package com.kh.exmaple.practice3;

import java.util.Scanner;

import com.kh.exmaple.practice3.model.Employee;

public class Application {
	Scanner sc = new Scanner(System.in);
	
public static void main(String[] args) {
	// 객체 생성
	Application app = new Application();
	
	boolean check = true;
	// 끝이 명확하지 않은 반복문, while 추천!
	while(/*~일때*/check) {
		// switch(판단할 값);
		int select = app.employeeMenu();
		switch(select) {
		case 1 : 
			app.insertEmp();
			break;
		case 2 :
			app.updateEmp();
			break;
		case 3 : 
			app.printEmp();
			break;
		case 9 :
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 번호입니다. 다시입력하세요");
		}
	}
	
}

// 반환타입이 없을때(기본값인 void일때) return만 빼고 출력
// 메인 메뉴를 출력하는 메소드
public int employeeMenu() {
	System.out.println("1. 사원 정보 추가");
	System.out.println("2. 사원 정보 수정");
	System.out.println("3. 사원 정보 출력");
	System.out.println("9. 프로그램 종료");
	System.out.println("메뉴 번호를 누르세요 : ");
	// 입력한 값을 그대로 반환!
	return Integer.parseInt(sc.nextLine());
}

// 저장할 데이터를 사용자에게 받는(저장) 메소드
public void insertEmp() {
	System.out.print("사원번호 : ");
	int empNo = Integer.parseInt(sc.nextLine());
	System.out.println("사원 이름 : ");
	String name = sc.nextLine();
	System.out.println("사원 성별 : ");
	/*
	 *  String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환해주는 녀석
	 *  
	 *  .charAt(문자 번째수);
	 * */
	char gender = sc.nextLine().charAt(0);
	System.out.println("전화 번호 : ");
	String phone = sc.nextLine();
	System.out.println("추가 정보를 더 입력하시겠습니까?(y/n) : ");
	String add = sc.nextLine();
	
	if(add.equals("y")) {
		System.out.println("사원 부서 : ");
		String dept = sc.nextLine();
		
		System.out.println("사원 연봉 : ");
//		int salary = Integer.parseInt(sc.nextLine());
		double salary = Integer.parseInt(sc.nextLine());
		System.out.println("보너스 율 : ");
		int bonus = Integer.parseInt(sc.nextLine());
		
	} else {
		// 연속으로 정보를 추가하고 싶은경우
//		System.out.println("전화 번호 : ");
//		String phone = sc.nextLine();
//		System.out.println("추가 정보를 더 입력하시겠습니까?(y/n) : ");
//		String add = sc.nextLine();
	}
	
	}

// 수정할 데이터를 사용자에게 받는 메소
public void updateEmp() {
	System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
	System.out.println("1. 전화번호");
	String phoneUpdate = sc.nextLine();
	System.out.println("2. 사원연봉");
	double salaryUpdate = sc.nextDouble();
	System.out.println("3. 보너스 율");
	int bonus = Integer.parseInt(sc.nextLine());
	System.out.println("9. 돌아가기");
	// 조건문 필요! 각각의 케이스가 필요! switch문 추천!
	// 사용자 입력값을 저장
	int select = Integer.parseInt(sc.nextLine());
	
	Employee e = new Employee();
	
	switch(/*판단할 값*/select) {		
		case 1:
			System.out.println("전화 번호 입력 : ");
			String phone = sc.nextLine(); // 입력 버튼 
			//생성자 > 주소로호출
			e.setPhone(phone);
			e.getPhone();
			System.out.println(phone);
			break;
		case 2:
			System.out.println("사원 연봉 입력 : ");
			break;
		case 3:
		// 사원 정보 출력
		System.out.println("보너스 율 입력 :");
			break;
	}
	
	
}
// 데이터를 출력하는 메소드
public void printEmp() {
	
}
	
}
