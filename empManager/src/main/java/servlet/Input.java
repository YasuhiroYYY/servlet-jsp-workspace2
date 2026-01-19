package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmpByIdLogic;
import servlet.util.SetEmployee;


@WebServlet(urlPatterns = {"/CreateServlet", "/UpdateServlet", "/RemoveServlet"})
public class Input extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "WEB-INF/jsp/create/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String url = null;
		Employee emp = null;
		switch(path) {
			case "/CreateServlet" -> {
				SetEmployee setEmp = new SetEmployee();
				emp = setEmp.set(request);
				request.setAttribute("h2text", "新規登録");
				request.setAttribute("actionURL", "CreateConfirmServlet");
				url = "WEB-INF/jsp/input.jsp";

			}
			case "/UpdateServlet" -> {
				String id = request.getParameter("id");
				FindEmpByIdLogic logic = new FindEmpByIdLogic();
				emp = logic.execute(id);
				request.setAttribute("h2text", "社員編集");
				request.setAttribute("actionURL", "UpdateConfirmServlet");
				url = "WEB-INF/jsp/input.jsp";
			}
			case "/RemoveServlet" -> {
				String id = request.getParameter("id");
				FindEmpByIdLogic logic = new FindEmpByIdLogic();
				emp = logic.execute(id);
				url = "WEB-INF//jsp/remove/removeEmp.jsp";
			}
		}
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
