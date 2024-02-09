package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {
		// [properties : 데이터를 담는 기본클래스] 클래스를 사용하여 쿼리문 실행하기!
		
		// properties 생성자 생성
		Properties p = new Properties();
		try {
			// 데이터를 읽어옴(jdbc.properties파일 
			// > delete=DELETE FROM employee_copy WHERE emp_id = ?)
			//@@@ FileInputStream :  입력용 스트림 객체를 이용하여 파일 내용을 읽어옴
			//@@@ 왜또 load로 읽는가?
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			// 1. 드라라이버 로딩(자바 - mysql연결)
			Class.forName(ServerInfo.DRIVER_NAME);
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			// 3. 쿼리준비 - state 객체 생성
			// @@@ .getProperty("delete")로 
			// > delete=DELETE FROM employee_copy WHERE emp_id = ? 이문장에서 어떤걸 가져온건가?
			String query = p.getProperty(/*가져올 데이터*/"delete");
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 4. (물음표 문장)쿼리문 실행
			// 첫번때 물음표를 900으로 바꾸기 실행 
			ps.setInt(1, 900);
			
			System.out.println(ps.executeUpdate() + "명 삭제!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
