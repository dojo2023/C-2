//package test;
//import java.util.List;
//
//import dao.PostsDao;
//import model.Posts;
//import model.Restaurants;
//
//public class PostsDaoTest {
//	public static void main(String[] args) {
//		PostsDao dao = new PostsDao();
//
//	// insert()とselect()のテスト
//			System.out.println("---------- insert()のテスト ----------");
//			Posts insRec = new Posts(null, "9", "2023-09-09", "写真9", "店名1", "3", "3", "700", "1", "テキスト9", "100");
//			if (dao.insert(insRec)) {
//				System.out.println("登録成功！");
//				List<Posts> postsList = dao.select();
//				for (Posts card : postsList) {
//					System.out.println("ID：" + card.getId());
//					System.out.println("USERS_ID：" + card.getUsers_id());
//					System.out.println("DATE：" + card.getDate());
//					System.out.println("PHOTO：" + card.getPhoto());
//					System.out.println("RESTAURANT：" + card.getRestaurant());
//					System.out.println("WALK：" + card.getWalk());
//					System.out.println("SERVE：" + card.getServe());
//					System.out.println("PRICE：" + card.getPrice());
//					System.out.println("GENRE：" + card.getGenre());
//					System.out.println("TEXT：" + card.getText());
//					System.out.println("POINT：" + card.getPoint());
//					System.out.println("NAME：" + card.getName());
//					System.out.println("ICON：" + card.getIcon());
//					System.out.println();
//				}
//			}
//			else {
//				System.out.println("登録失敗！");
//			}
//
//		//投稿の際のジャンルでの店舗絞り込みテスト
//			System.out.println("---------- selectGenre()のテスト ----------");
//			List<Restaurants> shiborikomiList = dao.selectGenre("2");
//			for (Restaurants card : shiborikomiList) {
//				System.out.println("RESTAURANT：" + card.getRestaurant());
//				System.out.println("GENRE：" + card.getGenre());
//			}
//
//	}
//}
