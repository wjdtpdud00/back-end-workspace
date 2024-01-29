package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.stream.model.Student;

/*
 * 필터링
 * - 중간 처리 기능으로 요소를 걸러내는 역할
 * */
public class A_Filtering {
	
	public static void main(String[] args) {
			A_Filtering a = new A_Filtering();
//			a.method1();
			a.method2();
	}
	
	// distinct : 중복 제거
	public void method1() {
		// 중복된 배열 만들기
		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미", "정대윤", "이상호", "권예빈");
		Stream<String> stream = names.stream();
		// lambda식을 사용하여 name 뽑기
		stream.forEach(name -> System.out.print(name + ""));
		
		System.out.println();
		//stream은 다시한번 불러와야 사용가능
		stream = names.stream();
		//중복제거 distinct 사용
		stream.distinct().forEach(name -> System.out.print(name + " "));
		
		// list에 distinct사용
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90),
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60)
				);
		students.stream()
				.distinct()
				.forEach(student -> System.out.println(student));
		
	}
	
	
	// filter : 반복문안에서 조건문 쓴 기능과 비슷함 
	public void method2() {
		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미");
		names.stream()
		// filter로 중간처리 , 최종처리 메소드가 먼저 올 수 없음
		.filter(name -> name.startsWith("이"))
		// forEach로 최종처리
		.forEach(name -> System.out.print(name + " "));
		
		List<Student> students = Arrays.asList(
		new Student("이상현", 20, "남자", 80, 50),
		new Student("정대윤", 19, "남자", 75, 60),
		new Student("이상호", 21, "남자", 50, 100),
		new Student("권예빈", 18, "여자", 60, 45),
		new Student("손민정", 22, "여자", 70, 90),
		new Student("이상현", 20, "남자", 80, 50),
		new Student("정대윤", 19, "남자", 75, 60)
		);
		
		System.out.println();
		
		// 성별이 여자인 요소만 출력
		students.stream()
		.filter(student -> student.getGender().equals("여자"))
		.forEach(student/*지정할 변수명*/ -> System.out.println(student));
		
		System.out.println();
		// 수학 점수, 영어 점수 둘다 60점 이상인 요소만 출력
		students.stream()
//				.filter((student) -> {
//					return student.getMath() >= 60 && student.getEnglish() >= 60;
//				});
				.filter(student -> student.getMath() >= 60 && student.getEnglish()>= 60)
				.distinct()
				.forEach(student -> System.out.println(student));
	}



















}
