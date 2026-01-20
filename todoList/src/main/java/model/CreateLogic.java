package model;

import dao.TodosDAO;

public class CreateLogic {
	public boolean execute(String text) {
		TodosDAO dao = new TodosDAO();
		return dao.create(text);
	}
}
