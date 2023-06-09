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
	public List<Profiles> select(String users_id) {
		Connection conn = null;
		List<Profiles> profilesList = new ArrayList<Profiles>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

			// SQL文を準備する
			String sql = "select * from profiles where users_id like ?";
		    PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
		    pStmt.setString(1, users_id);

//			if (param.getUsers_id() != null) {
//				pStmt.setString(1, "%1%"); //セッションスコープからpStmt.setString(1, "%users_id%");
//			}
//			else {
//				pStmt.setString(1, "%");
//			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Profiles profiles = new Profiles();
				profiles.setUsers_id(rs.getString("users_id"));
			    profiles.setName(rs.getString("name"));
			    profiles.setIcon(rs.getString("icon"));
			    profiles.setIntroduction(rs.getString("introduction"));
			    profiles.setT_point(rs.getInt("t_point"));
			    profiles.setG_point(rs.getInt("g_point"));
			    profiles.setC_point(rs.getInt("c_point"));
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
	public boolean update(String name, String icon, String introduction, String users_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

			// SQL文を準備する
			String sql = "update PROFILES set name=? , icon=? , introduction=? where users_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, name);
			pStmt.setString(2, icon);
			pStmt.setString(3, introduction);
			pStmt.setString(4, users_id); // セッションスコープから持ってきたUsers_idを入れる

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
			String sql = "delete from POSTS where id = ?";
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

	// パスワードの更新
    public boolean updatePassword(String users_id, String password, String newPassword) {
        Connection conn = null;
        boolean result = false;

        try {
            // JDBCドライバを読み込む
            Class.forName("org.h2.Driver");

            // データベースに接続する
            conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/buster_moon", "sa", "");

            // SQL文を準備する
            String sql = "UPDATE USERS SET password = ? WHERE id = ? AND password = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // SQL文を完成させる
            pStmt.setString(1, newPassword);
            pStmt.setString(2, users_id);
            pStmt.setString(3, password);

            // SQL文を実行する
            if (pStmt.executeUpdate() == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 結果を返す
        return result;
    }
}




