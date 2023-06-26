package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Posts;
import model.Restaurants;

//"insert into posts values (?,?,?,?,?,?,?,?,?)"
public class PostsDao{
  public boolean insert(Posts posts) {
	  Connection conn = null;
	  boolean result = false;

	  try {
		  // JDBCドライバを読み込む
		  Class.forName("org.h2.Driver");

		  //データベースに接続する
		  conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

		  //SQL文を準備する
		  String sql = "insert into posts values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		  PreparedStatement pStmt = conn.prepareStatement(sql);

		  //SQL文を完成させる

			  pStmt.setString(1, posts.getId());

			  Calendar calendar=Calendar.getInstance();
			  int year=calendar.get(Calendar.YEAR);
	          int month=calendar.get(Calendar.MONTH)+1;
	          int date =calendar.get(Calendar.DATE);
	          String monthS = String.format("%02d",month);
	          String yearS = String.valueOf(year);
	          String dateS=String.format("%02d", date);

		   if (posts.getUsers_id() != null && !posts.getUsers_id().equals("")) {
			  pStmt.setString(2, posts.getUsers_id());
		   }
		   else {
				  pStmt.setString(2, null);
		   }

			  pStmt.setString(3, yearS+"-"+monthS+"-"+dateS);

		  if (posts.getPhoto() != null && !posts.getPhoto().equals("")) {
			  pStmt.setString(4, posts.getPhoto());
		  }
		  else {
			  pStmt.setString(4, null);
		  }

			  pStmt.setString(5, posts.getRestaurant());

		  if (posts.getWalk() != null && !posts.getWalk().equals("")) {
			  pStmt.setString(6, posts.getWalk());
		  }
		  else {
			  pStmt.setString(6, null);
		  }
		  if (posts.getServe() != null && !posts.getServe().equals("")) {
			  pStmt.setString(7, posts.getServe());
		  }
		  else {
			  pStmt.setString(7, null);
		  }
		  if (posts.getPrice() != null && !posts.getPrice().equals("")) {
			  pStmt.setString(8, posts.getPrice());
		  }
		  else {
			  pStmt.setString(8, null);
		  }

			  pStmt.setString(9, posts.getGenre());

		  if (posts.getText() != null && !posts.getText().equals("")) {
			  pStmt.setString(10, posts.getText());
		  }
		  else {
			  pStmt.setString(10, null);
		  }

			  pStmt.setString(11, posts.getPoint());


		  //SQL文を実行する
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
		  //データベースを切断
		  if (conn != null) {
			  try {
				  conn.close();
			  }
			  catch (SQLException e) {
				  e.printStackTrace();
			  }
		  }
	  }

	  //結果を返す
	  return result;
  }

    //"select restaurant, photo, text from posts where restaursnt = '?'"
  public List<Posts> select() {
		Connection conn = null;
		List<Posts> postsList = new ArrayList<Posts>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

			// SQL文を準備する
			String sql = "select * from posts join profiles on posts.users_id=profiles.users_id order by date desc, id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Posts posts= new Posts(
				rs.getString("ID"),
				rs.getString("USERS_ID"),
				rs.getString("DATE"),
				rs.getString("PHOTO"),
				rs.getString("RESTAURANT"),
				rs.getString("WALK"),
				rs.getString("SERVE"),
				rs.getString("PRICE"),
				rs.getString("GENRE"),
				rs.getString("TEXT"),
				rs.getString("POINT"),
				rs.getString("NAME"),
				rs.getString("ICON")
				);
				postsList.add(posts);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			postsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			postsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					postsList = null;
				}
			}
		}

		// 結果を返す
		return postsList;
	}

  // プロフィール画面に自分の投稿を表示する
  public List<Posts> select(String users_id) {
		Connection conn = null;
		List<Posts> postsList = new ArrayList<Posts>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

			// SQL文を準備する
			String sql = "select * from posts where users_id like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, users_id);

//			// SQL文を完成させる
//				if (Posts.getUsers_id() != null) {
//					pStmt.setString(1, users_id);
//				}
//				else {
//					pStmt.setString(1, "%");
//			      }

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Posts posts= new Posts(
				rs.getString("id"),
				rs.getString("users_id"),
				rs.getString("date"),
				rs.getString("photo"),
				rs.getString("restaurant"),
				rs.getString("walk"),
				rs.getString("serve"),
				rs.getString("price"),
				rs.getString("genre"),
				rs.getString("text"),
				rs.getString("point")
				);
				postsList.add(posts);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			postsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			postsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					postsList = null;
				}
			}
		}

		// 結果を返す
		return postsList;
	}

//投稿する際ジャンルで店舗名を絞り込み
		// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Restaurants> selectGenre(int posts_genre) {
				Connection conn = null;
				List<Restaurants> shiborikomiList = new ArrayList<Restaurants>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

					// SQL文を準備する
					String sql = "select posts_restaurant,walk,serve,price,posts_genre from restaurants WHERE posts_genre=?";
					PreparedStatement pStmt = conn.prepareStatement(sql); //検索メソッド

					// SQL文を完成させる

						pStmt.setInt(1, posts_genre);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Restaurants restaurant = new Restaurants(
								rs.getString("POSTS_RESTAURANT"),
								rs.getInt("WALK"),
								rs.getInt("SERVE"),
								rs.getInt("PRICE"),
								rs.getInt("POSTS_GENRE")
								);
						shiborikomiList.add(restaurant);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					shiborikomiList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					shiborikomiList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							shiborikomiList = null;
						}
					}
				}
				// 結果を返す
				return shiborikomiList;
			}
}


