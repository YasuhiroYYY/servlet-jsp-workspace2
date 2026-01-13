package model;

import dao.EmployeesDAO;


/*  そのidが存在していたらtrueを返す  */
public class IsExistIdLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.isExistId(id);
	}
}
