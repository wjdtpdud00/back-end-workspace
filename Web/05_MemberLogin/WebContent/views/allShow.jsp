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
	<h1>전체 회원 목록</h1>
	
	<table border="1">
	 	<tr>
	 		<th>아이디</th>
	 		<th>이름</th>
	 		<th>비밀번호</th>
	 	</tr>
	 	<%
			ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
			for(Member m : list) { %>
			<tr>
				<td><%=m.getId() %></td>
				<td><%=m.getName() %></td>
				<td><%=m.getPassword() %></td>
			</tr>
		<%} %>
	</table>
	
	<a href="/index.jsp">첫 페이지로 이동</a>
	
</body>
</html>