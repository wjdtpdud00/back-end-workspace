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
		// .setCharacterEncoding(구현환경) :  한글로 처리
		request.setCharacterEncoding(getServletInfo());
		response.setContentType("text/html;charset=utf-8");
		
		// 이름, 나이, 주소 값 받기
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		// PrintWriter : 파일에 쓰는 메소드 제공
		PrintWriter pw = response.getWriter();
		
		// 주소를 보내는 용도
		pw.println("<a href='result.jsp?name="+ name + "&addr=" + addr + "&age=" + age + "'>결과 확인</a>");
		
		pw.close();
	}

}