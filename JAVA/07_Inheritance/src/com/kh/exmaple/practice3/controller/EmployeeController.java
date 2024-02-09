package com.kh.exmaple.practice3.controller;

import java.util.Scanner;

import com.kh.exmaple.practice3.model.Employee;

public class EmployeeController {

	private Employee employee = new Employee();
	
	public static void main(String[] args) {
		
	}
	
	// 오버로딩! 
	// : 같은메소드를 매개변수 차이를 활용하여 생성
	public void add(int empNo, String name, char gender, String phone )  {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept,
					int salary, double bonus) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setSalary(salary);
		employee.setBonus(bonus);
		
	}
	
	
	public void modify (String phone) {
		// 전화번호 입력받는 곳 생성
		employee.setPhone(phone);
	}
	public void modify (int salary) {
		employee.setSalary(salary);
	}
	public void modify (double bonus) {
		employee.setBonus(bonus);
	}
	
	public  Employee info() {
		return employee; // employee클래스에 있는것들을 사용할것이 때문에, 반환받는다.
	}
}