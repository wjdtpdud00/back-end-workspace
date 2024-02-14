package com.kh.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Member;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 1. 세션을 받아온다.
		HttpSession session = request.getSession();
		
		// 2. 세션에 바인딩된 값이 있다면 그 값을 찾아온다.
		Member member = (Member)session.getAttribute("info"); // 내가 설정한 info로 가지고옴
		
		if(member!=null) { // 로그인 된 상태
			System.out.println(member);// 확인차..
			request.setAttribute("product", "notebook");
			request.getRequestDispatcher("CarServlet").forward(request, response);
			//response.sendRedirect("CartServlet");// 이동
		}
	}

}
