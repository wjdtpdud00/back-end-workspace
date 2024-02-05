package person;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PersonController {
		Properties p =null;

	public PersonController() {
		
		// 1. 드라이버 로딩
		try {
			// 명령문 써놓은거 파일 연결하기
			p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// [공통적인부분!] 빼주기 : 자원반납, db연결
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn;
	}
	
	// 자원반납(리턴값 필요없음)
	// state객체로 쿼리문 담기, conn으로 연결하기
	//@@@ 매개변수 안에서 별칭 지정
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);// 저기 담아져서, 다시 비워짐
	}
	
	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object)
	public int addPerson(int id, String name, String address) throws SQLException {
		Connection  conn = getConnect();

	// 쿼리문 실행 기능
		String query = "INSERT INTO person(id, name, address) VALUES (?, ?, ?)";
		// state 객체
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 4. 쿼리문 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);
		
		int result = ps.executeUpdate();//.executeUpdate() 성공하면 1,
		                                // 실패하면 -1
		closeAll(ps, conn);
		
		return result;
	}
	
	public int removePerson(int id) throws SQLException {
		Connection conn = getConnect();
		
		// 쿼리문 객체 만들기
		String query = "DELETE FROM person WHERE id =?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 쿼리문 실행
		ps.setInt(1, id);
		
		int result = ps.executeUpdate();
		
		//closeAll 클래스에 넣어 비우기
		closeAll(ps, conn);
		return result;
	}
	
	public void seachAllPerson() {}
	
	public void searchPerson(int id) {}
	
}
