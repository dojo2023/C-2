package test;

import dao.UsersDao;
import model.Users;

public class UsersDaoTest {

//	public static void main(String[] args) {
//		testIsLoginOK1();	// ユーザーが見つかる場合のテスト
//		testIsLoginOK2();	// ユーザーが見つからない場合のテスト
//	}
//
//	// ユーザーが見つかる場合のテスト
//	public static void testIsLoginOK1() {
//		UsersDao dao = new UsersDao();
//		if (dao.isLoginOK(new Users("mail@company1.jp", "a1a1"))) {
//			System.out.println("testIsLoginOK1：テストが成功しました");
//		}
//		else {
//			System.out.println("testIsLoginOK1：テストが失敗しました");
//		}
//	}
//
//	// ユーザーが見つからない場合のテスト
//	public static void testIsLoginOK2() {
//		UsersDao dao = new UsersDao();
//		if (!dao.isLoginOK(new Users("mail@company1.jp", "a1a1"))) {
//			System.out.println("testIsLoginOK2：テストが成功しました");
//		}
//		else {
//			System.out.println("testIsLoginOK2：テストが失敗しました");
//		}
//	}


	// insert()のテスト
	public static void main(String[] args) {
	UsersDao dao = new UsersDao();

	System.out.println("---------- insert()のテスト ----------");
	Users insRec = new Users(null , "takebe@shunyu" , "YSLsolution");
	if (dao.insert(insRec)) {
		System.out.println("登録成功！");
//		List<Users> cardList3 = dao.select(insRec);
//		for (Users users : cardList3) {
//			System.out.println("NUMBER：" + users.getId());
//			System.out.println("COMPANY：" + users.getMail_address());
//			System.out.println("DEPARTMENT：" + users.getPassword());
//			System.out.println();
		}

	else {
		System.out.println("登録失敗！");
	}

	}



}


