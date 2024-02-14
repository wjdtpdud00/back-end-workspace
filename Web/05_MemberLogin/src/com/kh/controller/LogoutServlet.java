package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 3. session 죽이기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		if(member!=null) {
			// 세션 죽이기
			session.invalidate();
			System.out.println("로그아웃");
		}
		
		// 4. 네비게이션
		response.sendRedirect("index.jsp");
	}

}
