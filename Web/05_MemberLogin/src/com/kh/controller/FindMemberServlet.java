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

@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼값 받는다.
		String id = request.getParameter("id");
		
	 /*  
	 * 회원검색 : 검색할 아이디를 입력받아서
		FindMemberServlet / GET
		성공하면 views/find_ok.jsp로 이동해서 정보 출력
		실패하면 views/find_fail.jsp로 이동
	 */
		// 2. DAO
		// 세션 받아오기
		MemberDAO dao = new MemberDAO();
		try {
		Member member = dao.findMember(id);
		
		if(member!=null) {
			// 3. 바인딩
			request.setAttribute("member", member);
			
			// 4. 네비게이션
			request.getRequestDispatcher("views/find_ok.jsp")
			.forward(request, response);
		} else {
			response.sendRedirect("views/find_fail.jsp");
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
