package test;

import java.util.List;

import model.Employee;
import model.GetListLogic;

public class GetListLogicTest {

	public static void main(String[] args) {
		GetListLogic logic = new GetListLogic();
		List<Employee> empList = logic.execute();
		
		for(Employee emp : empList) {
			System.out.println(emp);
		}
	}

}
