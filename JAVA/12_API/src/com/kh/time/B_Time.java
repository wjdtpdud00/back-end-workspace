package com.kh.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * java.time 패키지
 * - Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공(JAVA 8ver = JDK 1.8)
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스 포함
 * - 날짜와 시간에 대한 다양한 메서드를 제공
 * 
 * 꿀팁!
 * .Ctrl+space 로 반환타입과 매개변수만 보아도
 * 문제를 거의 찾을 수 있음
 * */
public class B_Time {

	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();
//		b.method2();
		b.method3();
	}
	
	public void method1() {
		/*
		 * LocalDateTime
		 * - 날짜와 시간 정보를 모두 저장
		 * */
		LocalDateTime now = LocalDateTime.now();
		System.out.println("today : " + now);
		//today : 2024-01-29T09:41:30.820704900
		
		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2024, 5, 16, 17, 50, 00);
		System.out.println("when : " + when);
		//when : 2024-05-16T17:50
		
		// ZonedDateTime : LocalDateTime + 시간대
		// 지역도 표시가능
		System.out.println("ZonedDateTime : " + ZonedDateTime.now());
		
		// 년, 월, 일 , 요일, 시, 분 ,초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonth());//JANUARY
		System.out.println(now.getMonthValue() + "월");// 1월
		System.out.println(now.getDayOfMonth() + "일");// 29일
		System.out.println(now.getDayOfWeek()); // MONDAY
		System.out.println(now.getHour() + "시"); // 9시
		System.out.println(now.getMinute() + "분");// 48분
		System.out.println(now.getSecond() + "초");//57초
		
		System.out.println();
		
		// 날짜 조작
		LocalDateTime plusDays = now.plusDays(1).plusMonths(1).plusYears(1);
		System.out.println("plusDays : " + plusDays);
		// plusDays : 2025-02-28T11:05:00.371173
		LocalDateTime minusDays = now.minusYears(1).minusMonths(1).minusDays(1);
		System.out.println("minusDays : " + minusDays);
		// minusDays : 2022-12-28T11:05:00.371173
		LocalDateTime withDays = now.withYear(2025).withMonth(3).withDayOfMonth(10);
		System.out.println("withDays : " + withDays);
		// withDays : 2025-03-10T11:05:00.371173
		
		// 2024-01-29일을 기준
		System.out.println("isAfter : " + now.isAfter(withDays));
		//오늘이 해당 날짜보다 이후인가?
		System.out.println("isBefore : " + now.isBefore(withDays));
		// 오늘이 해당 날짜보다 이전인가?
		/*isAfter : false
		isBefore : true*/
		
		// LocalDate : 날짜 정보를 저장
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate : " + localDate);// localDate : 2024-01-29
		localDate = LocalDate.of(2024, 12, 25);
		System.out.println("localDate 2 : " + localDate);
		
		// LocalTime :  시간 정보만을 저장
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime " + localTime);
		//localTime 11:11:36.219383300
		localTime = LocalTime.of(17, 50, 49, 59);
		System.out.println("localTime " + localTime);
		//localTime 17:50:49.000000059
	}
	/*
	 * Period와 Duration
	 * - 날짜와 시간 간격을 표현하기 위한 클래스
	 * - Period : 두 날짜 간의 차이
	 * - Duration : 시간의 차이
	 * */
	public void method2() {
		
		LocalDate date1 = LocalDate.of(2024, 1, 1);
		LocalDate date2 = LocalDate.of(2025, 12, 31);
		
		// between :  두 날짜의 차이 (until - 별반 차이 X)
		// .between(비교날짜, 비교날짜)
		Period pe = Period.between(date1, date2);
		System.out.println("pe : " + pe);// pe : P1Y11M30D	
		
		System.out.println("years : " + pe.getYears());
		System.out.println("years : " + pe.get(ChronoUnit.YEARS));
		/*years : 1
		  years : 1*/
		System.out.println("months : " + pe.getMonths());
		System.out.println("months : " + pe.get(ChronoUnit.MONTHS));
		/*months : 11
		  months : 11*/
		System.out.println("days : " + pe.getDays());
		System.out.println("days : " + pe.get(ChronoUnit.DAYS));
		/*days : 30
		  days : 30*/
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(11, 23, 55);
		
		Duration du = Duration.between(time1, time2);
		System.out.println(du);//PT11H23M55S
		
		System.out.println("hour : " + du.toHours());
		System.out.println("minutes : " + du.toMinutes());
		System.out.println("seconds : " + du.toSeconds());
		/*hour : 11
		 단위별 11시간 차이를 나타냄
		 minutes : 683
		 seconds : 41035*/
		
		// 문자열을 LocalDate 객체로 파싱(파싱 : 해당하는 데이터 타입으로 변환한다는 의미임)
		LocalDate date = LocalDate.parse("2024-02-08");
		System.out.println(date);//2024-02-08
		
		// DateTimeFormatter
		// 날짜와 시간을 포맷팅(Formatting)된 문자열로 
		// 변환하는 메서드를 제공하는 클래스
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter ofpattern = DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss");
		// format(데이터타입)
		String formatDate = today.format(ofpattern);
		System.out.println(formatDate);// 24-01-29 11:34:40
	}
	
	// D-Day 계산기 : 년월일을 입력하여 디데이 계산
	public void method3() {
		// ChronoUnit.DAYS.between 
		// 또는 날짜.until(날짜, ChronoUnit.DAYS)

		// 오늘 날짜 필요
		LocalDate today = LocalDate.now();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("년 : ");
		int year = Integer.parseInt(sc.nextLine());
		System.out.println("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.println("일 : ");
		int day = Integer.parseInt(sc.nextLine());
		
		// 입력 할 날짜
		LocalDate inputDate = LocalDate.of(year, month, day);
		
		//[ChronoUnit.DAYS.between]
		// 반환타입이 long이므로 long으로 데이터 받음
		long dDay = ChronoUnit.DAYS.between(today, inputDate);
		dDay = today.until(inputDate, ChronoUnit.DAYS);
		
		//(기본)System.out.println("D-" + dDay);
		//(응용) if문
		// dDay가 0인 경우 D-Day로 나오게끔
		if(dDay == 0) {
			System.out.println("D-Day");
		} else if(dDay < 0){
			System.out.println("D+" +(-dDay));
		} else {
			System.out.println("D-" + dDay);
		} 
		

		// [날짜.until(날짜, ChronoUnit.DAYS)]
//		System.out.println("D-" + today.until(inputDate, ChronoUnit.DAYS));

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
