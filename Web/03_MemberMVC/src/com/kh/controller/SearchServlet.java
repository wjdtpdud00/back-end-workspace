package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	 // 1. 폼 가져오기
		String name =request.getParameter("name");
	 // 2. DAO
	  MemberDAO dao = new MemberDAO();
	  Member member = null;
	  try {
		dao.searchMember(name);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 // 3. 바운딩
	  request.setAttribute("info", member);
	 // 바운딩 정보가 있으면 getRequestDispatcher | 없으면 
	  //4. // 3. 네비게이션(만약에 멤버 정보가 없으면...이라는것 추가!)
	  if(member!=null) {
		  request.getRequestDispatcher("search.jsp").forward(request, response);
	  } else {
		  response.sendRedirect("fail.jsp");
	  }
	  
	  }
}


