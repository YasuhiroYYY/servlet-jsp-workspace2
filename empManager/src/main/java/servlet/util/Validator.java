package servlet.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import model.Employee;

public class Validator {
	private static final Pattern pattern = 
			Pattern.compile("^EMP[0-9]{3}$");
	
	
	public List<String> check(Employee emp){
		List<String> errorList = new ArrayList<>();
		
		String id = emp.getId();
		if(isNull(id)) {
			errorList.add("IDが未入力です。");
		} else if (pattern.matcher(id).matches() == false) {
			errorList.add("IDの形式が違います。");
		}
		
		if (isNull(emp.getName()) == true) {
			errorList.add("名前が未入力です。");
		}
		
		if (emp.getAge() == 0) {
			errorList.add("年齢が数字ではありません。");
		}
		return errorList;
	}
	/*
	 * str が空であればtrueを返す。
	 * @param str
	 * @return
	 */
	
	
	private boolean isNull(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
	
}
