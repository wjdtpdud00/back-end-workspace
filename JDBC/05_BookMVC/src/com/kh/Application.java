package com.kh;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.MemberController;
import com.kh.controller.RentController;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.Rent;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private Member member = new Member();// 로그인 했을시 사용자 정보를 담은 객체임 
	private RentController rc = new RentController();
	
	public static void main(String[] args) throws SQLException {
		Application app = new Application();
		app.mainMenu();
	}

	public void mainMenu() throws SQLException {
		System.out.println("==== 도서 관리 프로그램 ====");

		boolean check = true;
		while (check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	// 1. 전체 책 조회
	public void printBookAll()  {
		// for문을 이용해서 책 리스트 출력
		for (Book book : bc.printBookAll()) {
			String pubName = book.getpublisher().getPubName();
			System.out.println("책 번호 : " + book.getBkNo() + " / " + book.getBkTitle() + " / " + book.getBkAuthor()
					+ (pubName!=null ? " / " + pubName : ""));
		}
		
		
	}

	// 2. 책 등록
	public void registerBook() {
		// 책 제목, 책 저자를 사용자한테 입력 받아
		System.out.print("책 제목 : ");
		String title = sc.nextLine();

		System.out.println("책 저자 : ");
		String author = sc.nextLine();
		
		if(bc.registerBook(title, author)) {
			// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
			System.out.println("성공적으로 책을 등록했습니다.");
		} else {
			// 실패하면 "책을 등록하는데 실패했습니다." 출력
			System.out.println("책을 등록하는데 실패했습니다.");
		}
		
	}

	// 3. 책 삭제
	public void sellBook() throws SQLException  {
		// printBookAll(전체 책 조회)를 한 후
		printBookAll();
		// 삭제할 책 번호 선택을 사용자한테 입력 받아
		System.out.println("삭제할 책 번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		if(bc.sellBook(no)) {
			System.out.println("성공적으로 책을 삭제했습니다.");
		} else {
			System.out.println("책을 삭제하는데 실패했습니다.");
		}
	}

	// 4. 회원가입
	public void registerMember() {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		System.out.println("아이디 : ");
		String id =sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String password = sc.nextLine();
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		if(mc.registerMember(id, password, name)) {
			// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
			System.out.println("성공적으로 회원가입을 완료하였습니다.");
		} else {
			
			System.out.println("회원가입에 실패했습니다.");
		}
		
	}

	// 5. 로그인
	public void login() {
		// 아이디, 비밀번호를 사용자한테 입력 받아
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String password = sc.nextLine();
		
		member = mc.login(id, password);
		if(member!=null) {
			// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
			System.out.println(member.getMemberName() + "님, 환영합니다.");
			// --> memberMenu() 호출
			
		} else {
			// 실패하면 "로그인에 실패했습니다." 출력
			System.out.println("로그인에 실패했습니다.");
		}
		
	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.println("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}

	// 1. 책 대여
	public void rentBook() {
		// printBookAll(전체 책 조회) 출력 후
		printBookAll();
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		System.out.println("대여할 책 번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		if(rc.rentBook(no, member.getMemberNo())) {
			System.out.println("성공적으로 책을 대여했습니다.");
			
		} else {
			
			System.out.println("책을 대여하는데 실패했습니다.");
		}
		
	
	}

	// 2. 내가 대여한 책 조회
	public void printRentBook() {
	
		ArrayList<Rent> list = rc.printRentBook(member.getMemberNo());
		
		
		for(Rent rent : list) {
			LocalDate localDate = new java.sql.Date(rent.getRentDate().getTime()).toLocalDate();
			
			System.out.println("대여 번호 : " + rent.getRentNo() 
			+ " / " + rent.getBook().getBkTitle() 
			+ " / " + rent.getBook().getBkAuthor() 
			+ " / " + rent.getRentDate()
			+ " / 반납 기한 : " + localDate.plusDays(7));
			
		}
		
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책저자, 대여 날짜, 반납 기한 조회(JOIN필요)
	}

	// 3. 대여 취소
	public void deleteRent() {
		// printRentBook(내가 대여한 책 조회) 출력 후
		printRentBook();
		
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		System.out.println("취소할 대여 번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		if(rc.deleteRent(no)) {
			System.out.println("성공적으로 대여를 취소했습니다.");
		} else {
			System.out.println("대여를 취소하는데 실패했습니다.");
		}
		
	}

	// 4. 회원 탈퇴
	public void deleteMember() {
		
		if(mc.deleteMember(member.getMemberNo())) {
			// 회원탈최에 성공하면 "회원탈퇴 하였습니다.ㅠㅠ" 출력
			System.out.println("회원탈퇴 하였습니다.ㅠㅠ");
		} else {
			// 실패하면 "회원탈퇴하는데 실패했습니다."출력
			System.out.println("회원탈퇴하는데 실패했습니다.");
		}
	}

}
