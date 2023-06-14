package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Profiles;

public class ProfilesDao {
	//表示
	// 引数profilesで検索項目を指定し、検索結果のリストを返す
	public List<Profiles> select(Profiles param) {
		Connection conn = null;
		List<Profiles> profilesList = new ArrayList<Profiles>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/monoshiriplus", "sa", "");

			// SQL文を準備する
			String sql = "select * from profiles where users_id = ?";
		    PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUsers_id() != null) {
				pStmt.setString(1, "%" + param.getUsers_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Profiles profiles = new Profiles(
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
	
	//編集
	public boolean update(Profiles profiles) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/monoshiriplus", "sa", "");

			// SQL文を準備する
			String sql = "update PROFILES set NAME='?' , ICON='?' , INTRODUCTION='?' where users_id=?";
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
			
	//投稿削除
	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/monoshiriplus", "sa", "");

			// SQL文を準備する
			String sql = "delete from POSTS where ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, number);

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
}
	



