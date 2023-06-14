package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Posts;

public class PostsDao {
  public boolean insert(Posts posts) {
	  Connection conn = null;
	  boolean result = false;

	  try {
		  // JDBCドライバを読み込む
		  Class.forName("org.h2.Driver");

		  //データベースに接続する
		  conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/monoshiriplus", "sa", "");

		  //SQL文を準備する
		  String sql = "insert into posts values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		  PreparedStatement pStmt = conn.prepareStatement(sql);

		  //SQL文を完成させる
		  if (card.getId() != null || !card.getId().equals("")) {
			  pStmt.setString(1, card.getId());
		  }
		  else {
			  pStmt.setString(1, null);
		  }
		  if (card.getUsers_id() != null || !card.getUsers_id().equals("")) {
			  pStmt.setString(2, card.getUsers_id());
		  }
		  else {
			  pStmt.setString(2, null);
		  }
		  if (card.getDate() != null || !card.getDate().equals("")) {
			  pStmt.setString(3, card.getDate());
		  }
		  else {
			  pStmt.setString(3, null);
		  }
		  if (card.getPhoto() != null || !card.getDate().equals("")) {
			  pStmt.setString(4, card.getPhoto());
		  }
		  else {
			  pStmt.setString(4, null);
		  }
		  if (card.getRestaurant() != null || !card.getDate().equals("")) {
			  pStmt.setString(5, card.getRestaurant());
		  }
		  else {
			  pStmt.setString(5, null);
		  }
		  if (card.getWalk() != null || !card.getWalk().equals("")) {
			  pStmt.setString(6, card.getWalk());
		  }
		  else {
			  pStmt.setString(6, null);
		  }
		  if (card.getSereve() != null || !card.getSereve().equals("")) {
			  pStmt.setString(7, card.getSereve());
		  }
		  else {
			  pStmt.setString(7, null);
		  }
		  if (card.getPrice() != null || !card.getPrice().equals("")) {
			  pStmt.setString(8, card.getPrice());
		  }
		  else {
			  pStmt.setString(8, null);
		  }
		  if (card.getGenre() != null || !card.getGenre().equals("")) {
			  pStmt.setString(9, card.getGenre());
		  }
		  else {
			  pStmt.setString(9, null);
		  }
		  if (card.getText() != null || !card.getText().equals("")) {
			  pStmt.setString(10, card.getText());
		  }
		  else {
			  pStmt.setString(10, null);
		  }
		  if (card.getPoint() != null || !card.getPoint().equals("")) {
			  pStmt.setString(11, card.getPoint());
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
	//"insert into posts values (?,?,?,?,?,?,?,?,?)"

}
