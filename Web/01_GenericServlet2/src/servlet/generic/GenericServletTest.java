package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenericServletTest extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		// PrinterWriter 출력문 + res 응답
		// 바로 응답! 클라이언트 브라우저로 응답
		PrintWriter out = res.getWriter();
		
		// html 코드를 서버로 보냄 (웹페이지)
		out.println("<html><body><h1>");
		out.println("Hello, GenericTest~!!!!");
		out.println("</h1></body></html>");
		
		// .close로 자원반납!
		out.close();
		
	}
	
	
}
