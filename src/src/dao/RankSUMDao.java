package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Profiles;

public class RankSUMDao {



	//ランキングの表示
	//各ポイント取得テーブルからポイントを取得し、対応するポイント列を更新


	//更新取得
	public List<Profiles> select(String users_id) {
		Connection conn = null;
		List<Profiles> profilesList = new ArrayList<Profiles>();
		List<Profiles> profilesList2 = new ArrayList<Profiles>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/buster_moon", "sa", "");

			//profilesテーブルのリストの数を調べるための作業
			String sql3 ="select p.users_id,name,icon,t_point,g_point,c_point "
					+ "from profiles as p "
					+ "group by p.users_id";

			PreparedStatement pStmt3 = conn.prepareStatement(sql3);
			ResultSet rs3 = pStmt3.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs3.next()) {
				Profiles profiles = new Profiles(
				rs3.getString("USERS_ID"),
				rs3.getString("NAME"),
				rs3.getString("ICON"),
				rs3.getString("T_POINT"),
				rs3.getString("G_POINT"),
				rs3.getString("C_POINT")
				);
				profilesList2.add(profiles);
			}

			//ポイントをそれぞれから集めて更新
			//ループ開始
			for (int i = 1; i <= profilesList2.size(); i++)
			{
				//コメントポイント
				// SQL文を準備する
				String sql = "update profiles "
						+ "	set c_point=(select SUM(c.point)"
						+ "	from profiles as p"
						+ "	join  comments as c on p.users_id = c.users_id"
						+ "	group by p.users_id"
						+ "	having p.users_id=? )"
						+ "	where users_id=?";

				String sqlT = "update profiles "
						+ "	set t_point=(select SUM(t.point)"
						+ "	from profiles as p"
						+ "	join  posts as t on p.users_id = t.users_id"
						+ "	group by p.users_id"
						+ "	having p.users_id=? )"
						+ "	where users_id=?";

				String sqlG = "update profiles "
						+ "	set g_point=(select SUM(g.point)"
						+ "	from profiles as p"
						+ "	join  gathers as g on p.users_id = g.users_id"
						+ "	group by p.users_id"
						+ "	having p.users_id=? )"
						+ "	where users_id=?";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				PreparedStatement pStmtT = conn.prepareStatement(sqlT);
				PreparedStatement pStmtG = conn.prepareStatement(sqlG);



				//ユーザIDを入れていく
				String x = String.valueOf(i);

					pStmt.setString(1, x);
					pStmt.setString(2, x);
					pStmtT.setString(1, x);
					pStmtT.setString(2, x);
					pStmtG.setString(1, x);
					pStmtG.setString(2, x);

					//SQL文実行
					pStmt.executeUpdate();
					pStmtT.executeUpdate();
					pStmtG.executeUpdate();
			}
			//ループ終了

			//NULLを出さないようにする処理
			String sqlNullC ="update profiles set c_point=0"
					+ " where c_point is null;";
			String sqlNullG ="update profiles set g_point=0"
					+ " where g_point is null;";
			String sqlNullT ="update profiles set t_point=0"
					+ " where t_point is null;";
			PreparedStatement pStmtNullC = conn.prepareStatement(sqlNullC);
			PreparedStatement pStmtNullG = conn.prepareStatement(sqlNullG);
			PreparedStatement pStmtNullT = conn.prepareStatement(sqlNullT);
			pStmtNullC.executeUpdate();
			pStmtNullG.executeUpdate();
			pStmtNullT.executeUpdate();

			//select部分
			String sql2 ="select p.users_id,name,icon,t_point,g_point,c_point "
					+ "from profiles as p "
					+ "where users_id=?"
					+ "group by p.users_id";

			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			pStmt2.setString(1,users_id);
			ResultSet rs = pStmt2.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Profiles profiles = new Profiles(
				rs.getString("USERS_ID"),
				rs.getString("NAME"),
				rs.getString("ICON"),
				rs.getString("T_POINT"),
				rs.getString("G_POINT"),
				rs.getString("C_POINT")
				);
				profilesList.add(profiles);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			profilesList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			profilesList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					profilesList = null;
				}
			}
		}

		// 結果を返す
		return profilesList;
	}

}
