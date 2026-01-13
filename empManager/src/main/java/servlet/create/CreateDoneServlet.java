package servlet.create;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.PostEmpLogic;
import servlet.util.SetEmployee;


@WebServlet("/CreateDoneServlet")
public class CreateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SetEmployee setEmp = new SetEmployee();
		Employee emp = setEmp.set(request);
		PostEmpLogic logic = new PostEmpLogic();
		String msg = null;
		if(logic.execute(emp)) {
			msg = "登録しました。";
		} else {
			msg = "登録に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/create/createDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
