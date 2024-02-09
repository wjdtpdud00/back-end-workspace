package com.kh;

import java.sql.SQLException;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.Member;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	Member m = new Member();
	public static void main(String[] args) {
		Application app = new Application();
		try {
			app.mainMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mainMenu() throws SQLException {
		
		System.out.println("===== KH 사이트 =====");
		
		boolean check = true;
		while(check) {
			System.out.println("***** 메인 메뉴 *****");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("9. 종료");
			System.out.println("메뉴 번호 입력 : ");
			
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				signUp();
				break;
			case 2:
				login();
				break;
			case 9:
				// "프로그램 종료" 출력 후 반복문 종료
				System.out.println("프로그램 종료");
				check = false;
				break;
			}
		}
	}
 
	public void signUp() throws SQLException {
		Member m = new Member(null, null, null);
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		m.setId(id);
		
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		m.setOldPw(pw);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		

		// MemberController의 signUp 메서드 반환 결과에 따라
		// true면 "성공적으로 회원가입 완료하였습니다." 출력
		if(mc.signUp(m)) {
			System.out.println("성공적으로 회원가입 완료하였습니다.");
		} else {
			System.out.println("중복 아이디입니다. 다시입력해주세요.");
		}
		// false면 "중복 아이디입니다. 다시 입력해주세요." 출력
	}
	public void login() throws SQLException {
		// 아이디, 비밀번호를 사용자한테 입력받아
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String password = sc.nextLine();
		
		// MemberController의 login 메서드 반환 결과를 이름으로 받고
		String name = mc.login(id, password);
		if(name!=null) {
			// 이름이 null이 아니면 "~~님, 환엽합니다!" 출력
			System.out.println(name + "님, 환영합니다!");
			// --> login 성공! 성공했다면 memberMenu() 호출
			memberMenu();
		} else {
			// null이면 "틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요." 출력
			System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
		}
	}
	
	public void memberMenu() throws SQLException {
		boolean check = true;
		while(check) {
			System.out.println("***** 회원 메뉴 *****");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.println("메뉴 번호 입력 : ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				// 로그아웃 처리 -> 프로그램 종료처럼 하시면 됩니다~
				check = false;
				break;
			}
		}
	}
	
	public void changePassword() throws SQLException {
		// 아이디, 현재 비밀번호, 새로운 비밀번호를 사용자한테 입력받아'
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		m.setId(id);
		System.out.println("현재 비밀번호 : ");
		String pw = sc.nextLine();
		m.setOldPw(pw);
		
		System.out.println("새로운 비밀번호 : ");
		String pwNew = sc.nextLine();
		m.setNewPw(pwNew);
		// MemberController의 changePassword 메서드 반환 결과에 따라
		if(mc.changePassword(id, pw, pwNew)) {
			// true면 "비밀번호 변경에 성공했습니다." 출력
			System.out.println("비밀번호 변경에 성공했습니다.");
		} else {
			// false면 "비밀번호 변경에 실패했습니다. 다시 입력해주세요." 출력
			System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
		}
		
	}
	public void changeName() throws SQLException {
		// 아이디, 비밀번호를 사용자한테 입력받아 
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		m.setId(id);
		
		System.out.println("비밀번호 : ");
		String password = sc.nextLine();
		
		// 사용자가 맞는지 확인 후 - MemberController의 login 메서드 활용
		String name = mc.login(id, password); 
		// 이름이 null이 아니면 
		if(name!= null) {
			// --> "현재 설정된 이름 : OOO" 출력
			System.out.println("현재 설정된 이름 : " + name);
			// --> 변경할 이름을 사용자한테 입력받아
			System.out.println("변경할 이름 : ");
			String newName = sc.nextLine();
			// MemberController의 changeName 메서드로 이름 변경 후
			mc.changeName(id, newName);
			// "이름 변경에 성공하였습니다." 출력
			System.out.println("이름 변경에 성공하였습니다.");
		} else {
			// 이름이 null이면 "이름 변경에 실패했습니다. 다시 입력해주세요." 출력
			System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");
		}
		
		if(m.getId() != null) {
			// 변경할 이름 입력받기
			String name1 = sc.nextLine();
			// 이름 변경
			// 데이터 신호 보내기
			m.setId(name);
			System.out.println("이름 변경에 성공하였습니다.");
		} else if(m.getId() == null) {
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
