package model;

import dao.TodosDAO;

public class RemoveLogic {
	public boolean execute(int priority) {
		TodosDAO dao = new TodosDAO();
		return dao.remove(priority);
	}
}
