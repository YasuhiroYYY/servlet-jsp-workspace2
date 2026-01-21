package test;

import dao.TodosDAO;

public class AllDeleteLogicTest {

	public static void main(String[] args) {
		TodosDAO dao = new TodosDAO();
		boolean t = dao.allDelete("TODOS");
		
		System.out.println(t);
	}

}
