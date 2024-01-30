package com.kh.stream.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kh.stream.model.Student;

/*
 * 수집
 * - 최종 처리 기능으로 필터링 또는 매핑한 요소들을 새로운 컬렉션으로 담아서 
 *   리턴하는 collect() 제공
 * */
public class C_Collect {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("이상현", 15, "남자", 50, 80),
				new Student("정동준", 18, "남자", 90, 90),
				new Student("이상호", 16, "남자", 80, 70),
				new Student("권예빈", 17, "여자", 75, 80),
				new Student("조세미", 14, "여자", 85, 65)
		);
		
		// List 컬렉션으로 수집 -> 수학 점수가 80점 이상인 사람들만
	List<Student> list = students.stream()
        .filter(student -> student.getMath() >= 80)
        // collect 메소드 안에 collectors클래스에있는 toCollection메소드 사용!
        .collect(Collectors.toCollection(() -> new ArrayList<>()));
	System.out.println(list);
	//[Student [name=정동준, age=18, gender=남자, math=90, 
	//english=90], Student [name=이상호, age=16, gender=남자, 
	//math=80, english=70], Student [name=조세미, age=14, 
	//gender=여자, math=85, english=65]]
	
	// [Set 컬렉션으로 수집]
	// 중학생인 사람들만 출력하시오!(14~16살), HashSet
	

	  HashSet<Student> set = students.stream()
	        .filter(student -> (student.getAge() >= 14 && student.getAge() <= 16))
			.collect(Collectors.toCollection(() -> new HashSet<>()));
	System.out.println(set);
	
	// Map으로 컬렉션 수집
	Map<String, Integer> map = students.stream()
		.collect(Collectors
		.toMap(student -> student.getName(), 
				student -> student.getAge()));
		
	System.out.println(map);
	// {이상현=15, 권예빈=17, 조세미=14, 정동준=18, 이상호=16}
		
		
		
		
		
		
		
		
	}

}
