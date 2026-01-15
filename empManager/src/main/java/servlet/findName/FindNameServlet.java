package servlet.findName;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindListByNameLogic;


@WebServlet("/FindNameServlet")
public class FindNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n = request.getParameter("name");
		FindListByNameLogic logic = new FindListByNameLogic();
		List<Employee> empList = logic.execute(n);
		request.setAttribute("empList", empList);
		String url = "WEB-INF/jsp/findName/findNameEmpList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
