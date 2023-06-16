package test;

import java.util.List;

import dao.ProfilesDao;
import model.Profiles;

public class ProfilesDaoTest {
	public static void main(String[] args) {
		ProfilesDao dao = new ProfilesDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Profiles> ProfilesList = dao.select(new Profiles());
		for (Profiles Profiles : ProfilesList) {
			System.out.println("id：" + Profiles.getId());
			System.out.println("users_id：" + Profiles.getUsers_id());
			System.out.println("name：" + Profiles.getName());
			System.out.println("icon：" + Profiles.getIcon());
			System.out.println("introduction：" + Profiles.getIntroduction());
			System.out.println("t_point：" + Profiles.getT_point());
			System.out.println("g_point：" + Profiles.getG_point());
			System.out.println("c_point：" + Profiles.getC_point());

		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Profiles upRec = new Profiles("6", "6", "name6", "icon6", "6666", "6", "6", "6");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Profiles> ProfilesList2 = dao.select(upRec);
			for (Profiles Profiles : ProfilesList2) {
				System.out.println("name：" + Profiles.getName());
				System.out.println("icon：" + Profiles.getIcon());
				System.out.println("introduction：" + Profiles.getIntroduction());
				System.out.println("t_point：" + Profiles.getT_point());
				System.out.println("g_point：" + Profiles.getG_point());
				System.out.println("c_point：" + Profiles.getC_point());
			}
		}
		else {
			System.out.println("更新失敗！");
		}

		// dalete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete("6")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}
