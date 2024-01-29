package com.kh.exmaple.practice3;

import java.util.Scanner;

import com.kh.exmaple.practice3.controller.EmployeeController;
import com.kh.exmaple.practice3.model.Employee;

public class Application {
	Scanner sc = new Scanner(System.in);
	
	Employee viewEmployee = new Employee();
	EmployeeController employeeController = new EmployeeController();
	
	public static void main(String[] args) {
		 Application app = new Application();
		 
		 //끝이 정해지지 않을때,반복문 while추천
		 /*switch( 판단할 값 ) {
		     case 숫자:
		         //실행내용
		         break;
		   default:
		         //실행내용 */
		 boolean check = true;
		 while(check) {
			 // 메뉴 입력값에대한 케이스
			 int select = app.employeeMenu();
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
			 default :
				 System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
			 }
			 
		 }
		 
	}
	
	// void빼고, 나머지는 반환타입
	// 메인메뉴를 출력하는 메소드
	public int employeeMenu() {
		System.out.println("1.사원 정보 추가");
		System.out.println("2.사원 정보 수정");
		System.out.println("3.사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.println("메뉴 번호를 누르세요 : ");
		// 입력받은값 반환
		return Integer.parseInt(sc.nextLine());
	}
	// 저장할 데이터를 사용자에게 받는 메소드
	public void insertEmp() {
		
	}
	// 수정할 데이터를 사용자에게 받는 메소드
	public void updateEmp() {
		
	}
	// 데이터를 출력하는 메소드
	public void printEmp() {
		
	}
	
	
	
	
	

	
}
