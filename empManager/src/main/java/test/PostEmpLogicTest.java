package test;

import model.PostEmpLogic;
import model.Employee;

public class PostEmpLogicTest {

	public static void main(String[] args) {
		Employee emp = new Employee("EMP004", "熊五郎", 23);
		PostEmpLogic logic = new PostEmpLogic();
		if(logic.execute(emp)) {
			System.out.println("登録しました");
		} else {
			System.out.println("登録に失敗しました");
		}
		
	}

}
