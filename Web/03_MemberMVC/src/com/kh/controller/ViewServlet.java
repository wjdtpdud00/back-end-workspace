package com.kh.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		// [강사님 풀이]
		
		// 폼값작성, vo 생략 -> view로 이미 받음 
		// 1. DAO 리턴 받기
		// dao.showAllMember() : ArrayList<Member> <-- list로 담아서
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		try {
			 list = dao.showAllMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		// 2. 바인딩 : list 전체 
		// attribute(키 : 보낼값)
		request.setAttribute("list", list);
		
//		// 3. 네비게이션(응답 경로) : view.jsp
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}
		
		
	
		
		
		
		
//		Member member = new Member();
//		MemberDAO dao = new MemberDAO();
//
//		try {
//			dao.showAllMember(member);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//			
//		try {
//			request.setAttribute("id", dao.showAllMember(member));
//			request.setAttribute("password", dao.showAllMember(member));
//			request.setAttribute("name", dao.showAllMember(member));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher("view.jsp").forward(request, response);
//	}

}
