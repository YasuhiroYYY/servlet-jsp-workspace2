package model;

import dao.TodosDAO;

public class KanryouLogic {
	public boolean execute(int priority) {
		TodosDAO dao = new TodosDAO();
		return dao.kanryou(priority);
	}
}
