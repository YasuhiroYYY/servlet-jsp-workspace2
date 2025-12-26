package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FieldCounterServlet")
public class FieldCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer count;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		count = 0;
		
		System.out.println("init()が実行されました");
	}

	public void destroy() {
		System.out.println("destroy()が実行されました");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count++;
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<meta charset=\"UTF-8\"");
		out.println("</head><body>");
		out.println("<p>訪問回数： " + count + "</p>");
		out.println("<a href=\"FieldCounterServlet\">更新</a>");
		out.println("</body></html>");

		
	}

}
