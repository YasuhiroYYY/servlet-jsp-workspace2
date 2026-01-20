package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

public class TodosDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/todoList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Todo> findAll(){
		List<Todo> todoList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT priority, TEXT, KEKKA FROM TODOS ORDER BY priority ASC; ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int priority = rs.getInt("priority");
				String text = rs.getString("text");
				String kekka = rs.getString("kekka");
				Todo todo = new Todo(priority, text, kekka);
				todoList.add(todo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return todoList;
	}

	public Todo findById(int priority){
		Todo todo = null;
		
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					SELECT priority, text, kekka FROM TODOS
					WHERE priority = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, priority);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String text = rs.getString("text");
				String kekka = rs.getString("kekka");
				todo = new Todo(priority, text, kekka);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return todo;
	} //findById() end
	
	/* method idが存在していたら true */
	public boolean isExistId(int priority) {
		Todo todo = findById(priority);
		if(todo == null) {
			return false;
		} else {
			return true;
		}
	} // isExistId() end
	
	
	public boolean create(String text) {
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					INSERT INTO todos
					(text) VALUES (?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, text);

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	} // create() end

	public boolean upDate(Todo todo) {
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					UPDATE todos SET
					  text = ?, kekka = ?
					WHERE id =?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, todo.getText());
			pStmt.setString(2, todo.getKekka());
			pStmt.setInt(3, todo.getPriority());
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	} // create() end

	public boolean remove(int priority) {
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					DELETE FROM todos 
					WHERE priority =?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, priority);
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	} // remove() end

	public boolean kanryou(int priority) {
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					UPDATE todos
					SET kekka = '完了！'
					WHERE priority = ?;
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, priority);
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	} // remove() end


	
	
	
}
