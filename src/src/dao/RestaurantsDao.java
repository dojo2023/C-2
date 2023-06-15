package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Restaurants;

public class RestaurantsDao {

	//検索
	//"select * from restaurants WHERE posts_restaurant like '%?%'and walk = ? and  serve = ? and price = ? and
	// posts_genre = ? ORDER BY posts_resutaurant"
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Restaurants> select(Restaurants param) {
			Connection conn = null;
			List<Restaurants> restaurantList = new ArrayList<Restaurants>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

				// SQL文を準備する
				String sql = "select * from restaurants WHERE posts_restaurant like '%?%'and walk = ? and  serve = ? "
						+ "and price = ? and posts_genre = ? ORDER BY posts_restaurant";
				PreparedStatement pStmt = conn.prepareStatement(sql); //検索メソッド

				// SQL文を完成させる
				if (param.getPosts_restaurant() != null) {
					pStmt.setString(1, "%" + param.getPosts_restaurant() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getWalk() != null) {
					pStmt.setString(2, "%" + param.getWalk() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getServe() != null) {
					pStmt.setString(3, "%" + param.getServe() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getPrice() != null) {
					pStmt.setString(4, "%" + param.getPrice() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}
				if (param.getPosts_genre() != null) {
					pStmt.setString(5, "%" + param.getPosts_genre() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Restaurants retaurant = new Restaurants(
					rs.getString("POSTS_RESTAURANT"),
					rs.getString("WALK"),
					rs.getString("SERVE"),
					rs.getString("PRICE"),
					rs.getString("POSTS_GENRE")
					);
					restaurantList.add(retaurant);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				restaurantList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				restaurantList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						restaurantList = null;
					}
				}
			}

			// 結果を返す
			return restaurantList;
		}
		//ジャンルで絞り込み検索
		//"select posts_restaurant from posts WHERE genre=?
		// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<Restaurants> select(String param) {
				Connection conn = null;
				List<Restaurants> Posts_restaurantList = new ArrayList<Restaurants>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

					// SQL文を準備する
					String sql = "select posts_restaurant from posts WHERE genre=?";
					PreparedStatement pStmt = conn.prepareStatement(sql); //検索メソッド

					// SQL文を完成させる

						pStmt.setString(1, param);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Restaurants restaurant = new Restaurants(
								rs.getString("POSTS_RESTAURANT"),
								rs.getString("WALK"),
								rs.getString("SERVE"),
								rs.getString("PRICE"),
								rs.getString("POSTS_GENRE")
								);
						Posts_restaurantList.add(restaurant);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					Posts_restaurantList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					Posts_restaurantList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							Posts_restaurantList = null;
						}
					}
				}
				// 結果を返す
				return Posts_restaurantList;
			}
}
