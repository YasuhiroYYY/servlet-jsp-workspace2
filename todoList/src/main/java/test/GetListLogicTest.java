package test;

import java.util.List;

import model.GetListLogic;
import model.Todo;

public class GetListLogicTest {

	public static void main(String[] args) {
		GetListLogic logic = new GetListLogic();
		List<Todo> todoList = logic.execute();

		for (Todo todo : todoList) {
			System.out.println(todo);
		}
	}

}
