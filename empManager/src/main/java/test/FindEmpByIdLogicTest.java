package test;

import model.Employee;
import model.FindEmpByIdLogic;

public class FindEmpByIdLogicTest {

	public static void main(String[] args) {
		String id = "EMP001";
		FindEmpByIdLogic logic = new FindEmpByIdLogic();
		Employee emp = logic.execute(id);
		System.out.println(emp);
	}

}
