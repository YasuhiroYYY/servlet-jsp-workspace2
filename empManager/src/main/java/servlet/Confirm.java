package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.IsExistIdLogic;
import servlet.util.SetEmployee;
import servlet.util.Validator;

@WebServlet(urlPatterns = {"/CreateConfirmServlet", "/UpdateConfirmServlet"})
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String url = null;
		SetEmployee setEmployee = new SetEmployee();
		Employee emp = setEmployee.set(request);
		Validator validator = new Validator();
		List<String> errorList = validator.check(emp);
		switch(path) {
			case "/CreateConfirmServlet" -> {
				// IDの重複チェック
				IsExistIdLogic isExistIdLogic = new IsExistIdLogic();
				if(isExistIdLogic.execute(emp.getId())) {
					errorList.add("そのIDは使えません");
				}
				

				if (errorList.size() > 0) {
					url = "WEB-INF/jsp/input.jsp";
					request.setAttribute("errorList", errorList);
				} else {
					url = "WEB-INF/jsp/confirm.jsp";
				}
				request.setAttribute("h2text", "新規登録");
				request.setAttribute("actionUrl", "CreateDoneServlet");
				request.setAttribute("gobackUrl", "CreateServlet");
				request.setAttribute("btnValue", "登録");
			}
	        case "/UpdateConfirmServlet" -> {
	    		if (errorList.size() > 0) {
	    			url = "WEB-INF/jsp/input.jsp";
	    			request.setAttribute("errorList", errorList);
	    		} else {
	    			url = "WEB-INF/jsp/confirm.jsp";
	    			request.setAttribute("h2text", "社員編集");
					request.setAttribute("actionUrl", "UpdateDoneServlet");
					request.setAttribute("gobackUrl", "UpdateServlet");
					request.setAttribute("btnValue", "編集");
	    		}
			}
		}
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
