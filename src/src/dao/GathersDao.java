package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Gathers;

public class GathersDao {
	//募集をかける
	//"insert into gathers values (?, ?, ?, ?, ?, ?, ?)"
 	public boolean insert(Gathers gather) { //登録メソッド
 		Connection conn = null;
 		boolean result = false;
 		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

			// SQL文を準備する
			String sql = "insert into GATHERS(ID,USERS_ID,DATE,POINT,RESTAURANT_NAME,TIME,PLACE) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, gather.getId());
			
				pStmt.setString(2, "0001");
			
				pStmt.setString(3, "2002-1-11");
				
				pStmt.setString(4, "100");
			
				pStmt.setString(5, gather.getRestaurant_name());
			
				pStmt.setInt(6, gather.getTime());
		
				pStmt.setInt(7, gather.getPlace());
			
			
			// SQL文を実行し、結果表を取得する
//			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
//			while (rs.next()) {
//			Gathers gathers = new Gathers(
//				rs.getString("ID"),
//				rs.getString("USER_ID"),
//				rs.getString("DATE"),
//				rs.getString("POINT"),
//				rs.getString("RESTAURANT_NAME"),
//				rs.getInt("TIME"),
//				rs.getInt("PLACE")
//				);
//				gatherList.add(gathers);
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
 	//募集項目の表示
 	  public List<Gathers> select1() {
 			Connection conn = null;
 			List<Gathers> gathersList = new ArrayList<Gathers>();

 			try {
 				// JDBCドライバを読み込む
 				Class.forName("org.h2.Driver");

 				// データベースに接続する
 				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

 				// SQL文を準備する
 				String sql = "select*from gathers";
 				PreparedStatement pStmt = conn.prepareStatement(sql);

				 

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Gathers gathers= new Gathers(
				rs.getString("ID"),
				rs.getString("USERS_ID"),
				rs.getString("DATE"),
				rs.getString("POINT"),
				rs.getString("RESTAURANT_NAME"),
				rs.getInt("TIME"),
				rs.getInt("PLACE") 
			);
				gathersList.add(gathers);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			gathersList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			gathersList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					gathersList = null;
				}
			}
		}
			return gathersList;	
 	  }
 	//募集の削除
 		//"delete from gathers where id = ?"
	// 引数idで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(String id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

				// SQL文を準備する
				String sql = "delete from gathers where id = ?";
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
		public List<Gathers> select(Gathers insRec) {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
		public List<Gathers> select() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
}

