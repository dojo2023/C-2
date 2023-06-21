package test;
import java.util.List;

import dao.CommentsDao;
import model.Comments;

public class CommentsDaoTest {
	public static void main(String[] args) {
		CommentsDao dao = new CommentsDao();

	// insert()とselect()のテスト
			System.out.println("---------- insert()のテスト ----------");
			Comments insRec = new Comments(null, "2", "2", "2023-05-03", "34","コメント11");
			if (dao.insert(insRec)) {
				System.out.println("登録成功！");
				List<Comments> CommentsList = dao.select("2");
				for (Comments card : CommentsList) {
					System.out.println("ID：" + card.getId());
					System.out.println("USERS_ID：" + card.getUsers_id());
					System.out.println("POSTS_ID：" + card.getPosts_id());
					System.out.println("DATE：" + card.getDate());
					System.out.println("POINT：" + card.getPoint());
					System.out.println("TEXT：" + card.getText());
					System.out.println("NAME：" + card.getName());
					System.out.println("ICON：" + card.getIcon());
					System.out.println();
				}
			}
			else {
				System.out.println("登録失敗！");
			}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");;
		if (dao.delete("21")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}


	}
}
