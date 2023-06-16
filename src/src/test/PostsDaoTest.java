package test;
import java.util.List;

import dao.PostsDao;
import model.Bc;
import model.Posts;

public class PostsDaoTest {
	public static void main(String[] args) {
		PostsDao dao = new PostsDao();

	// insert()のテスト
			System.out.println("---------- insert()のテスト ----------");
			Posts insRec = new Posts(null, "9", "2023-09-09", "写真9", "店名1", "3", "3", "700", "1", "テキスト9", "100");
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
}



//select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Bc> cardList2 = dao.select(new Bc());
		for (Bc card : cardList2) {
			System.out.println("NUMBER：" + card.getNumber());
			System.out.println("COMPANY：" + card.getCompany());
			System.out.println("DEPARTMENT：" + card.getDepartment());
			System.out.println("POSITION：" + card.getPosition());
			System.out.println("NAME：" + card.getName());
			System.out.println("ZIPCODE：" + card.getZipcode());
			System.out.println("ADDRESS：" + card.getAddress());
			System.out.println("PHONE：" + card.getPhone());
			System.out.println("FAX：" + card.getFax());
			System.out.println("EMAIL：" + card.getEmail());
			System.out.println("REMARKS：" + card.getRemarks());
			System.out.println();
		}

