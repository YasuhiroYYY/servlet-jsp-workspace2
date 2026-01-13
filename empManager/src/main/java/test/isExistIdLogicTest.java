package test;

import model.IsExistIdLogic;

public class isExistIdLogicTest {

	public static void main(String[] args) {
		String id = "EMP001";
		IsExistIdLogic logic = new IsExistIdLogic();
		if(logic.execute(id) == true) {
			System.out.println("そのIDは存在しています。");
		} else {
			System.out.println("そのIDは存在していません。");
		}
	}

}
