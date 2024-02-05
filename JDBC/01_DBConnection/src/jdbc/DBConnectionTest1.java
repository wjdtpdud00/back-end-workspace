package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DBConnectionTest1 {
	// jdbc(Java Database Connectivity) 작업 4단계
	public static void main(String[] args) {
		// 1. 드라이버 로딩 (driver 클래스에 연결한거임)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩");
			
			// 2. 데이터베이스에 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			System.out.println("2. 데이터베이스와 연결...!!");
			
			// 3. Statement 객체 생성 - SELECT
			// PreparedStatement : 쿼리문과 db를 정리하고, state 객체 생성
			String query = "SELECT * FROM employee";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 쿼리문 실행
			ResultSet rs = ps.executeQuery();
			
			// 쿼리문에 문자값이 입력 될 때마다, 변수에 저장하고 출력
			while(rs.next()) {
				// mysql Employee테이블에서 가져옴
				String empId = rs.getString("emp_id");
				String empName = rs.getString("emp_name");
				int salary = rs.getInt("salary");
				float bonus = rs.getFloat("bonus");
				Date hireDate = rs.getDate("hire_date");
				// string에 .charAt(0)을 붙여서 char형태로 전환시켰음.
				char entYn = rs.getString("ent_yn").charAt(0);
				
				System.out.println(empId+ "/" + empName + "/" + salary + "/" 
				+ bonus + "/" + hireDate +  "/" + entYn);
				
			}
		} catch (ClassNotFoundException e) {
			// 예외적인것이 잡혔을때
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결 실패!");
		}
	}
}
