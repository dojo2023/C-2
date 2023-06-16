package test;
import java.util.List;

import dao.PostsDao;
import model.Posts;

public class PostsDaoTest {

	// insert()のテスト
			System.out.println("---------- insert()のテスト ----------");
			Posts insRec = new Posts(9, 9, "2023-01-01", "写真9", "店名1", 3, 3, 700, 1, "テキスト9", 100);
			if (dao.insert(insRec)) {
				System.out.println("登録成功！");
				List<Posts> shousaiList = dao.select(insRec);
				for (Posts card : shousaiList) {
					System.out.println("ID：" + card.getId());
					System.out.println("USERS_ID：" + card.getUsers_id());
					System.out.println("DATE：" + card.getDate());
					System.out.println("PHOTO：" + card.getPhoto());
					System.out.println("RESTAURANT：" + card.getRestaurant());
					System.out.println("WALK：" + card.getWalk());
					System.out.println("SERVE：" + card.getServe());
					System.out.println("PRICE：" + card.getPrice());
					System.out.println("GENRE：" + card.getGenre());
					System.out.println("TEXT：" + card.getText());
					System.out.println("POINT：" + card.getPoint());
					System.out.println();
				}
			}
			else {
				System.out.println("登録失敗！");
			}

}
