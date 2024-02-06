package com.kh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * 패키지 연결 확인
	 * - sever 더블클릭 > 모듈에서 삭제 or 추가
	 * */
	// request로 요청받음
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글로 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 요청 받은 이름, 나이, 주소를 받아서 
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		// index.html에서 /register로 요청을 하여 pw.println("<a href='config.jsp?name="+ name +"&count=" + ++count+ "'>config.jsp로 이동</a>");
		// result.jsp 파일로 해당 정보 출력
		PrintWriter pw = response.getWriter();

		// result파일을 주소로 보냄
		pw.println("<a href='result.jsp?name="+ name + "&addr=" + addr + "&age=" + age + "'>결과 확인</a>");
		
		pw.close();
		// <a href='result.jsp'>결과 확인</a> <-- 이 링크를 눌렀을때
		// 해당 result.jsp 페이지에서
		// '주소'에 사는 '나이'세인 '이름' 가입 완료! <-- h1 태그!
	}

}
