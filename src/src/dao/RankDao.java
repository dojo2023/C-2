package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Profiles;

public class RankDao {



	//ランキングの表示
	//各ポイント取得テーブルからポイントを取得し、対応するポイント列を更新
//	update profilestest
//	set c_point=(select SUM(c.point) as cポイントの合計
//	from profilestest as p
//	join  comments as c on p.users_id = c.users_id
//	where c.date>='2023-03-01' and date<'2023-04-01'
//	group by p.users_id
//	having p.users_id=2 )
//	where users_id=2

	//それぞれのポイント列等を取得する
//	select p.users_id,t_point,g_point,c_point,icon,name
//	from profilestest as p
//	group by p.users_id


	//更新
	public List<Profiles> select() {
		Connection conn = null;
		List<Profiles> profilesList = new ArrayList<Profiles>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/ttBC", "sa", "");

			// SQL文を準備する
			String sql = "update profiles\r\n"
					+ "	set c_point=(select SUM(c.point)\r\n"
					+ "	from profilestest as p\r\n"
					+ "	join  comments as c on p.users_id = c.users_id\r\n"
					+ "	where c.date>='?-?-01' and date<'?-?-01'\r\n"
					+ "	group by p.users_id\r\n"
					+ "	having p.users_id=? )\r\n"
					+ "	where users_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文の日付の指定部分を完成させる
			Calendar calendar=Calendar.getInstance();
			int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH)+1;
            int year2;
            int month2;

            if (month == 12) {
            	year2=calendar.get(Calendar.YEAR)+1;
            	month2=1;
            } else {
            	year2=calendar.get(Calendar.YEAR);
                month2=calendar.get(Calendar.MONTH)+2;
            }

            String monthS = String.format("%02d",month);
            String monthS2 = String.format("%02d",month2);
            String yearS = String.valueOf(year);
            String yearS2 = String.valueOf(year2);

			pStmt.setString(1, yearS);
			pStmt.setString(2, monthS);
			pStmt.setString(3, yearS2);
			pStmt.setString(4, monthS2);

			//SQL文のユーザーを全部取り出す部分を完成させる

			String x;;

			for (int i = 0; i <= profilesList.size(); i++) {

				x = String.valueOf(i);

				pStmt.setString(5, x);
				pStmt.setString(6, x);

			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Profiles profiles = new Profiles(
				rs.getString("ユーザーID"),
				rs.getString("名前"),
				rs.getString("tポイント"),
				rs.getString("gポイント"),
				rs.getString("cポイント"),
				rs.getString("アイコン")
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
