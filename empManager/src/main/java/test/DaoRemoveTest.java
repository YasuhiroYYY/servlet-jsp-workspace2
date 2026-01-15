package test;

import dao.EmployeesDAO;

public class DaoRemoveTest {

	public static void main(String[] args) {
		EmployeesDAO dao = new EmployeesDAO();
		boolean result = dao.remove("EMP005");
		if (result) {
			System.out.println("削除しました。");
		} else {
			System.out.println("失敗しました。");
		}
	}

}
