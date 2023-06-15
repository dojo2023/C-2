package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	//それぞれのポイント列を足し合わせる
//	select p.users_id,t_point+g_point+c_point
//	from profilestest as p
//	group by p.users_id desc


	//更新
	public boolean update() {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/ttBC", "sa", "");

			// SQL文を準備する
			String sql = "update BC set NAME=?, READING=?, FEATURE=?, COMPANY=?, PHONE=?, EMAIL=?, ZIPCODE=?, ADDRESS=?, IMPORTANCE=? where NUMBER=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getName() != null && !card.getName().equals("")) {
				pStmt.setString(1, card.getName());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getReading() != null && !card.getReading().equals("")) {
				pStmt.setString(2, card.getReading());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getFeature() != null && !card.getFeature().equals("")) {
				pStmt.setString(3, card.getFeature());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getCompany() != null && !card.getCompany().equals("")) {
				pStmt.setString(4, card.getCompany());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getPhone() != null && !card.getPhone().equals("")) {
				pStmt.setString(5, card.getPhone());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getEmail() != null && !card.getEmail().equals("")) {
				pStmt.setString(6, card.getEmail());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getZipcode() != null && !card.getZipcode().equals("")) {
				pStmt.setString(7, card.getZipcode());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getAddress() != null && !card.getAddress().equals("")) {
				pStmt.setString(8, card.getAddress());
			}
			else {
				pStmt.setString(8, null);
			}
			if (card.getImportance() != null && !card.getImportance().equals("")) {
				pStmt.setString(9, card.getImportance());
			}
			else {
				pStmt.setString(9, null);
			}
			pStmt.setString(10, card.getNumber());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	//選択


}
