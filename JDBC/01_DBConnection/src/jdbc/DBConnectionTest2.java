package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest2 {
	
	// 변수선언으로 주소값 간단하게 표현중임
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/kh";
	public static final String USER = "root";
	public static final String PASSWORD = "1234";
	
	public static void main(String[] args) {
		// 1. 드라이브 로딩
		try {
			Class.forName(DRIVER_NAME);
			
			//2. 디비 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비 - INSERT
			String query = "INSERT INTO employee_copy(emp_id, emp_name, emp_no) VALUES (?, ?, ?)";
			// 4. state 객체 생성
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 5. .setInt(0, 0) : 물음표 순서, 넣을값
			ps.setInt(1, 700);
			ps.setString(2, "김미경");
			ps.setString(3, "111111-2222222");
			// 6. 쿼리문 실행될때마다 1리턴
			System.out.println(ps.executeUpdate() + "명 추가!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
