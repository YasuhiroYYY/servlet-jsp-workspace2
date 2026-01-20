package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.GetListLogic;
import model.KanryouLogic;
import model.Todo;

@WebServlet("/KanryouServlet")
public class KanryouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String priorityStr = request.getParameter("priority");
		int priority = 0;
		try {
			priority = Integer.parseInt(priorityStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		KanryouLogic logic = new KanryouLogic();
		boolean result = logic.execute(priority);
		String msg;
		if(result) {
			msg ="完了しました！";
		} else {
			msg = "完了変換に失敗しました！";
		}
		request.setAttribute("msg", msg);

		GetListLogic l = new GetListLogic();
		List<Todo> todoList = l.execute();
		request.setAttribute("todoList", todoList);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
