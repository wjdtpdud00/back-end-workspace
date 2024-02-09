package com.kh.practice;


import java.util.Scanner;

public class Application {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}

	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		// 반복실행
		boolean check = true;
		while (check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1.마이페이지");
			System.out.println("2.도서 대여하기");
			System.out.println("3.프로그램 종료하기");
			System.out.print("메뉴번호 : " + sc.nextLine());
			int menuNumber = Integer.parseInt(sc.nextLine());

			switch (menuNumber) {
			case 1:
				MyPage();
				break;
			case 2:
				Rental();
				break;
			case 3:
				break;
			}
		}
	}

	public void MyPage() {
		
	}

	public void Rental() {
	}

}
