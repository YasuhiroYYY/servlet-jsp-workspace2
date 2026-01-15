package test;

import java.util.List;

import dao.EmployeesDAO;
import model.Employee;

public class FindByNameTest {

	public static void main(String[] args) {
		EmployeesDAO dao = new EmployeesDAO();
		List<Employee> empList = dao.findByName("姫");
		System.out.println(empList);
	}

}
