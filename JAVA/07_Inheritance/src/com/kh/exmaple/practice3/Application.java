package com.kh.exmaple.practice3;

import java.util.Scanner;

import com.kh.exmaple.practice3.controller.EmployeeController;
import com.kh.exmaple.practice3.model.Employee;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	Employee e = new Employee();
	EmployeeController ect = new EmployeeController();
	
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
	e.setEmpNo(empNo);
	
	System.out.println("사원 이름 : ");
	String name = sc.nextLine();
	e.setName(name);
	
	System.out.println("사원 성별 : ");
	/*
	 *  String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환해주는 녀석
	 *  
	 *  .charAt(문자 번째수);
	 * */
	char gender = sc.nextLine().charAt(0);
	e.setGender(gender);
	
	System.out.println("전화 번호 : ");
	String phone = sc.nextLine();
	e.setPhone(phone);
	
	System.out.println("추가 정보를 더 입력하시겠습니까?(y/n) : ");
	String add = sc.nextLine();
	
	
	if(add.equals("y")) {
		System.out.println("사원 부서 : ");
		String dept = sc.nextLine();
		e.setDept(dept);
		
		System.out.println("사원 연봉 : ");
//		int salary = Integer.parseInt(sc.nextLine());
		int salary = Integer.parseInt(sc.nextLine());
		e.setSalary(salary);
		
		System.out.println("보너스 율 : ");
//		double bonus = sc.nextDouble();
		double bonus = Double.parseDouble(sc.nextLine());
		e.setBonus(bonus);
		ect.add(empNo, name, gender, phone, dept, salary, bonus);
	} else {
		ect.add(empNo, name, gender, phone);
	}
	
	}

// 수정할 데이터를 사용자에게 받는 메서드
public void updateEmp() {}
// 데이터를 출력하는 메소드
	public void printEmp() {
		// controller가 없으면 DB에 변수값 저장을 못한다.
		// controller가 필요하겠군!
		System.out.println(ect.info());
	}
		
}
