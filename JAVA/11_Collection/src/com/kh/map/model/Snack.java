package com.kh.map.model;

public class Snack {
	private String falvor;
	private int calorie;
	
	public Snack() {
		
	}
	public Snack(String falvor, int calorie) {
		this.falvor = falvor;
		this.calorie = calorie;
	}
	public String getFalvor() {
		return falvor;
	}
	public void setFalvor(String falvor) {
		this.falvor = falvor;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	@Override
	public String toString() {
		return "Snack [falvor=" + falvor + ", calorie=" + calorie + "]";
	}
	
	
}
