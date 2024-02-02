package person;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class PersonController {
	
	Properties p = null;

	public PersonController() {
		try {
			p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	// (빼주기) 고정적인 반복 -- DB연결, 자원 반납 -> 공통적인 메서드 정의 .. 메서드마다 호출해서 사용!
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn;
	}

	// 5. 자원 반납
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	public int addPerson(int id, String name, String address) throws SQLException {
		Connection conn = getConnect();
		// 3. 쿼리문 -> PreparedStatement
		String query = p.getProperty("insert");
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);

		int result = ps.executeUpdate(); // 양수면 성공, 음수면 실패 / 리턴값 : int
	
		closeAll(ps, conn);
		
		return result;
	}

	// person 테이블에서 데이터 수정
	public int updatePerson(int id, String address) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문
		String query = p.getProperty("update");
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setString(1, address);
		ps.setInt(2, id);

		int result = ps.executeUpdate(); 
		
		/* .executeUpdate()
		 * 성공하면1, 틀리면 -1
		 * */
		closeAll(ps, conn);
		
		return result;
	} 

	// person 테이블에서 데이터 삭제
	public int removePerson(int id) throws SQLException {

		Connection conn = getConnect();

		// 3. 쿼리문
		String query = p.getProperty("delete");
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		 ps.setInt(1, id);
		
		int result = ps.executeUpdate();
//		if (result == 1) {
//			System.out.println(id + "님, 삭제 완료!");
//		}

		closeAll(ps, conn);
		return result;
	} 

	// person 테이블에 있는 데이터 전체 보여주기
	public ArrayList<Person> searchAllPerson() throws SQLException {
		
		Connection conn = getConnect();

		// 3. 쿼리문
		String query = p.getProperty("selectAll");
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();
		while (rs.next()) {
//		list.add(new Person (rs.getInt("id"),
//									   rs.getString("name"),
//									   rs.getString("address")));
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setAddress(rs.getString("address"));
		list.add(person);
		
		}

		closeAll(rs, ps, conn);
		return list;
	}

	// person 테이블에서 데이터 한개만 가져오기
	public Person searchPerson(int id) throws SQLException {

		Connection conn = getConnect();

		// 3. 쿼리문
		String query = p.getProperty("select");
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);

		// 4. 쿼리문 실행
		ResultSet rs = ps.executeQuery();
		
		Person person = null;
		
		if (rs.next()) {
			person = new Person(rs.getInt("id"),
									   rs.getString("name"),
									   rs.getString("address"));
		}

		closeAll(ps, conn);
		return person;
	} 
}
