package test;
import java.util.List;

import dao.RestaurantsDao;
import model.Posts;
import model.Restaurants;

public class RestaurantsDaoTest {
	public static void main(String[] args) {
		RestaurantsDao dao = new RestaurantsDao();

		// select()のrestaurantListのテスト
		System.out.println("---------- select()のテスト ----------");
		List<Restaurants> restaurantList = dao.select(new Restaurants());
		for (Restaurants card : restaurantList) {
			System.out.println("RESTAURANT：" + card.getRestaurant());
			System.out.println("WALK：" + card.getWalk());
			System.out.println("SERVE：" + card.getServe());
			System.out.println("PRICE：" + card.getPrice());
			System.out.println("GENRE：" + card.getGenre());
			System.out.println();
		}

		// select()のshousaiListのテスト
		System.out.println("---------- select()のテスト ----------");
		List<Posts> shousaiList = dao.select(new Posts());
		for (Posts card : shousaiList) {
			System.out.println("RESTAURANT：" + card.getRestaurant());
			System.out.println("PHOTO：" + card.getPhoto());
			System.out.println("TEXT：" + card.getText());
			System.out.println();
		}
		// select()のshiborikomiListのテスト
		System.out.println("---------- select()のテスト ----------");
		List<Restaurants> shiborikomiList = dao.select(new Restaurants());
		for (Posts card : shousaiList) {
			System.out.println("RESTAURANT：" + card.getRestaurant());
			System.out.println("WALK：" + card.getWalk());
			System.out.println("SERVE：" + card.getServe());
			System.out.println("PRICE：" + card.getPrice());
			System.out.println("GENRE：" + card.getGenre());
			System.out.println();
		}
	}



}

