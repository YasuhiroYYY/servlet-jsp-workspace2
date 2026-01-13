package servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import model.Employee;

public class SetEmployee {
	public Employee set(HttpServletRequest request) {
		String id = request.getParameter("id").trim().toUpperCase();
		String name = request.getParameter("name").trim();
		String ageStr = request.getParameter("age").trim();
		int age = 0;
		try {
			age = Integer.parseInt(ageStr);			
		} catch (NumberFormatException e) {
			age = 0;
		}
		Employee emp = new Employee(id, name, age);
		
		
		return emp;
		
	}
}
