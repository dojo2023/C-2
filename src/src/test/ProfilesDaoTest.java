package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

		Connection conn = null;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/monoshiriplus", "sa", "");
			Profiles profiles = new Profiles("6", "6", "name6", "icon6", "6666", "6", "6", "6");


			// SQL文を準備する
			String sql = "update PROFILES set name=? , icon=? , introduction=? where users_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (profiles.getName() != null && !profiles.getName().equals("")) {
				pStmt.setString(1, profiles.getName());
			}
			else {
				pStmt.setString(1, null);
			}

			if (profiles.getIcon() != null && !profiles.getIcon().equals("")) {
				pStmt.setString(2, profiles.getIcon());
			}
			else {
				pStmt.setString(2, null);
			}

			if (profiles.getIntroduction() != null && !profiles.getIntroduction().equals("")) {
				pStmt.setString(3, profiles.getIntroduction());
			}
			else {
				pStmt.setString(3, null);
			}

			pStmt.setString(4, profiles.getUsers_id());

			// SQL文を実行する
			pStmt.executeUpdate();
			System.out.println("エラー");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLのエラー");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("クラスのエラー");
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					System.out.println("その他のエラー");
				}
			}
		}

	}

}
