package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Posts;

public class PostsDao {
  public boolean insert(Posts card) {
	  Connection conn = null;
	  boolean result = false;

	  try {
		  // JDBCドライバを読み込む
		  Class.forName("org.h2.Driver");

		  //データベースに接続する
		  conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/monoshiriplus", "sa", "");

		  //SQL文を準備する
		  String sql = "insert into posts values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		  PreparedStatement pStmt = conn.prepareStatement(sql);

		  //SQL文を完成させる
		  if (card.getDate() != null || !card.getDate().equals("")) {
			  pStmt.setString(1, card.getDate());
		  }
		  else {
			  pStmt.setString(1, null);
		  }
		  if (card.getPhoto() != null || !card.getDate().equals("")) {
			  pStmt.setString(2, card.getPhoto());
		  }
		  else {
			  pStmt.setString(2, null);
		  }
		  if (card.getRestaurant() != null || !card.getDate().equals("")) {
			  pStmt.setString(3, card.getRestaurant());
		  }
		  else {
			  pStmt.setString(3, null);
		  }
		  if (card.getWalk() != null || !card.getWalk().equals("")) {
			  pStmt.setString(4, card.getWalk());
		  }
		  else {
			  pStmt.setString(4, null);
		  }
		  if (card.getServe() != null || !card.getServe().equals("")) {
			  pStmt.setString(5, card.getServe());
		  }
		  else {
			  pStmt.setString(5, null);
		  }
		  if (card.getPrice() != null || !card.getPrice().equals("")) {
			  pStmt.setString(6, card.getPrice());
		  }
		  else {
			  pStmt.setString(6, null);
		  }
		  if (card.getGenre() != null || !card.getGenre().equals("")) {
			  pStmt.setString(7, card.getGenre());
		  }
		  else {
			  pStmt.setString(7, null);
		  }
		  if (card.getText() != null || !card.getText().equals("")) {
			  pStmt.setString(8, card.getText());
		  }
		  else {
			  pStmt.setString(8, null);
		  }
		  if (card.getPoint() != null || !card.getPoint().equals("")) {
			  pStmt.setString(9, card.getPoint());
		  }
		  else {
			  pStmt.setString(9, null);
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
	//"insert into posts values (?,?,?,?,?,?,?,?,?)"

}
