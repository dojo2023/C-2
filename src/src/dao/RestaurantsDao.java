package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Posts;
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
				String sql = "SELECT RESTAURANT, AVG( CAST(WALK AS DOUBLE) ), AVG(CAST(SERVE AS DOUBLE)), AVG(PRICE), "
						+ "GENRE FROM POSTS WHERE RESTAURANT = ? GROUP BY RESTAURANT, GENRE ";
				PreparedStatement pStmt = conn.prepareStatement(sql); //検索メソッド

				// SQL文を完成させる
					pStmt.setString(1, "%" + param.getRestaurant() + "%");


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Restaurants retaurant = new Restaurants(
					rs.getString("RESTAURANT"),
					rs.getString("WALK"),
					rs.getString("SERVE"),
					rs.getString("PRICE"),
					rs.getString("GENRE")
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
		 public List<Posts> select(Posts detail) {
				Connection conn = null;
				List<Posts> shousaiList = new ArrayList<Posts>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

					// SQL文を準備する
					String sql = "select restaurant, photo, text from posts where restaurant = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, "%" + detail.getRestaurant() + "%");



					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Posts shousai= new Posts(
						rs.getString("RESTAURANT"),
						rs.getString("PHOTO"),
						rs.getString("TEXT")
						);
						shousaiList.add(shousai);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					shousaiList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					shousaiList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							shousaiList = null;
						}
					}
				}

				// 結果を返す
				return shousaiList;
			}

}
