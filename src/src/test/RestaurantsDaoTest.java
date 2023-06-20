package test;
import java.util.List;

import dao.RestaurantsDao;
import model.Restaurants;

public class RestaurantsDaoTest {
	public static void main(String[] args) {
		RestaurantsDao dao = new RestaurantsDao();

		// select()のrestaurantListのテスト
		System.out.println("---------- select()のテスト ----------");
		List<Restaurants> restaurantList = dao.select("", 1, 0, 0, 0);
		for (Restaurants card : restaurantList) {
			System.out.println("RESTAURANT：" + card.getRestaurant());
			System.out.println("WALK：" + card.getWalk());
			System.out.println("SERVE：" + card.getServe());
			System.out.println("PRICE：" + card.getPrice());
			System.out.println("GENRE：" + card.getGenre());
			System.out.println();
		}
	}
}

