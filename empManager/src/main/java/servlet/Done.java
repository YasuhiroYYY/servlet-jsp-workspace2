package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.PostEmpLogic;
import model.RemoveEmpLogic;
import model.UpdateEmpLogic;
import servlet.util.SetEmployee;


@WebServlet(urlPatterns = {"/CreateDoneServlet", "/UpdateDoneServlet", "/RemoveDoneServlet"})
public class Done extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String url = null;
		String msg = null;
		String syori = null;
		boolean result = false;
		
		switch(path) {
		case "/CreateDoneServlet" ->{
				syori = "登録";
				SetEmployee setEmp = new SetEmployee();
				Employee emp = setEmp.set(request);
				PostEmpLogic logic = new PostEmpLogic();
				result = logic.execute(emp);

				url = "WEB-INF/jsp/create/createDone.jsp";
			}
			case "/UpdateDoneServlet" ->{
				syori = "更新";
				SetEmployee setEmployee = new SetEmployee();
				Employee emp = setEmployee.set(request);
				UpdateEmpLogic logic = new UpdateEmpLogic();
				result = logic.execute(emp);
				url = "WEB-INF/jsp/update/updateDone.jsp";
			}
			case "/RemoveDoneServlet" ->{
				syori = "削除";
				String id = request.getParameter("id");
				RemoveEmpLogic logic = new RemoveEmpLogic();
				result = logic.execute(id);
				url = "WEB-INF/jsp/remove/removeDone.jsp";
			}
		}
		if(result) {
			msg = syori + "しました。";
		} else {
			msg = syori + "に失敗しました";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
