package test;

import dao.GathersDao;

public class GathersDaoTest {

	// delete()のテスト
	public static void main(String[] args) {
	GathersDao dao = new GathersDao();

	System.out.println("---------- delete()のテスト ----------");
	if (dao.delete("7")) {
		System.out.println("削除成功！");
	}
	else {
		System.out.println("削除失敗！");
	}

	}




	//insert()のテスト
//	public static void main(String[] args) {
//	GathersDao dao = new GathersDao();
//
//	System.out.println("---------- insert()のテスト ----------");
//	Gathers insRec = new Gathers(null , "7" , "2023-06-16" , "7");
//	if (dao.insert(insRec)) {
//		System.out.println("登録成功！");
//		}
//
//	else {
//		System.out.println("登録失敗！");
//	}
//
//	}

}
