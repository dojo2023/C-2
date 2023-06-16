package test;
import java.util.List;

import dao.RankSUMDao;
import model.Profiles;




public class RankSUMDaoTest {
	public static void main(String[] args) {

		RankSUMDao rankSUMDao = new RankSUMDao();

		// select()のテスト
		System.out.println("---------- ランクのselect()のテスト ----------");
		List<Profiles> profilesList2 = rankSUMDao.select();
		for(Profiles profiles:profilesList2)
		{
			System.out.println("ユーザID："+profiles.getUsers_id());
			System.out.println("名前："+profiles.getName());
			System.out.println("アイコン："+profiles.getIcon());
			System.out.println("Tポイント："+profiles.getT_point());
			System.out.println("Gポイント："+profiles.getG_point());
			System.out.println("Cポイント："+profiles.getC_point());
		}
	}


}
