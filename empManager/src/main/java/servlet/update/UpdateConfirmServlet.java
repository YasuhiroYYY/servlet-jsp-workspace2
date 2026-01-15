package servlet.update;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import servlet.util.SetEmployee;
import servlet.util.Validator;

@WebServlet("/UpdateConfirmServlet")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SetEmployee setEmployee = new SetEmployee();
		Employee emp = setEmployee.set(request);
		Validator validator = new Validator();
		List<String> errorList = validator.check(emp);
		String url = null;
		if (errorList.size() > 0) {
			url = "WEB-INF/jsp/update/updateEmp.jsp";
			request.setAttribute("errorList", errorList);
		} else {
			url = "WEB-INF/jsp/update/updateConfirm.jsp";
		}
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
