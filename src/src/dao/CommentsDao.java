package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Comments;

public class CommentsDao{
  public boolean insert(Comments comments) {
	  Connection conn = null;
	  boolean result = false;

	  try {
		  // JDBCドライバを読み込む
		  Class.forName("org.h2.Driver");

		  //データベースに接続する
		  conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

		  //SQL文を準備する
		  String sql = "insert into comments (ID,USERS_ID,POSTS_ID,DATE,POINT,TEXT) values (?, ?, ?, ?, ?, ?)";
		  PreparedStatement pStmt = conn.prepareStatement(sql);

		  //SQL文を完成させる
		  Calendar calendar=Calendar.getInstance();
		  int year=calendar.get(Calendar.YEAR);
          int month=calendar.get(Calendar.MONTH)+1;
          int date =calendar.get(Calendar.DATE);
          String monthS = String.format("%02d",month);
          String yearS = String.valueOf(year);
          String dateS=String.format("%02d", date);

			  pStmt.setString(1, comments.getId());


		  if (comments.getUsers_id() != null || !comments.getUsers_id().equals("")) {
			  pStmt.setString(2, comments.getUsers_id());
		  }
		  else {
			  pStmt.setString(2, null);
		  }
		  if (comments.getPosts_id() != null || !comments.getPosts_id().equals("")) {
			  pStmt.setString(3, comments.getPosts_id());
		  }
		  else {
			  pStmt.setString(3, null);
		  }

		  pStmt.setString(4, yearS+"-"+monthS+"-"+dateS);

		  pStmt.setString(5, "7");

		  if (comments.getText() != null || !comments.getText().equals("")) {
			  pStmt.setString(6, comments.getText());
		  }
		  else {
			  pStmt.setString(6, null);
		  }

		  //SQL文を実行する
		  pStmt.executeUpdate();
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

  public List<Comments> select(String posts_id) {
		Connection conn = null;
		List<Comments> commentsList = new ArrayList<Comments>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

			// SQL文を準備する
			String sql = "select * "
					+ "from comments as c "
					+ "join profiles as p on c.users_id=p.users_id "
					+ "join posts as t on c.posts_id=t.id "
					+ "where c.posts_id=? "
					+ "order by c.date asc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

				  pStmt.setString(1, posts_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Comments comments= new Comments(
				rs.getString("ID"),
				rs.getString("USERS_ID"),
				rs.getString("POSTS_ID"),
				rs.getString("DATE"),
				rs.getString("POINT"),
				rs.getString("TEXT"),
				rs.getString("NAME"),
				rs.getString("ICON")
				);
				commentsList.add(comments);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			commentsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			commentsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					commentsList = null;
				}
			}
		}

		// 結果を返す
		return commentsList;
	}

  public boolean delete(String id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

			// SQL文を準備する
			String sql = "delete from comments where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, id);

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

