package person;

import java.sql.SQLException;
import java.util.ArrayList;

public class PersonTest {

	PersonController pc = new PersonController();

	public static void main(String[] args) {
		PersonTest pt = new PersonTest();

		try {
			// person 테이블에 추가
//			pt.addPerson(111, "김강우", "서울");
//			pt.addPerson(222, "고아라", "제주도");
//			pt.addPerson(333, "강태주", "경기도");

			// person 테이블에서 데이터 수정
//			pt.updatePerson(111, "제주도");

			// person 테이블에서 데이터 삭제
//			pt.removePerson(333);

			// person 테이블에 있는 데이터 전체 보여주기
			pt.searchAllPerson();

			// person 테이블에서 데이터 한개만 가져오기
//			pt.searchPerson(111);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object) : 메서드 5가지 세트
	// VO(Value Object) : Person
	// VO + DAO = model
	// person 테이블에 추가 - INSERT
	public void addPerson(int id, String name, String address) throws SQLException {
		int result = pc.addPerson(id, name, address);
		if(result == 1) {
			System.out.println(name + "님, 회원가입 완료!");
		}
	}

	// person 테이블에서 데이터 수정 - UPDATE
	public void updatePerson(int id, String address) throws SQLException {
		int result = pc.updatePerson(id, address);
		if (result == 1) {
			System.out.println(result + "님, 수정 완료!");
		}

	}

	// person 테이블에서 데이터 삭제 - DELETE
	public void removePerson(int id) throws SQLException {
		int result = pc.removePerson(id);
		if (result == 1) {
			System.out.println(result + "님, 삭제 완료!");
		}
	}

	// person 테이블에 있는 데이터 전체 보여주기
	public void searchAllPerson() throws SQLException {
		/*반환값*/ ArrayList<Person> list = pc.searchAllPerson();
		// list는 향상된 for문이 유용!
		for(Person p : list) {
			System.out.println(p.getName() + " , " + p.getName() + "," + p.getAddress());
//			System.out.println(p); // 이렇게도 사용 가능
		}
	}

	// person 테이블에서 데이터 한개만 가져오기
	public void searchPerson(int id) throws SQLException {	
		// pc.searchPerson(id) <- 코드 단축, 이거 변수로 지정하면됨
		System.out.println(pc.searchPerson(id));
	}
}
