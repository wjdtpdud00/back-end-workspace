package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {
	
		try {
			// properties : 담는 기본 클래스
			//.load() : 데이터를 읽어옴 
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			// 1. 드라이버 로딩 (java - mysql 연결)
			Class.forName(ServerInfo.DRIVER_NAME);
			// 2. 디비 연결
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			// 3. 쿼리 준비 - DELETE
			String query = p.getProperty("delete");
			PreparedStatement ps = conn.prepareStatement(query);

			// 4. 쿼리문 실행
			ps.setInt(1, 900);
			
			System.out.println(ps.executeUpdate() + "명 삭제!");

		} catch (Exception e) {
			// .printStackTrace() : 오류난 코드의 원인을 찾고, 출력
			e.printStackTrace();
		}
	}

}
