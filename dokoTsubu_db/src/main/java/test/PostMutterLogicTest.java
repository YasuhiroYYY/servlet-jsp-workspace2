package test;

import model.Mutter;
import model.PostMutterLogic;

public class PostMutterLogicTest {

	public static void main(String[] args) {
		Mutter m =new Mutter("浦島太郎", "竜宮城へ行きたいな");
		PostMutterLogic logic = new PostMutterLogic();
		if(logic.execute(m)) {
			System.out.println("登録しました");
		} else {
			System.out.println("登録に失敗しました");
		}
	}

}
