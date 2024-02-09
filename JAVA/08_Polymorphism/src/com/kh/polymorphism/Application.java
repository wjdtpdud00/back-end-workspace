package com.kh.polymorphism;

import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.child.Manager;
import com.kh.polymorphism.model.child.Secretary;
import com.kh.polymorphism.model.parent.Employee;

/*
 * 다형성(Polymorphism)
 * - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
 * - 부모 타입으로 자식 객체를 생성하는 것
 * */

public class Application {
	public static void main(String[] args) {
		Employee e1 = new Employee("이수근", 12000);
		
		// 생성자의 클래스가 객체에 영구적으로 자료형이 된다.
		Engineer eg1 = new Engineer("김영철", 56000, "Java", 200);
		Employee temp1 = (Employee)eg1;//temp1의 자료형 : Engineer 
		
		Employee temp2 = new Employee("안녕", 5);

		
		System.out.println(eg1.getClass());
		System.out.println(temp1.getClass());
		System.out.println(temp2.getClass());
		
		if(true) {
			return;
		}
		
		Manager m1 = new Manager("강호동", 23000, "기획팀");
		Secretary s1 = new Secretary("서장훈", 34000, "강호동");
		
		System.out.println(e1);
		System.out.println(eg1);
		System.out.println(m1);
		System.out.println(s1);
		
		System.out.println();
		System.out.println(" [다형성 방식으로 객체 생성]");
		
		Employee eg2 = new Engineer("김영철", 56000, "Java", 200);
		Employee m2 = new Manager("강호동", 23000, "기획팀");
		Employee s2 = new Secretary("서장훈", 34000, "강호동");
		
		System.out.println(eg2);
		System.out.println(m2);
		

		
	}
}
