package com.kh.exmaple.practice4;

import java.util.Scanner;

import com.kh.exmaple.practice4.controller.CircleController;
import com.kh.exmaple.practice4.controller.RectangleController;
// vcm에서 view역할
// 연산식 application으로 추정
public class Application {
	Scanner sc = new Scanner(System.in);
	//전역변수를 찍어내기 위해  받을곳 만들기
	CircleController cc = new CircleController();
	RectangleController rc = new RectangleController();
	
	// 동작은 main에서
	public static void main(String[] args) {
		
		// Applicaton에서 부를 생성자가 필요함.
		Application app = new Application();	
		app.mainMenu();
		app.circleMenu();
	}
 

	//1. 메인메뉴에 반복적인것 담기 
	public void mainMenu() {
		boolean check = true;
		while(true) {
		System.out.println("=== 메뉴 ===");
		System.out.println("1.원");
		System.out.println("2.사각형");
		System.out.println("9.끝내기");
		System.out.println("메뉴 번호 : ");
		//sc.nextLine()입력 받을것 땡겨와야하고
		// 1,2,9로 받아야 하기 때문에 string을 int로 
		// 변화시켜주는 함수 필요
		switch(Integer.parseInt(sc.nextLine())) {
		case 1:
			circleMenu();
			break;
		case 2: 
			rectangleMenu();
			break;
		case 9: 
			check = false;
			break;
		}
			//x좌표 y좌표 반지름 입력받는것을 하라
		}
	}
	//2. 각 기능 별 메소드 생성	
		public void circleMenu() {
			System.out.println("==== 원 메뉴 ====");
			System.out.println("1.원 둘레");
			System.out.println("2.원 넓이");
			System.out.println("9.메인으로");
			System.out.println("메뉴번호 :");
			//입력받은수가 ~인경우 할당
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				calcCircum();
				break;
			case 2:
				calcCircleArea();
				break;
			
				//x좌표 y좌표 반지름 입력받는것을 하라
			};
		}
		public void rectangleMenu() {
			System.out.println(" ==== 사각형 메뉴 ====");	
			System.out.println("1. 사각형 둘레");
			System.out.println("1. 사각형 넓이");
			System.out.println("메인으로");
			System.out.println("메뉴 번호 : ");
			
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				calcPermeter();
				break;
			case 2:
				calcRectArea();
				break;
			case 9 :
				break;
				}
		}
		public void calcCircum() {
			// 각 필요값들 입력받는곳 만들기
			System.out.println("x 좌표 : ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.println("y 좌표 : ");
			int y = Integer.parseInt(sc.nextLine());
			
			System.out.println("반지름 : ");
			int radius = Integer.parseInt(sc.nextLine());
			
			// 해당값 가지고옴 > 출력받을 값에 넣기
			System.out.println(cc.calcCircum(x, y, radius));
			
			
		}
		public void calcCircleArea() {
			System.out.println("x 좌표 : ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.println("y 좌표 : ");
			int y = Integer.parseInt(sc.nextLine());
			
			System.out.println("반지름 : ");
			int radius = Integer.parseInt(sc.nextLine());
			
			System.out.println((cc.calcArea(x, y, radius)));
		}
		
		public void calcPermeter() {
			System.out.println("x 좌표 : ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.println("y 좌표 : ");
			int y = Integer.parseInt(sc.nextLine());
			
			System.out.print("높이 : ");
			int height = Integer.parseInt(sc.nextLine());
			
			System.out.print("너비 : ");
			int widht = Integer.parseInt(sc.nextLine());
			
			System.out.println(rc.calcPerimeter(x, y, height, widht));
		}
		public void calcRectArea() {
			
		}
	
	// 3. 클릭후 넘어갈 창 할당
}


