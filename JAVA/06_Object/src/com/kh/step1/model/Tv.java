package com.kh.step1.model;

public class Tv {
	
	/*
	 * [속성(property)] :
	 *  멤버변수(member varialble), 
	 *  특성(attribute), 
	 *  필드(field)
	 *  
	 *  [기능(function)] :
	 *  메서드(method),
	 *  함수(function)
	 *  
	 * */
	public boolean power; // TV전원 기능(on/off)
	public int channel; // 채널
	
	// [추상화 작업]
	// TV 기능이 더 있지만 당장 프로그래밍화 하는데 
	// 필요한 속성과 기능만 선택하여 작성하는 것
	public void power() {
		power = !power; // Tv를 켜거나 끄는 기능
	}
	
	public void channelUp() {
		++channel; // 채널 번호를 높이는 기능
	}

	public void channelDown() {
		--channel; // 채널 번호를 내리는 기능
	}
	
}




