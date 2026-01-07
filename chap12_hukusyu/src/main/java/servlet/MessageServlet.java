package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> messages = new ArrayList<>();
		messages.add("ごきげんよう");
		messages.add("こんにちは");
		messages.add("さようなら");
		request.setAttribute("messages", messages);
		String url = "WEB-INF/jsp/messages.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
