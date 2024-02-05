package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest3 {
	
	public static void main(String[] args) {
		try {
			// ServerInfo 클래스 : 우리가 만든 db클래스임.
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			//2. 디비 연결
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			// 3. 쿼리준비 - state 객체 생성
			String query = "UPDATE employee_copy SET emp_name = ? WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			// 4. 쿼리문 실행(쿼리 = 물음표 문장)
			ps.setString(1, "김웡카");
			ps.setInt(2, 700);
			
			System.out.println(ps.executeUpdate() + "명 수정!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
