package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

// 기능
public class MemberController {
	// 3명 받기
	// 객체 배열방식
	private Member[] mArr = new Member[3];
	// count가 명수를 세어주고 있음
	public int count = 0;

	// 멤버 추가
	public void insertMember(String id, String name,  String password, String email,  char gender, int age) {
		mArr[count] = new Member();
		//[count++] = new Member(id, name, password, email, gender, age);
		
		mArr[count].setId(id);
		mArr[count].setName(name);
		mArr[count].setPassword(password);
		mArr[count].setEmail(password);
		mArr[count].setGender(gender);
		mArr[count].setAge(age);
		count +=1;
		System.out.println(Arrays.toString(mArr));//임시확인
	}
	
	// 멤버가 있는지 아이디로 조회
	public int checkId(String id) {
		for(int i = 0; i<mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				return i;
			}
		}
			return -1;
	 }
	
	//멤버 수정
	public void updateMember(String id, String name, String email, String password) {
		int index = checkId(id);
		mArr[index].setName(id);
		mArr[index].setEmail(email);
		mArr[index].setPassword(password);
	}
	
	// 멤버 조회
	public Member[] printAll() {
		/*
		 * 전체 회원 정보 출력
		 * */
		Member[] mArr = mc.printAll();
		System.out.println();
	}

	
	
	
	
	
	
}