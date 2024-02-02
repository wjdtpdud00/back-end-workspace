package com.kh.controller;

import com.kh.model.Member;

public class MemberController {
	
	public boolean signUp(Member m) {
		// 회원가입 기능 구현! -> member 테이블에 데이터 추가!(INSERT)
		return false;
	}
	
	public String login(String id, String password) {
		// 로그인 기능 구현! -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!(SELECT)
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE 문 구현!
		// -> member 테이블에서 id와 password로 새로운 패스워드로 변경(UPDATE)
		return false;
	}
	
	public void changeName(String id, String changeName) {
		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 (UPDATE)
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
