<%--
	JSP Element
	1) 지시어 %@ % : 컨테이너에게 알려줄 내용 지정
	2) 스클릿틀릿 % % : 자바코드는 이 안에 지정(화면 보여주는 용도가 아님)
	3) 출력문 %= % : 출력하는 내용 지정(화면에 보여주는 용도)
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP 주석 :  화면에 보이지 않음 (화면에 안보이고 싶을때)--%>
  	<!-- HTML 주석 : 화면에 보임-->
	<% String name = (String) request.getAttribute("name"); %>
	<h1><%=name %>님, 환영합니다!</h1>
	
	
	
	
</body>
</html>
