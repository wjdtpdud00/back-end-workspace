package com.kh.exmaple.practice3.controller;

import com.kh.exmaple.practice3.model.Employee;

// controller의 역할 : Controller는 Model을 통해 데이터를 가져오고, 
// 해당 데이터를 바탕으로 출력을 담당하는 View를 제어해서 사용자에게 전달한다 
// (데이터 - 신호 | 장점 : 여러개의 신호를 한번에 줄 수 있음)
public class EmployeeController {
	
	public static void main(String[] args) {
		
	}
	
	Employee e = new Employee();
	
	public void add(int empNo, String name, Char gender, String phone, String dept, int salary, double bonus) {


	}
	
	public void modify(String phone) {
		e.setPhone(phone);
	}
	
	public void modify(int Salary) {
		e.setSalary(Salary);
	}
	
	public void modify(double bonus1) {
		e.setBonus(bonus1);
	}
	
	public  Employee info() {
		return e; // employee클래스에 있는것들을 사용할것이 때문에, 반환받는다.
	}
}
