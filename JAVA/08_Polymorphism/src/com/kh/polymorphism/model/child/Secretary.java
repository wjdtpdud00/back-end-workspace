package com.kh.polymorphism.model.child;

import com.kh.polymorphism.model.parent.Employee;

public class Secretary extends Employee {

	private String nameOfBoss;

	public Secretary() {
		super();
		
	}

	public Secretary(String name, int salary, String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
		
	}

	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void setNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	@Override
	public String toString() {
		return super.toString() + " / Secretary [nameOfBoss=" + nameOfBoss + "]";
	}

}
