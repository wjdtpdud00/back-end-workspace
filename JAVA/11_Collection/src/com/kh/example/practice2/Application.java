package com.kh.example.practice2;
import java.util.ArrayList;
import java.util.Collections;
// [화면 구현] > Application에 전부 구현  후에 controller에 기능만 따로 빼기!
import java.util.Scanner;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.TitleAscending;
import com.kh.example.practice2.controller.SongController;
import com.kh.example.practice2.model.Song;
// 담는역할, 데이터 반환이 필요 : controller
public class Application {
	
	// 어플리케이션에서만 사용할거라 private
	private Scanner sc = new Scanner(System.in);
	private SongController control = SongController.getInstance();
	
	// static은 메모리에 기본으로 올려짐
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	
	// try catch로 예외적인것 구현 어떻게 할것인지 나타내기
	public void mainMenu() {
		try {
			boolean check = true;
			while(check) {
				System.out.println("==== 메인 메뉴 ====");
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
				// 입력창 + 변수에 저장
				int menu = Integer.parseInt(sc.nextLine());
				
				switch(menu) {
				case 1:
					addLastList();
					break;
				case 2:
					addFirstList();
					break;
				case 3:
					printAll();
					break;
				case 4:
					searchSong();
					break;
				case 5:
					removeSong();
					break;
				case 6:
					updateSong();
					break;
				case 7:
					ascTitle();
					break;
				case 8:
					descArtist();
					break;
				case 9:
					System.out.println("종료");
					check = false;
					break;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("잘못 입력하셨습니다 : " + e.getMessage());
			mainMenu();
		} // 잘못입력되면 print를 만나서 catch문에서 나가짐
	}
	
	// 1. 마지막 위치에 곡을 추가하는 기능
	public void addLastList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.println("곡 명 : ");
		String title = sc.nextLine();
		System.out.println("가수 명 : ");
		String artist = sc.nextLine();
		
		// 빈칸인지 아닌지를 뺀거임 컨트롤에
		//song(title, artist) 여기에 생성됨
		//컨드롤의 song메서드(if문 있는) 생성됨
		// 추가 성공실패!!! +  빈칸이 없는 상태여야 반환
		
		
		// 빈칸저건 빼자 > 컨트롤에 if > 여기if에 추가하자
		Song song = new Song(title, artist);
		// if에서 비교를하고, 빈칸이없다면 추가성공 프린트 출력!
		boolean result = control.addLastList(song);
			if(result) {
				System.out.println("추가 성공");
			} else {
				 System.out.println("추가 실패");
			}
			
			
		}
	
	// 2. 첫 위치에 곡 추가
	public void addFirstList() {
		System.out.println("***** 첫 위치에 곡 추가 *****");
		
		System.out.print("곡 명 :");
		String title = sc.nextLine();
		
		System.out.print("가수 명 : ");
		String artist = sc.nextLine();
		
		
			Song song = new Song(title, artist);
			boolean result = control.addFirstList(song);
			if(result) System.out.println("추가 성공");
			else System.out.println("추가 성공");
		}
	
	
	// 3. 전체 곡 목록 출력
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		for(Song song : control.printAll()) {
			System.out.println(song);
		}
	}
	
	// 4. 특정 곡 검색
	public void searchSong() {
		
		System.out.println("***** 특정 곡 검색 *****");
		
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		
		Song song = control.searchSong(title);
		if(song!=null) {
			System.out.println(song + "을 검색 했습니다.");
		} else {
			System.out.println("검색할 곡을 찾지 못했습니다.");
		}
		
	}
	
	// 5. 특정 곡 삭제
	public void removeSong() {
		
		System.out.println("*****  특정 곡 삭제 *****");
		System.out.println("삭제할 곡 명 : ");
		String title = sc.nextLine();
		
	
		Song song = control.removeSong(title);
	
		if(song!=null) {
			System.out.println(song + " 을 삭제 했습니다.");
		} else {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}
	// 6. 특정 곡 수정
	public void updateSong() {
		System.out.println("***** 특정 곡 수정 ******");
		System.out.println("검색할 곡 명 : ");
		String search = sc.nextLine();
		
		System.out.println("수정할 곡 명 : ");
		String title = sc.nextLine();
		
		System.out.println("수정할 가수 명 : ");
		String artist = sc.nextLine();
		
		Song update = new Song(title, artist);
		Song song = control.updateSong(search, update);
		control.updateSong(search, update);
		if(song!=null) {
			System.out.println(song + "의 값이 변경 되었습니다.");
		} else {
			System.out.println("수정할 곡을 찾지 못했습니다.");
		}
		}
	
	
	// 7. 곡 명 오름차순 졍렬
	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		// .clone() : 깊은복사 > 리스트나 배열의 주소값이 바뀐다.
		
		for(Song song : control.ascTitle()) {
			System.out.println(song);
		}
	}
	
	// 8. 가수 명 내림차순 정렬
	public void descArtist() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		// .clone() : 깊은복사 > 리스트나 배열의 주소값이 바뀐다.
		
		for(Song song : control.descArtist()) {
			System.out.println(song);
	}
	

	
	
	}
}
