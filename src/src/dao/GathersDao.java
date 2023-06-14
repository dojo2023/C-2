package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bc;
import model.Gathers;

public class GathersDao {
	// 引数boshuで指定されたレコードを登録し、成功したらtrueを返す
 	public boolean insert(buster_moon gathers) { //登録メソッド
 		Connection conn = null;
 		boolean result = false;
 		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "insert into BC values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getNumber() != null && !card.getNumber().equals("")) {
				pStmt.setString(1, card.getNumber());
			}
			else {
				pStmt.setString(1, null);
			}
	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

		// SQL文を準備する(募集をかける)
        String sql = "insert into gathers values (?, ?, ?)";

        PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		if (.getId() != null && !card.getNumber().equals("")) {
			pStmt.setString(1, card.getNumber());
		}
		else {
			pStmt.setString(1, null);
		}

		if (card.getCompany() != null && !card.getCompany().equals("")) {
			pStmt.setString(2, card.getCompany());
		}
		else {
			pStmt.setString(2, null);
		}

		if (card.getDepartment() != null && !card.getDepartment().equals("")) {
			pStmt.setString(3, card.getDepartment());
		}
		else {
			pStmt.setString(3, null);
		}

		if (card.getPosition() != null && !card.getPosition().equals("")) {
			pStmt.setString(4, card.getPosition());
		}
		else {
			pStmt.setString(4, null);
		}

		if (card.getName() != null && !card.getName().equals("")) {
			pStmt.setString(5, card.getName());
		}
		else {
			pStmt.setString(5, null);
		}

		if (card.getRubi() != null && !card.getRubi().equals("")) {
			pStmt.setString(6, card.getRubi());
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

		if (card.getPhone() != null && !card.getPhone().equals("")) {
			pStmt.setString(9, card.getPhone());
		}
		else {
			pStmt.setString(9, null);
		}

		if (card.getFax() != null && !card.getFax().equals("")) {
			pStmt.setString(10, card.getFax());
		}
		else {
			pStmt.setString(10, null);
		}

		if (card.getEmail() != null && !card.getEmail().equals("")) {
			pStmt.setString(11, card.getEmail());
		}
		else {
			pStmt.setString(11, null);
		}

		if (card.getRemarks() != null && !card.getRemarks().equals("")) {
			pStmt.setString(12, card.getRemarks());
		}
		else {
			pStmt.setString(12, null);
		}


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

	//募集をかける
	//"insert into gathers values (?, ?, ?)"

	//募集の削除
	//"delete from gathers where id = ?"

}
