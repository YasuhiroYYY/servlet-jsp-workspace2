package servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import model.Todo;

public class SetTodo {
	public Todo set(HttpServletRequest request) {
		String priorityStr = request.getParameter("priority").trim().toUpperCase();
		String text = request.getParameter("text").trim();
		String kekka = request.getParameter("kekka").trim();
		int priority = 0;
		try {
			priority = Integer.parseInt(priorityStr);			
		} catch (NumberFormatException e) {
			priority = 0;
		}
		Todo todo = new Todo(priority, text, kekka);
		
		
		return todo;
		
	}
}
