package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeesDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Employee> findAll(){
		List<Employee> empList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT ID, NAME, AGE FROM EMPLOYEES";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("name");
				int age = rs.getInt("AGE");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return empList;
	}

	public Employee findById(String id){
		Employee emp = null;
		
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					SELECT ID, NAME, AGE FROM EMPLOYEES
					WHERE id = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("AGE");
				emp = new Employee(id, name, age);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return emp;
	} //findById() end
	
	/* method idが存在していたら true */
	public boolean isExistId(String id) {
		Employee emp = findById(id);
		if(emp == null) {
			return false;
		} else {
			return true;
		}
	} // isExistId() end
	
	
	public boolean create(Employee emp) {
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					INSERT INTO employees
					(id, name, age) VALUES (?, ?, ?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());
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

	public boolean upDate(Employee emp) {
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					UPDATE employees SET
					  name = ?, age = ?
					WHERE id =?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getName());
			pStmt.setInt(2, emp.getAge());
			pStmt.setString(3, emp.getId());
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

	public boolean remove(String id) {
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
					DELETE FROM employees 
					WHERE id =?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
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

	public List<Employee> findByName(String n) {
		List<Employee> empList = new ArrayList<>();
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = 
					"""
				    SELECT id, name, age FROM employees 
				    WHERE name like ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + n + "%");
			
	    	ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("name");
				int age = rs.getInt("AGE");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
	} // findByName() end
	
	
	
}
