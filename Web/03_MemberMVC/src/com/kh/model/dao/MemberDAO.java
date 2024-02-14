package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {

	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		close(ps, conn);
	}
	
	public int registerMember(Member vo) throws SQLException {
		Connection conn = getConnect();
		
		String query = "INSERT INTO member VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		
		int result = ps.executeUpdate();
		close(ps, conn);
		return result;
	}
	
	// dao.showAllMember() : ArrayList<Member> <-- list로 담아서
	public ArrayList<Member> showAllMember() throws SQLException {
		// [강사님 풀이]
		Connection conn = getConnect();
		
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<Member> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new Member(rs.getString("id"), 
					rs.getString("password"), 
					rs.getString("name")));
		}
		close(rs, ps, conn);
		return list;
		
		
//		Connection conn;
//
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");
//			String query = "SELECT * FROM member";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ResultSet rs = ps.executeQuery();
//			
//			ArrayList<Member>list = new ArrayList<>();
//			
//			while(rs.next()) {
//				Member member = new Member();
//				member.setId(rs.getString("id"));
//				member.setPassword(rs.getString("password"));
//				member.setName(rs.getString("name"));
//				list.add(member);
//			}
//			return list;
	}

	public Member searchMember(String name) throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM member WHERE name = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member= new Member(rs.getString("id"),
					rs.getString("password"),
					rs.getString("name"));
		}
		close(rs, ps, conn);
		return member;
	}

	
	
	
	
	
	
}
