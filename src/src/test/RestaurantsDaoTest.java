package test;
import java.util.List;

import dao.RestaurantsDao;
import model.Restaurants;

public class RestaurantsDaoTest {
	public static void main(String[] args) {
		RestaurantsDao dao = new RestaurantsDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Restaurants> restaurantList = dao.select(new Restaurants());
		for (Restaurants card : restaurantList) {
			System.out.println("POSTS_RESTAURANT：" + card.getPosts_restaurant());
			System.out.println("WALK：" + card.getWalk());
			System.out.println("SERVE：" + card.getServe());
			System.out.println("PRICE：" + card.getPrice());
			System.out.println("POSTS_GENRE：" + card.getPosts_genre());
			System.out.println();
		}

//			RestaurantsDao dao = new RestaurantsDao();
//
//			// select()のテスト
//			System.out.println("---------- select()のテスト ----------");
//			List<Restaurants> restaurantList = dao.select(new String());
//			for (Restaurants card : Posts_restaurantList) {
//				System.out.println("POSTS_RESTAURANT：" + card.getPosts_restaurant());
//				System.out.println("WALK：" + card.getWalk());
//				System.out.println("SERVE：" + card.getServe());
//				System.out.println("PRICE：" + card.getPrice());
//				System.out.println("POSTS_GENRE：" + card.getPosts_genre());
//				System.out.println();
//			}
		
	}
}
