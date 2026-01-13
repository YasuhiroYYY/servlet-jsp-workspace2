package model;

import dao.EmployeesDAO;

/* id からEmployeeを取得する。 */
public class FindEmpByIdLogic {
	public Employee execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findById(id);
	}
}
