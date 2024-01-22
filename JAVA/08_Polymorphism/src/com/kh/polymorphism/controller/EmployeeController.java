package com.kh.polymorphism.controller;

import java.util.Scanner;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController {
	
	Scanner sc = new Scanner(System.in);


	// 이름으로 사람 찾기
	public Employee findEmployeeByName(String name, Employee[] empArr) {

		for(Employee employee : empArr) {
			if(employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}
	// 찾은 사람의 연봉은?
	//초기값이 필요없는 원시자료형 x, 인스턴스x 변수 메소드
	public int getAnnualSalary(Employee result) {
		int annualSalary = result.getSalary() * 12;
		if(result instanceof Engineer) {
			//result.get > 안불러와져서 객체 생성함.
			Engineer engineer = (Engineer)result; // 부모 -> 자식 : 강제 형 변환 필수!
			return annualSalary + engineer.getBonus();
			//result instanceof Engineer > 엔지니어인 경우로 설정
		}else {
			return annualSalary;
		}

	}
	// 전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee[]empArr) {
		int sum = 0;		
		for(Employee employee : empArr ) {
			// 각각의 해당하는 연봉 더해주는 기능
			sum += getAnnualSalary(employee);
		} 
		return sum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
