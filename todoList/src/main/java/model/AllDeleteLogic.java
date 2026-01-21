package model;

import dao.TodosDAO;

public class AllDeleteLogic {
	public boolean execute(String dbname) {
		TodosDAO dao = new TodosDAO();
		return dao.allDelete(dbname);
	}
}
