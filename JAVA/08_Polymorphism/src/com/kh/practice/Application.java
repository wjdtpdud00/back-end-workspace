package com.kh.practice;


import java.util.Scanner;

import com.kh.practice.controller.LibraryController;
import com.kh.practice.model.Book;
import com.kh.practice.model.Member;

// 실습예제 5번
public class Application {
	Scanner sc = new Scanner(System.in);
	Member member = new Member(); // 생성자를 만들어 멤버 클래스에서 member로 담음
	// member클래스에서 만들었음
//	// 한 사람에 대한 정보를 담고 있는 변수들
//	String name = "";
//	int age = 0;
//	int coupon = 0; //0번도서를 대여 할때마다, 1씩 추가할거임
//	String[] bookList = new String[3];
	
	int num= -1; // num을 어디서든 접근 할수있게, 바깥에 선언함.// 
	

	LibraryController lc = new LibraryController();
	
	Book[] books = {
			// book에 정보넣음
			new Book("맛있는 지중해식 레시피", true),
			new Book("카페 샌드위치 마스터 클래스", false),
			new Book("원피스 107", 19),
			new Book("주술회전 24", 15)
	};
	
	public static void main(String[] args) {
		
		// 책에 대한 정보 담음!

		
		Application app = new Application();
		app.mainMenu();
	}
		
	
	public void mainMenu() {
		
		System.out.println("이름 : ");
		member.setName(sc.nextLine());
		 // 사용자가 입력한값을 name객체에 넣고있음 > Setter임
		
		System.out.println("나이 : ");
		member.setAge(Integer.parseInt(sc.nextLine()));// age객체에 넣고있음. setter임
		
		boolean check = true;
		
		//for문은 범위가 정해져있는것
		//while 은 무한반복 쓰는게 편할 때
		while(check) {
			System.out.println("=== 메뉴 ===");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.println("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());
			                                    
//			System.out.println("Member[name=" + name + ", age=" + age
//											+",cookCoupon=0, bookL"); // 입력한 정보 출력
			// swith 조건들이 n=1, n=2  일때,
			// 조건이 복잡한 연산식일때  for
			switch(menu) {
				case 1:
					myPage();// 아래 기능 분리한후 호출
					//num초기값이 0이기 때문에, num == 0에서 걸림
					// 해결방법 : num초기값을 바꿔준다. -1로바꿨음.
					break;
				case 2:
					rentBook(); // 아래 기능 분리한후 호출
					break;
				case 3 :
				check = false;
				break;
				
			}
		}   

	}
	
	public void myPage() {  
//		
//		

		System.out.println(member.toString());//5depth
	}
	
	public void rentBook() {
		for(int index = 0; index < books.length; index++) {
			System.out.println(index + "번 도서 : " + books[index]); 
			//to string으로 재정의 안하면, 클래스들은 주소값으로 반환함
		}
		// 위의 for문이 이 기능을 대신해줌
//		System.out.println("0번 도서 : Book [title=맛있는 지중식 레시피 ]/CookBook[coupon=true]");
//	    System.out.println("1번 도서 : Book [title=카페 샌드위치 마스터 클래스]/CookBook[coupon=false]");
//		System.out.println("2번 도서 : Book [title=원피스 107]/CookBook[accessAge=19]");
//		System.out.println("3번 도서 : Book [title=주술회전 24]/CookBook[accessAge=15]");
		System.out.println("대여할 도서 번호 선택 : ");
		num = Integer.parseInt(sc.nextLine());
		
		Book selectBook = books[num];
		
		// getter를 이용해서 기존 책 리스트를 일단 가지고 와야 함!
		Book[] newBookList = member.getBookList();
		// 마이페이지에서 대여받은 책들의 값이 변동없도록  대여불가와 분리해 놓은 거임.
		for(int i = 0; i < newBookList.length; i++) { //getter 넣고있음

			if(newBookList[i] == null) {
				// 대여 가능 공간!
				if(num == 0) {
					// -> 새로운 쿠폰값 (setter) = 기존 쿠폰 값(getter) + 1
					// 객체에 값이 들어가니까 setter
					//newBookList[i] = books[num] > i는 newBookList의 인덱스, num은 books의 인덱스
					//setter
				}// 나이 제한이 걸린 경우 여기서 걸리게함.
				member.setCoupon(member.getCoupon() + 1); // 쿠폰이 true인 경우!
				if(selectBook.isCoupon()) {
					//내가 대여한 책의 쿠폰이 true인 경우!
					member.setCoupon(member.getCoupon() + 1);
				}
					
				if(member.getAge() < selectBook.getAccessAge()) {
					// 내가 대여한 책의 접근 제한 나이보다 많은 경우!
					newBookList[i] = books[num];
				}
				
			// 사용자가 선택한 책!
//				if()
//				newBookList[i] = books[num];
				break;
			}

			member.setBookList(newBookList);
			// 나이제한이 걸리는 경우 
			if(member.getAge() < selectBook.getAccessAge()) { 
				System.out.println("나이 제한으로 대여 불가능입니다.");
			}else {
				System.out.println("성공적으로 대여되었습니다.");
			}
		}
	}
}
