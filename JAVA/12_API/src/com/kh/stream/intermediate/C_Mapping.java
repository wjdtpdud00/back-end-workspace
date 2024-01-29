package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.model.Student;

// 매핑 - 중간 처리 기능으로 스트림의 요소를 다른 요소로 대체하는 역할
public class C_Mapping {

	public static void main(String[] args) {
		C_Mapping c = new C_Mapping();
//		c.method1();
//		c.method2();
		c.method3();
	}
	
	// mapXXX : 요소를 대체하는 요소로 구성된 새로운 스트림 생성
	public void method1() {
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90)
				);
		
		students.stream()
		// .getName() : 이름만 뽑아내는 메소드
				.map(student -> student.getName())
				.forEach(name -> System.out.println(name));
		
		// 수학 점수의 평균(average)
		//.mapToInt로해야 average 메소드가 뜸
		// .getAsDouble(); : optional -> double 형변환
		double avg = students.stream()
							.mapToInt(student -> student.getMath())
							.average()
							.getAsDouble();
		System.out.println("수학 점수의 평균 : " + avg);
		
	}
	
	//flatMapXXX : 하나의 요소를 복수의 요소들로 구성된 새로운 스트림을 생성한다.
	public void method2() {
		List<String> list = Arrays.asList("Java11 Lambda", "StreamAPI Filtering Sorted Mapping");
		list.stream()
//			.forEach(str -> System.out.println(str)); 아래와 같은 기능
			.forEach(System.out::println);
		
		System.out.println();
		
		list.stream()
			.flatMap((String str) -> {
				//.split으로 쪼개고
				String[] array = str.split(" ");
				// 변수 array를 배열로 반환시킨다.
				return Arrays.stream(array);
			})
			.flatMap(str -> Arrays.stream(str.split(" ")))
			.forEach(System.out::println);
	}

	// asDoubleStream(), asLongStream(), boxed()
	// - asDoubleStream : IntStream, LongStream을 DoubleStream으로 변환
	// - asLongStream : IntStream을 LongStream으로 변환
	// - boxed :  int, long, double(기본자료형) 요소를 Integer, Long, Double(클래스) 요소로 박싱
	public void method3() {
		int[] array1 = {1, 2, 3, 4, 5};
		double[] array2 = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		// 모든 정수를 모든실수로 바꿔 출력하시오!
		// .asDoubleStream() : 정수를 소수로 전환
		Arrays.stream(array1)
			  .asDoubleStream()
			  .forEach(System.out::println);
		
		System.out.println();
		
		// 역순으로 출력
		Arrays.stream(array2)
		// Comparator는 객체만 사용가능
				.boxed()
				.sorted(Comparator.reverseOrder())
			    .forEach(System.out::println);
		
	}
	
	
	
	
	
	
	
	
	
	
}
