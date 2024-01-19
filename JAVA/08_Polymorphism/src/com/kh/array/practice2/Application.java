package com.kh.array.practice2;
// 화면 구현
import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class Application {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private Member mb = new Member();
	
	
	public static void main(String[] args) {
		// 객체 생성
		Application app = new Application();
		app.mainMenu();
		app.insertMember();

	}
	
	
	
	
	
	
	
	
	// 출력값 작성 > 숫자로 반환하는것
	public int mainMenu() {
		/*
		 * 회원 수가 3명이 최대 등록 가능
		 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다."와 함꼐
		 * "1. 새 회원 등록" 하지 못하게 -> 화면상 안보이게만 처리하셔도 됩니다.
		 * 
		 * 1번인 경우 -> insertMember()
		 * 2번인 경우 -> updateMember()
		 * 3번인 경우 -> printAll()
		 * 9번인 경우 -> 프로그램 종료
		 * 그 외의 경우 -> 잘못 입력하셨습니다. 다시 입력해주세요
		 * */
		
		// 반복문으로 할당하기 > app은 현재 글래스 주소를 담고있다.
		//1.등록 2. 수정 3.출력 9.끝내기
		boolean check = true;
		while(check) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.println("현재 등록된 회원 수는" + mc.count + "명입니다.");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("메뉴 번호 : ");
			
			switch(Integer.parseInt(sc.nextLine())){
			case 1:
				insertMember();
				break;
			case 2:
				updateMember();
				break;
			case 3:
				printAll();
				break;
			case 9:
				check = false;
				break;
			}

			}
		return 0;
			
		
		
	}
	// 저장할 데이터를 사용자에게 받는 메서드
	public void insertMember() {
		/*
		 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
		 * "중복된 아이디입니다. 다시 입력해주세요." 출력 후 
		 * 다시 아이디 입력부터 나올 수 있게 처리
		 * */
		
		// 출력문  + 원하는형태로 받기
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		
		if(mc.checkId(id)) {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			insertMember();// 본인 인서트 재출력
		}else {
			System.out.println("이름 : ");
			String name = sc.nextLine();
			
			System.out.println("비밀번호 : ");
			String password = sc.nextLine();
			
			System.out.println("이메일 : ");
			String email = sc.nextLine();
			
			System.out.println("성별(M/F) : ");
			char gender = sc.nextLine().charAt(0);
			
			System.out.println("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			
			// 매개변수에 담아냄
			//여기서만 임시 저장하는 역할
			Member m = new Member(id, name, password, email, gender, age);
			mc.insertMember(id, name, password, email, gender, age);
		}
		
	

		
			// if사용해서 중복아이디 나왔을때 창 만들기
	}
		
	
	// 회원정보 수정창
	public void updateMember() {
		/*
		 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
		 * "회원 정보가 없습니다." 출력 후 다시 메인 화면으로 
		 * */
		System.out.println("수정할 회원의 아이디 : ");
		if(mc.checkId(id)) {
			System.out.println("회원 정보가 없습니다");
			return;
		}
		System.out.println("수정할 이름 : ");
		String name = sc.nextLine();
		
		System.out.println("수정할 이름 : ");
		String email = sc.nextLine();
		
		System.out.println("수정할 이름 : ");
		String name1 = sc.nextLine();
		
		
	}
	
	public void printAll() {
		/*
		 * 전체 회원 정보 출력
		 * */
	}
	
	
	
	
	
	
}
