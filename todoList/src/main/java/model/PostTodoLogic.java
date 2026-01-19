package model;

import java.util.List;

public class PostTodoLogic {
	public void execute(Todo todo, List<Todo> todoList) {
		todoList.add(0, todo);
	}
}
