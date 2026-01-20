package model;

import java.util.List;

import dao.TodosDAO;

public class GetListLogic {
	public List<Todo> execute(){
		TodosDAO dao = new TodosDAO();
		return dao.findAll();
	}
}
