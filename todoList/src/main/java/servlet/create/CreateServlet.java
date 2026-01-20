package servlet.create;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.CreateLogic;
import model.GetListLogic;
import model.Todo;


@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("do");
		CreateLogic logic = new CreateLogic();
		boolean result = logic.execute(text);
		
		String msg;
		if(result) {
			msg ="登録に成功しました";
		} else {
			msg = "登録に失敗しました";
		}
		request.setAttribute("msg", msg);
		
		GetListLogic l = new GetListLogic();
		List<Todo> todoList = l.execute();
		
		request.setAttribute("todoList", todoList);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
