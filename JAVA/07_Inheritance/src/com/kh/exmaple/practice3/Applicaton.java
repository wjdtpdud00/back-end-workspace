package com.kh.exmaple.practice3;

import java.util.Scanner;

import com.kh.exmaple.practice3.controller.EmployeeController;
import com.kh.exmaple.practice3.model.Employee;

public class Applicaton {
	Scanner sc = new Scanner(System.in);
	// 전역 변수를 찍어내기 위해서 작성하는거임
	Employee viewEmployee = new Employee();
	EmployeeController employeeController = new EmployeeController();
	
	// static메소드 // 프로그램이 종료되어야 끝남.
	public static void main(String[] args) {
		
		// 객체생성이 되어야 불러올 수 있음.
		Applicaton app = new Applicaton();
		
		
		boolean check = true; // 트루일때 반복문이돌고, false일때 종료 시키게끔 하는 역할
		// 반복문 만들기
		while(true) {
			int select = app.employeeMenu(); // 사용자의 입력값을 뜻함
			switch(select) {
			case 1:
				app.insertEmp();
				break;
			case 2:
				app.updateEmp();
				break;
			case 3:
				app.printEmp();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요~");
			}
		}
	}
	
	// 메인 메뉴를 출력 // 메인메뉴는 반복적인것이 들어감 //for while문 사용//
	// 무한루프는 while문 사용함.
	public int employeeMenu() {
		
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.println("메뉴 번호를 누르세요 :");
//		int menu = Integer.parseInt(sc.nextLine());	
//		return menu;
		// 입력받은것 그대로 출력하는것
		return Integer.parseInt(sc.nextLine());
		
	}
	
	// 저장할 데이터를 사용자에게 받는 메서드
	public void insertEmp() {
		// 1번을 기입했을때, 나오게 할 내용
		System.out.println("사원 번호 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		
		System.out.println("사원 이름 : ");
		String name = sc.nextLine();
		
		System.out.println("사원 성별 :");
		char gender = sc.nextLine().charAt(0);// 입력받을 형태 지정
		
		System.out.println("전화 번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		String add = sc.nextLine();
		
		//y인경우// equals로 스트링 타입으로 맞추기
		if(add.equals("y")) {
			System.out.println("사원 부서 : ");
			String dept =  sc.nextLine();
			
			System.out.println("사원 연봉 :");
			int salary = Integer.parseInt(sc.nextLine());
			
			System.out.println("보너스 율 : ");
			double bonus = Double.parseDouble(sc.nextLine());
			// 추가정보가 포함된 add
			employeeController.add(empNo, name, gender, phone, dept, salary, bonus);
			
		}else {
			// n인 경우
			// 추가정보가 없는 add
			employeeController.add(empNo, name, gender, phone);
		}
	}
	
	// 수정할 데이터를 사용자에게 받는 메서드
	public void updateEmp() {
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		case 1:
			System.out.print("전화 번호 입력 : ");
			String phone = sc.nextLine();
			employeeController.modify(phone);
			break;
		case 2:
			System.out.print("사원 연봉 입력 :");
			//변수에 입력값 담기 
			int salary = Integer.parseInt(sc.nextLine());
			employeeController.modify(salary);
			break;
		case 3:
			System.out.println("보너스 율 입력 :");
			double bonus = Double.parseDouble(sc.nextLine());// 자료형입력
			employeeController.modify(bonus);// 바뀐 자료형으로 불러오기.
			break;
		case 9:
			break;
		}
	}
	
	// 데이터를 출력하는 메서드
	public void printEmp() {
		System.out.println(employeeController.info()); 
		// employeeController클래스에 info메소드에 값들을 출력.
	}

}
