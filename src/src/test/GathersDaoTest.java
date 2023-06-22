package test;

import java.util.List;

import dao.GathersDao;
import model.Gathers;

public class GathersDaoTest {

	// delete()のテスト
//	public static void main(String[] args) {
//	GathersDao dao = new GathersDao();

//	System.out.println("---------- delete()のテスト ----------");
//	if (dao.delete("7")) {
//		System.out.println("削除成功！");
//	}
//	else {
//		System.out.println("削除失敗！");
//	}
//
//	}




	
	public static void main(String[] args) {
		GathersDao dao = new GathersDao();
		//select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Gathers> gathersList = dao.select("店名3",1 ,1 );
		for (Gathers card : gathersList) {
			System.out.println("RESTAURANT_NAME：" + card.getRestaurant_name());
			System.out.println("TIME：" + card.getTime());
			System.out.println("PLACE：" + card.getPlace());
		}
	
		
		//insert()のテスト
	System.out.println("---------- insert()のテスト ----------");
	Gathers insRec = new Gathers("店名３" , 2 , 2  );
	if (dao.insert(insRec)) {
		System.out.println("登録成功！");
		List<Gathers> gatherList =dao.select();
		for (Gathers card : gathersList) {
			System.out.println("RESTAURANT_NAME：" + card.getRestaurant_name());
			System.out.println("TIME：" + card.getTime());
			System.out.println("PLACE：" + card.getPlace());
			
		}
	}

	else {
		System.out.println("登録失敗！");
	}
	//select()のテスト
	}

}
