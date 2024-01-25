package com.kh.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.map.model.Snack;

/*
 * list - 중복 0
 * hash - 중복 x
 * 
 * Map
 * - key-value 쌍으로 저장
 * - 순서 없음 
 * - 중복 :  키(key) X, 값(value) O
 * 
 * HashMap
 * - Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 * */
public class A_HashMap {
	
	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
//		a.method1();
		a.method2();
	}
	
	public void method1() {
		// string 키 - integer 값
		Map<String, Integer> map = new HashMap<>();
		// put : map에서 내용추가하는 메소드
		map.put("웨하스", 250);
		map.put("고래밥", 180);
		map.put("칸쵸", 800);
		map.put("나쵸", 450);
		
		// 순서가 없음
		// 키값 형식으로 들어감
		System.out.println(map);
	
		//1. 키만 가져오기(Set)
		// Set이 중복허용 안되기 때문에 썻음
		Set<String> key = map.keySet();
		System.out.println(key);
		
		//2. 값만 가져오기(Collection)
		Collection<Integer> col = map.values();
		System.out.println(col);
		
		// 3. 키에 해당하는 value 값 가져오기()
		Iterator<String> it = key.iterator();
		while(it.hasNext()) {
			// 변수에 저장
			// 안에서 한번만 실행되는중
			// next()요소를 읽어옴 | hasnext() 요소있는지 확인 | Iterator 컬렉션에 저장된 요소에 접근
			String name = it.next();
			System.out.println(name + " : " + map.get(name));
		}
		
		System.out.println("------------------------------------------");
		// set은 향상된 for문으로 풀 수 있음!
		// 데이터타입 변수 : 배열
		for(String s : key) {
			System.out.println(s + " : " + map.get(s));
		}
		
		/*
		 * 4. entrySet
		 * 	  -  Map 컬렉션에 있는 Entry 객체(key, value 쌍으로 이루어진)
		 * 		 Set 컬렉션에 담아서 반환
		 *    - 반환된 Set 컬렉션에서 반복자를 얻어서 반복 처리
		 * */
		// entry객체들이 담겨있는 set임
		// set의 데이터타입 : Entry<String, Integer> 이거임
		Set<Entry<String, Integer>> entrySet =  map.entrySet();
		System.out.println(entrySet);
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public void method2(){
		Map<String, Snack> map = new HashMap<>();
		
		// 웨하스 치즈맛 240칼로리라는 정보 입력
		map.put("웨하스", new Snack("치즈", 240));
		map.put("웨하스", new Snack("딸기", 255));
		map.put("고래밥", new Snack("양념치킨", 173));
		map.put("자유시간", new Snack("아몬드", 232));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("나쵸", new Snack("치즈", 486));
		map.put("꼬깔콘", new Snack("매콤달콤", 175));
		map.put("후렌치파이", new Snack("딸기", 900));
		// key(웨하스) 중복때문에 10개입력했는데 9개가 들어감
		// 확인
		System.out.println("과자의 개수 : " + map.size()); 
		
		// 웨하스에는 뭐가 들어가있을까요?
		// put: 2번들어가면 수정 역활도함.
		System.out.println(map.get("웨하스"));
		
		// 키 값으로 삭제하기 -  꼬칼콘 
		// 8개로 줄었는지 확인!
		map.remove("꼬깔콘");
		System.out.println("과자의 개수 : " + map.size());
		
		// 1. 홈런볼에 해당하는 과자 정보 출력| 
		System.out.println(map.get("홈런볼"));
		
		// 2. 후렌치파이의 맛 정보 출력
		System.out.println(map.get("후렌치파이").getFalvor());
		
		// 3. 모든 과자의 칼로리 총합과 평균 출력
	/*	[방법 1]
		int sum = 0;
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		for(Entry<String, Snack> entry :  entrySet) {
		Snack snack	= entry.getValue();
		sum += snack.getCalorie();
		}
		System.out.println("칼로리 총합 : " + sum);
		System.out.println("칼로리 평균 : " + (sum/ map.size()));*/
		
		//[방법 2]
		int sum = 0;
		
		for(String key : map.keySet()) {
			// 스낵은 map안에 키값임
			Snack snack = map.get(key);
			sum += snack.getCalorie();
		}
		System.out.println("칼로리 총합 : " + sum);
		System.out.println("칼로리 평균 : " + (sum/ map.size()));
		
		// 모든 Entry 객체 삭제
		map.clear();
		// empty 는 비어있는지 확인
		System.out.println("비어있는지 : " + map.isEmpty());
		
		// 확인!
		System.out.println(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
