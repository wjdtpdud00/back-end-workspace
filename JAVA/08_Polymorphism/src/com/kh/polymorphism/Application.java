package com.kh.polymorphism;

import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.child.Manager;
import com.kh.polymorphism.model.child.Secretary;
import com.kh.polymorphism.model.parent.Employee;
// employee가 부모, manager, secretary, engineer가 자식인 상황
/*
 * 다형성(Polymorphism)
 * - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
 * - 부모 타입으로 자식 객체를 생성하는 것
 * */

public class Application {

	public static void main(String[] args) {
		
		// 각 객체별로 데이터 입력함.
		Employee e1 = new Employee("이수근", 12000);
		Engineer eg1 = new Engineer("김영철", 56000, "Java", 200);
		Manager m1 =  new Manager("강호동", 23000, "기획팀");
		Secretary s1 = new Secretary("서장훈", 34000, "강호동");
		
		System.out.println(e1);
		System.out.println(eg1);
		System.out.println(m1);
		System.out.println(s1);
		
		System.out.println();
		
		// 다형성 방식으로 객체 생성
		// 부모의 타입으로 객체 생성함.
		Employee eg2 = new Engineer("김영철", 56000, "Java", 200);
		Employee m2 = new Manager("강호동", 23000, "기획팀");
		Employee s2 = new Secretary("서장훈", 34000, "강호동");
		
		
		System.out.println(eg2);
		System.out.println(m2);
		System.out.println(s2);
		
		// 다형성 + 객체 배열
		Employee[] empArr = {e1, eg2, m2, s2};
		
		EmployeeController ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		
		//이름으로 사람 찾기
		System.out.println("이름 입력 : ");
		String name =sc.nextLine();
		Employee result = ec.findEmployeeByName(name, empArr);
		if(result!=null) {
			System.out.println(result);
		}else {
			System.out.println("찾는 사람이 없습니다");
		}
		
		// 찾은 사람의 연봉은?
		// 보너스 때문에 기능으로 넣은것임.
		//필요한 result 전달
		System.out.println(result.getName() + "의 연봉은" + ec.getAnnualSalary(result));
		
		
		
		// 전체 사람들의 연봉 총합은?

		// 임플로이 배열 돌리기
		System.out.println("전체 사람들의 연봉 총합은 " + ec.getTotalSalary(empArr));
		
		
		
	
}
	
}	
	

