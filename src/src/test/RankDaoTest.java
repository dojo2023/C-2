package test;
import java.util.List;

import dao.RankDao;
import model.Profiles;




public class RankDaoTest {
	public static void main(String[] args) {

		RankDao rankDao = new RankDao();

		// select()のテスト
		System.out.println("---------- ランクのselect()のテスト ----------");
		List<Profiles> profilesList2 = rankDao.select();
		for(Profiles profiles:profilesList2)
		{
			System.out.println("ユーザID："+profiles.getUsers_id());
			System.out.println("名前："+profiles.getName());
			System.out.println("アイコン："+profiles.getIcon());
			System.out.println("Tポイント："+profiles.getT_point());
			System.out.println("Gポイント："+profiles.getG_point());
			System.out.println("Cポイント："+profiles.getC_point());
		}

//		//日付指定ができているかのテスト
//		Calendar calendar=Calendar.getInstance();
//		int year=calendar.get(Calendar.YEAR);
//        int month=calendar.get(Calendar.MONTH)+1;
//        int year2;
//        int month2;
//
//        if (month == 12) {
//        	year2=calendar.get(Calendar.YEAR)+1;
//        	month2=1;
//        } else {
//        	year2=calendar.get(Calendar.YEAR);
//            month2=calendar.get(Calendar.MONTH)+2;
//        }
//
//        String monthS = String.format("%02d",month);
//        String monthS2 = String.format("%02d",month2);
//        String yearS = String.valueOf(year);
//        String yearS2 = String.valueOf(year2);
//
//        System.out.println(monthS+monthS2+yearS+yearS2);

//        Connection conn = null;
//		List<Profiles> profilesList = new ArrayList<Profiles>();
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/monoshiriplus", "sa", "");
//
//			//ループ開始
//			for (int i = 1; i <= 5; i++)
//			{
//				//コメントポイント
//				// SQL文を準備する
//				String sql = "update profiles "
//						+ "	set c_point=(select SUM(c.point)"
//						+ "	from profiles as p"
//						+ "	join  comments as c on p.users_id = c.users_id"
//						+ "	where c.date>=? and date<?"
//						+ "	group by p.users_id"
//						+ "	having p.users_id=? )"
//						+ "	where users_id=?";
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//
//				// SQL文の日付の指定部分を完成させる
//				Calendar calendar=Calendar.getInstance();
//				int year=calendar.get(Calendar.YEAR);
//	            int month=calendar.get(Calendar.MONTH)+1;
//	            int year2=0;
//	            int month2=0;
//
//	            if (month == 12) {
//	            	year2=calendar.get(Calendar.YEAR)+1;
//	            	month2=1;
//	            } else {
//	            	year2=calendar.get(Calendar.YEAR);
//	                month2=calendar.get(Calendar.MONTH)+2;
//	            }
//
//	            String monthS = String.format("%02d",month);
//	            String monthS2 = String.format("%02d",month2);
//	            String yearS = String.valueOf(year);
//	            String yearS2 = String.valueOf(year2);
//
//				pStmt.setString(1, yearS+"-"+monthS+"-01");
//				pStmt.setString(2, yearS2+"-"+monthS2+"-01");
//
//
//				//ユーザIDを入れていく
//				String x = String.valueOf(i);
//
//					pStmt.setString(3, x);
//					pStmt.setString(4, x);
//
//					//SQL文実行
//
//					pStmt.executeUpdate();
//			}}
//
//			catch (SQLException e) {
//				e.printStackTrace();
//				profilesList = null;
//				System.out.println("SQLのエラー");
//			}
//			catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				profilesList = null;
//				System.out.println("クラス見つからないエラー");
//			}
//			finally {
//				// データベースを切断
//				if (conn != null) {
//					try {
//						conn.close();
//					}
//					catch (SQLException e) {
//						e.printStackTrace();
//						profilesList = null;
//					}
//				}
//			}


	}


}
