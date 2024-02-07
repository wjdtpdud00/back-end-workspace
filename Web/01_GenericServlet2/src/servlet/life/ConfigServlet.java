package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int count = 0;
	
	private String name;
	private String addr;
	
	// init에 키값 지정한것에 대하여 값 저장
	public void init(ServletConfig config) throws ServletException {
		name=config.getInitParameter("name");
		addr=config.getInitParameter("addr");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// printWirter 출력하고 쓴다 =  외부로 보낸다.
		PrintWriter pw = response.getWriter();
		// 외부로 보낸다.
		pw.println("<h2>이름 : " + name + "</h2>");
		pw.println("<h2>주소 : " + addr + "</h2>");
		// <a href=“URL”>| html처럼 action이없음 url로 연결 후  값을 한개씩 연결 해줘야함
		pw.println("<a href='config.jsp?name="+ name +"&count=" + ++count + "'>config.jsp로 이동</a>");	
		
		// 자원반납을 하지 않을때 : Too many connection 에러
		pw.close();
	}
	
	
	
	
}