package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

// DAO(Data Access Object)
// : DB에 접근하는 역할을 하는 객체 (CRUD)

public class BookDAO {
	
	public BookDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// 공통적으로 쓰이는 메서드 분리 (state객체생성, 드라이버 연결, ResultSet)
		public Connection getConnect() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");
		}
		
		public void close(PreparedStatement ps, Connection conn) throws SQLException {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
		
		public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
			if(rs!=null) rs.close();
			close(ps, conn);
		}
		
		// 1. 전체 책 조회
		public ArrayList<Book> printBookAll() throws SQLException {
			Connection conn = getConnect();
			
			String query = "SELECT * FROM sample.tb_book LEFT Join tb_publisher USING (pub_no)";
			// 쿼리에 쿼리문 담아낸다.
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Book> list = new ArrayList<>();
			while(rs.next()) {
				Book book = new Book();
				book.setBkNo(rs.getInt("bk_no"));
				book.setBkTitle(rs.getString("bk_title"));
				book.setBkAuthor(rs.getString("bk_author"));
				book.setBkPrice(rs.getInt("bk_price"));
				book.setpublisher(new Publisher(rs.getInt("pub_no"),
												rs.getString("pub_name"),
												rs.getString("phone")));
					
				list.add(book);
			}
			close(rs, ps, conn);
			return list;
		}
		
		// 2. 책 등록
		public int registerBook(String title, String author) throws SQLException {
			Connection conn = getConnect();
			String query = "INSERT INTO tb_book(bk_title, bk_author) VALUES(?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			int result = ps.executeUpdate();
			close(ps, conn);
			return result;
		}
		
		// 3. 책 삭제
		public int sellBook(int no) throws SQLException {
			Connection conn = getConnect();
			String query ="DELETE FROM tb_book WHERE bk_no=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, no);
			
			int result = ps.executeUpdate();
			close(ps, conn);
//			System.out.println(ps.executeUpdate()); 
			 // 일부러 예외를 발생시켜, try catch에서 잡게함.
			return result;
		}
}
