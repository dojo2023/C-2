package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Posts;

//"insert into posts values (?,?,?,?,?,?,?,?,?)"
public class PostsDao {
  public boolean insert(Posts posts) {
	  Connection conn = null;
	  boolean result = false;

	  try {
		  // JDBCドライバを読み込む
		  Class.forName("org.h2.Driver");

		  //データベースに接続する
		  conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/date/buster_moon", "sa", "");

		  //SQL文を準備する
		  String sql = "insert into posts values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		  PreparedStatement pStmt = conn.prepareStatement(sql);

		  //SQL文を完成させる
		  if (posts.getId() != null || !posts.getId().equals("")) {
			  pStmt.setString(1, posts.getId());
		  }
		  else {
			  pStmt.setString(1, null);
		  }
		  if (posts.getUsers_id() != null || !posts.getUsers_id().equals("")) {
			  pStmt.setString(2, posts.getUsers_id());
		  }
		  else {
			  pStmt.setString(2, null);
		  }
		  if (posts.getDate() != null || !posts.getDate().equals("")) {
			  pStmt.setString(3, posts.getDate());
		  }
		  else {
			  pStmt.setString(3, null);
		  }
		  if (posts.getPhoto() != null || !posts.getDate().equals("")) {
			  pStmt.setString(4, posts.getPhoto());
		  }
		  else {
			  pStmt.setString(4, null);
		  }
		  if (posts.getRestaurant() != null || !posts.getDate().equals("")) {
			  pStmt.setString(5, posts.getRestaurant());
		  }
		  else {
			  pStmt.setString(5, null);
		  }
		  if (posts.getWalk() != null || !posts.getWalk().equals("")) {
			  pStmt.setString(6, posts.getWalk());
		  }
		  else {
			  pStmt.setString(6, null);
		  }
		  if (posts.getSereve() != null || !posts.getSereve().equals("")) {
			  pStmt.setString(7, posts.getSereve());
		  }
		  else {
			  pStmt.setString(7, null);
		  }
		  if (posts.getPrice() != null || !posts.getPrice().equals("")) {
			  pStmt.setString(8, posts.getPrice());
		  }
		  else {
			  pStmt.setString(8, null);
		  }
		  if (posts.getGenre() != null || !posts.getGenre().equals("")) {
			  pStmt.setString(9, posts.getGenre());
		  }
		  else {
			  pStmt.setString(9, null);
		  }
		  if (posts.getText() != null || !posts.getText().equals("")) {
			  pStmt.setString(10, posts.getText());
		  }
		  else {
			  pStmt.setString(10, null);
		  }
		  if (posts.getPoint() != null || !posts.getPoint().equals("")) {
			  pStmt.setString(11, posts.getPoint());
		  }
		  else {
			  pStmt.setString(11, null);
		  }

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

    //"select restaurant, photo, text from posts where restsursnt = '?'"
  public List<Posts> select(Posts param) {
		Connection conn = null;
		List<Posts> postsList = new ArrayList<Posts>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/date/buster_moon", "sa", "");

			// SQL文を準備する
			String sql = "select restaurant, photo, text from posts where restaurant = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getRestaurant() != null) {
				pStmt.setString(1, "%" + param.getRestaurant() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getPhoto() != null) {
				pStmt.setString(2, "%" + param.getPhoto() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getText() != null) {
				pStmt.setString(3, "%" + param.getText() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Bc card = new Bc(
				rs.getString("NUMBER"),
				rs.getString("COMPANY"),
				rs.getString("DEPARTMENT"),
				rs.getString("POSITION"),
				rs.getString("NAME"),
				rs.getString("ZIPCODE"),
				rs.getString("ADDRESS"),
				rs.getString("TEL"),
				rs.getString("FAX"),
				rs.getString("EMAIL"),
				rs.getString("MEMO")

				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}
}
