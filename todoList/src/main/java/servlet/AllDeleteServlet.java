package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.AllDeleteLogic;
import model.GetListLogic;
import model.Todo;


@WebServlet("/AllDeleteServlet")
public class AllDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tableName = request.getParameter("tableName");
		AllDeleteLogic logic = new AllDeleteLogic();
		
		boolean result = logic.execute(tableName);
		String msg;
		if(result) {
			msg ="Complicated!";
		} else {
			msg = "Not complicated!";
		}
		request.setAttribute("msg", msg);
		
		GetListLogic l = new GetListLogic();
		List<Todo> todoList = l.execute();
		request.setAttribute("todoList", todoList);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
