package com.kh.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class A_Date {

	public static void main(String[] args) {
		A_Date a = new A_Date();
		a.method1();
	}
	/*
	 * Date
	 * - java.util 패키지에 속한 날짜와 시간을 다룰 목적으로
	 *   만들어진 클래스
	 * - Date의 메서드는 대부분 deprecated(비권장) 되어있지만 여전히 사용
	 * */
	public void method1() {
		
		// 기본 생성자Date()로 객체를 생성하면 현재 시스템의 시간에 대한 정보를 가지고 객체를 생성한다.
		Date today = new Date();
		System.out.println(today);// Fri Jan 26 16:17:56 KST 2024
		
		Date when = new Date(0);
		System.out.println(when);//Thu Jan 01 09:00:00 KST 1970 > date의 기본값임
		
		System.out.println("getTime : " + today.getTime()); // 1706253630609
		
		//Deprecated된 기능들!
		System.out.println("getYear : " +  (today.getYear() + 1900) + "년");
		System.out.println("getMonth : " + (today.getMonth() + 1) + "월");
		System.out.println("getDate : " + today.getDate() + "일");
		System.out.println("getHours : " + today.getHours() + "시");
		System.out.println("getMinutes : " + today.getMinutes() + "분");
		System.out.println("getSeconds : " + today.getSeconds() + "초");
		/*  위의 출력값
		 *  getTime : 1706253869921
			getYear : 2024년
			getMonth : 1월
			getDate : 26일
			getHours : 16시
			getMinutes : 24분
			getSeconds : 29초
		 * */
		
		// SimpleDateFormat : 날짜 데이터를 원하는 형태로 출력할 수 있도록 (h : 1~12시, H : 0~23시 표기법)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a hh시 mm분 ss초");
		String formatDate = sdf.format(today);
		System.out.println(formatDate);
		// 2024년 1월 26일 (금) 오후 4시 25분 30초
	}
	
	
	
	
	
	
	
	
	
	
	
}
