package model;

import java.util.List;

import dao.EmployeesDAO;

public class FindListByNameLogic {
	public List<Employee> execute(String n){
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findByName(n);
	}
	
}
