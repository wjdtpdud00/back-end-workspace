package com.kh.example.practice2;
import java.util.ArrayList;
// [화면 구현] > Application에 전부 구현  후에 controller에 기능만 따로 빼기!
import java.util.Scanner;

import com.kh.list.A_ArrayList;

public class Application {
	Scanner sc = new Scanner(System.in);

//	MusicController mc = new MusicController();
	Music m = new Music();
	
	// 곡 리스트 담을 배열 만들기
	ArrayList<Music> musicList = new ArrayList<>();
	
    
	public static void main(String[] args) {
		Application a = new Application();
		a.mainMenu();
	}
	
	public void mainMenu() {
		// while문으로 true일때, 반복해서 작동
		boolean check = true;
		try {
			while(check) {
				System.out.println("==== 메인메뉴 ====");
				System.out.println("1. 마지막 위치에 곡 추가");
				System.out.println("2. 첫 위치에 곡 추가");
				System.out.println("3. 전체 곡 목록 출력");
				System.out.println("4. 특정 곡 검색");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 특정 곡 수정");
				System.out.println("7. 곡 명 오름차순 정렬");
				System.out.println("8. 가수 명 내림차순 정렬");
				System.out.println("9. 종료");
				System.out.println("메뉴 번호 입력 : ");
				int input = sc.nextInt();
				switch(input) {
				case 1:
					// 추가 메소드 연결
					lastMusic();
					break;
				case 2:
					break;
				case 3:
					musicList();
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;	
				}
			}
			
		// 	Exception e ?
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다 : For input string : 'r' ");
		}

	}
	
	public void lastMusic() {

		/* 바깥에서 1번실행
		 * if(컨트롤러에서 true라고 여기는 값: (가정)-1 ){
		 *  System.out.println("추가 성공");
		 * } else {
		 * 	바깥에서 한거 재실행!!
		 * }
		 * */
		
		System.out.println("*****마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		sc.nextLine();
		System.out.print("가수 명 : ");
		String singerName = sc.nextLine();
		
		// 컨트롤러 클래스를 부를 생성자 만들기!
		if(title != "" && singerName != "") {
			System.out.println("추가 성공");
			musicList.add(new Music(title, singerName));
		}else {
			// 바깥에서 한거 재실행
			lastMusic();
		}
		
	}
	
	public void musicList() {
		m.getSingerName();
		m.getTitle();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
