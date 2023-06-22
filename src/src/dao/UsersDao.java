package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class UsersDao {
		// ログインできるならtrueを返す
		public Users isLoginOK(Users users) {
			Connection conn = null;
			Users result = null;

			//List<Users> isLoginOK = new ArrayList<Users>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

				// SELECT文を準備する
				String sql = "select id, count(*) from USERS where mail_address = ? and password = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, users.getMail_address());
				pStmt.setString(2, users.getPassword());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// メールアドレスとパスワードが一致するユーザーがいたかどうかをチェックする
				rs.next();
				if (rs.getInt("count(*)") == 1) {
					//リストにIDを追加
					Users session_id = new Users(rs.getString("ID"));
					result = session_id;
				}
				else
				{

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
//		 public List<Users> session_id(String id) {
//				Connection conn = null;
//				List<Users> session_idList = new ArrayList<Users>();
//
//				try {
//					// JDBCドライバを読み込む
//					Class.forName("org.h2.Driver");
//
//					// データベースに接続する
//					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");
//
//					// SQL文を準備する
//					String sql = "select id from users where mail_address = ? and password = ?";
//					PreparedStatement pStmt = conn.prepareStatement(sql);
//
//					// SQL文を完成させる
//					pStmt.setString(1, mail_address);
//					pStmt.setString(2, password);
//
//
//
//					// SQL文を実行し、結果表を取得する
//					ResultSet rs = pStmt.executeQuery();
//
//					// 結果表をコレクションにコピーする
//					while (rs.next()) {
//						Users session_id= new Users(
//						rs.getString("ID")
//						);
//						session_idList.add(session_id);
//					}
//				}
//				catch (SQLException e) {
//					e.printStackTrace();
//					session_idList = null;
//				}
//				catch (ClassNotFoundException e) {
//					e.printStackTrace();
//					session_idList = null;
//				}
//				finally {
//					// データベースを切断
//					if (conn != null) {
//						try {
//							conn.close();
//						}
//						catch (SQLException e) {
//							e.printStackTrace();
//							session_idList = null;
//						}
//					}
//				}
//
//				// 結果を返す
//				return session_idList;
//			}


		//引数usersで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Users users) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");
				// SELECT文を準備する
				String sql ="insert into USERS values (?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				if (users.getId() != null && !users.getId().equals("")) {
					pStmt.setString(1, users.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (users.getMail_address() != null && !users.getMail_address().equals("")) {
					pStmt.setString(2, users.getMail_address());
				}
				else {
					pStmt.setString(2, null);
				}
				if (users.getPassword() != null && !users.getPassword().equals("")) {
					pStmt.setString(3, users.getPassword());
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
}


