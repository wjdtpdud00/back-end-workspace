package com.kh.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayPractice {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayPractice a = new ArrayPractice();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
		a.method5();
	}
	/*
	 * 길이가 5인 배열을 선언하고 과일 5개로 초기화 한 후 본인이 좋아하는 과일 하나를 출력하세요. (과일 5개는 뭐든지~)
	 * 
	 * */
	public void method1() {
		
		String[] fruit = {"복숭아", "멜론", "사과", "바나나", "체리"};	
		System.out.println(fruit[0]);
		// 랜덤으로도 해보자!
		int num = (int)(Math.random() * 5);
		//System.out.println(fruit[num]);
		//[ ArrayList로 바꿔 보기]
		// 배열 -> ArrayList 변환하는 방법 > Arrays.asList(null) : 배열을 list로 반환해줌
		ArrayList<String> fruitList = new ArrayList(Arrays.asList(fruit));
//		fruitList.add("복숭아");
//		fruitList.add("멜론");
//		fruitList.add("사과");
//		fruitList.add("바나나");
//		fruitList.add("체리");
		//배열을 문자로 나타내는 방법
		//랜덤으로 출력되려면 num
		//[Arrays.asList(null) 적용 확인]
		System.out.println(fruitList);
		System.out.println(fruitList.get(num));
		
	}
	
	/*
	 * 사용자에게 배열의 길이와 배열의 크기 만큼 사용자한테 입력 받은 값으로 초기화 한 후
	 * 각 입력 받은 값이 잘 들어갔는지 출력 후 저장된 값들의 합을 출력하세요.
	 * 
	 * 정수 : 5
	 * 배열 0번째 인덱스에 넣을 값 : 4
	 * 배열 1번째 인덱스에 넣을 값 : -4
	 * 배열 2번째 인덱스에 넣을 값 : 3
	 * 배열 3번째 인덱스에 넣을 값 : -3
	 * 배열 4번째 인덱스에 넣을 값 : 2
	 * [4, -4, 3, -3, 2]
	 * 2
	 * */
	public void method2() {
		// 정수 변수로 입력값 받기
		System.out.println("정수 : ");
		int num = sc.nextInt();
		// 배열 만들기(num에 입력받은 수만큼 방이 생김)
		int [] arr = new int[num];
		//방에 값 넣는중!
		int sum = 0;
		/*
		for(int i=0; i<num ; i++) {
			System.out.println("배열 "+ i +"번째 인덱스에 넣을 값 : ");
			// 사용자가 입력한값 >  배열에 집어 넣는중
			arr[i] = sc.nextInt();
			sum += arr[i]; // 배열 값의 합들
		}
		// 배열의 값이 나오게 하는 메소드 사용
		System.out.println(Arrays.toString(arr));
		*/
		// [ 배열 > ArrayList로 사용]
		//들어올 타입 정하기! 제너릭!
		ArrayList<Integer> arrList = new ArrayList<>();
		for(int i=0; i<num; i++) {
			System.out.println("배열" + i + "번째 인덱스에 넣을 값 : ");
//			int answer = sc.nextInt(); 이걸로 sc.nextInt 대체해서 짧게도 가능!
			arrList.add(sc.nextInt());
			// 선언한 배열에 get으로 값 가져오는중!
			// 값들끼리 합이 sum에 저장됨
			sum += arrList.get(i);
		}
		System.out.println(arrList);
		System.out.println(sum);
	}
	
	
	/*
	 * 음식 메뉴는 자유롭게! 개수도 자유롭게! 배열 사용해서
	 * 사용자가 입력한 값이 배열에 있으면 "배달 가능", 없으면 "배달 불가능"을 출력하세요.
	 * 
	 * */
	public void method3() {
		String[] menu = {"떡볶이", "마라탕", "케이크", "닭발", "피자", "치킨"};
		// [배열 -> ArrayList]
		// Arrays.asList(menu) : 배열에 있는
		ArrayList<String> menuList = new ArrayList<>(Arrays.asList(menu));
		
		System.out.println("주문하실 메뉴를 골라주세요 : ");
		// 사용자 입력란
		String select = sc.nextLine();
		
		
		//아닐경우, 마지막번째를 나타내기 위해  > 그냥 for문 사용!
		/*
		for(int i = 0; i<menu.length; i++) {
			//select와 food를 비교!
			//배열에서 마라탕이 있는경우마 true 들어감 확인
			//System.out.println(select.equals(food));
			if(select.equals(menu[i])) {
				//true일 경우
				System.out.println("배달 가능");
				break;
			} else if(i == menu.length-1) {
				System.out.println("배달 불가능");
				// 이렇게 쓰면 배달불가능이 여러개뜸 : 6개를 다 돌기 때문에.
				// 해결 방법 : if사용
//				System.out.println("배달 불가능");
			} 
		} */
		
		//[향상된 for문, 삼항연산자 사용]
		//향상된 for(데이터 타입 변수 : 돌리려는 배열)문 사용
		boolean check = false;
		for(String food : menuList) {
			if(select.equals(food)) {
				//일치한 경우
				check =  true;
			}
		} 
		// [삼항 연산자]  조건식 ? true : false
		System.out.println(check ? "배달가능" :  "배달 불가능");
	}
	
	/*
	 * 
	 * 사용자에게 주민등록번호를 입력받아 성별자리 이후부터 *로 가리고 출력하세요.
	 * 단, 원본 배열은 건드리지 않고! 
	 * 
	 * 주민등록번호 : 123456-1234567
	 * 123456-1******
	 * 
	 * */
	public void method4() {
		System.out.print("주민등록번호 : ");
		String no = sc.nextLine();
		
		
		//[배열로 풀이]
		// 문자 배열로 바꾸는 메소드
		char[] charNo = no.toCharArray();
		// split : 문자 하나하나로 나타내주는 메소드
		String[] strNo = no.split("");
//		[ArrayList 방식]
		ArrayList<String> noList = new ArrayList<>(Arrays.asList(strNo));
		// index를 써야할 때, for문 사용
		/*
		for(int i=0; i<strNo.length; i++ ) {
			if(i <= 7) {
				System.out.print(strNo[i]);
			} else {
				System.out.print("*");
			}
		}*/
		
		for(int i=0; i<noList.size(); i++ ) {
			if(i <= 7) {
				System.out.print(noList.get(i));
			} else {
				System.out.print("*");
			}
		}
	}
	
	/*
	 * 사용자가 입력한 단어를 거꾸로 뒤집어서 출력하세요. 
	 * 
	 * 단어 입력 : programming
	 * gnimmargorp
	 * 
	 * */
	public void method5() {
		System.out.print("단어 입력 : ");
		String word= sc.nextLine();
		String [] wordArr = word.split("");
		// 배열로 바꾸고, index를 거꾸로 시작해서 출력하는 방법으로 할거임
		/*
		for(int i=wordArr.length-1; i>=0; i--) {
			System.out.print(wordArr[i]);
		}
		*/
		//[ArrayList 방식 ]
		ArrayList<String> wordList = new ArrayList<>(Arrays.asList(wordArr));
		// Collections.reverse : 역방향 정렬 메소드
		Collections.reverse(wordList);
		for(String s : wordList) {
			System.out.print(s);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}