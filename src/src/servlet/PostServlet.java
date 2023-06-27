package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.PostsDao;
import model.Posts;
import model.Restaurants;
import model.Result;


/**
 * Servlet implementation class PostServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\img") // アップロードファイルの一時的な保存先
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 投稿画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/buster_moon/LoginServlet");
//			return;
//		}




		String id= request.getParameter("id");
		System.out.println(id);
		//session
		HttpSession session = request.getSession();
//			String users_id=((Users)session.getAttribute("id")).getId();

		String users_id= request.getParameter("users_id");
		System.out.println(users_id);

		String date= request.getParameter("date");
		System.out.println(date);

//		String photo=request.getParameter("photo");
//		System.out.println(photo);

//		String restaurant= request.getParameter("restaurant");
//		System.out.println(restaurant);

//		String genre= request.getParameter("genre");
//		System.out.println(genre);

		String point;
		if(request.getParameter("point")!=null)
		{
			point= request.getParameter("point");
		}
		else
		{
			point=null;
		}
		System.out.println(point);

		String walk;
		if(request.getParameter("walk")!=null)
		{
			walk= request.getParameter("walk");
		}
		else
		{
			walk=null;
		}
		System.out.println(walk);

		String serve;
		if(request.getParameter("serve")!=null)
		{
			serve= request.getParameter("serve");
		}
		else
		{
			serve=null;
		}
		System.out.println(serve);

		String price;
		if(request.getParameter("price")!=null)
		{
			price= request.getParameter("price");
		}
		else
		{
			price=null;
		}
		System.out.println(price);

//		String text= request.getParameter("text");
//		System.out.println(text);

	    // リクエストパラメータを取得する
	    request.setCharacterEncoding("UTF-8");
		String genre="0";
		int genreVal=0;
		if(request.getParameter("genre")!=""||request.getParameter("genre")!=null)
		{
			genre= request.getParameter("genre");
			request.setAttribute("genre", genre);
			genreVal = Integer.parseInt(genre);
		}

//		String posts_restaurant = request.getParameter("POSTS_RESTAURANT");;

		;

		// 検索処理を行う
		PostsDao PDao = new PostsDao();
		//List<Restaurants> restaurantList = ResDao.select(restaurant, 0, 0, 0, 0);

		// 検索結果をリクエストスコープに格納する
		//request.setAttribute("restaurantList", restaurantList);


		//doGet(request, response);

		String str_tmp = request.getParameter("button");	//リクエストパラメータから取得
		byte[] bytes = str_tmp.getBytes("iso-8859-1");		//文字化けしたデータをbyte型に変換
		String button = new String(bytes, "UTF-8");			//UTF-8の文字コードで、String型のインスタンスを生成
		System.out.println(button);

		String restaurant;
		if(request.getParameter("restaurant")!=null)
		{
			String str_tmp_restaurant = request.getParameter("restaurant");	//リクエストパラメータから取得
			byte[] bytes_restaurant = str_tmp_restaurant.getBytes("iso-8859-1");		//文字化けしたデータをbyte型に変換
			restaurant = new String(bytes_restaurant, "UTF-8");			//UTF-8の文字コードで、String型のインスタンスを生成
			System.out.println(restaurant);
		}
		else
		{
			restaurant="店名未入力";
		}

		String text;
		if(request.getParameter("text")!=null)
		{
			String str_tmp_text = request.getParameter("text");	//リクエストパラメータから取得
			byte[] bytes_text = str_tmp_text.getBytes("iso-8859-1");		//文字化けしたデータをbyte型に変換
			text = new String(bytes_text, "UTF-8");			//UTF-8の文字コードで、String型のインスタンスを生成
			System.out.println(text);
		}
		else
		{
			text=null;
		}



		if(button.equals("店舗検索"))
		{
			List<Restaurants> shiborikomiList = PDao.selectGenre(genreVal);
			request.setAttribute("shiborikomiList", shiborikomiList);
			doGet(request, response);
			//response.sendRedirect("/WEB-INF/jsp/post.jsp");
		}

		// フォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
//		dispatcher.forward(request, response);


		if(button.equals("投稿"))
		{

			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");

			String photo;
			if(request.getParameter("photo")!=null)
			{
				Part part = request.getPart("photo"); // getPartで取得

				photo = this.getFileName(part);
				request.setAttribute("photo", photo);
				// サーバの指定のファイルパスへファイルを保存
		        //場所はクラス名↑の上に指定してある
				part.write(photo);
				System.out.println(photo);
			}
			else
			{
				photo=null;
			}

			//得点画像保持
			String str_tmp_bonus = request.getParameter("bonus");	//リクエストパラメータから取得
			byte[] bytes_bonus = str_tmp_bonus.getBytes("iso-8859-1");		//文字化けしたデータをbyte型に変換
			String bonus = new String(bytes_bonus, "UTF-8");//UTF-8の文字コードで、String型のインスタンスを生成
			request.setAttribute("bonus",bonus);
			//得点音声保持
			String str_tmp_bonus2 = request.getParameter("bonus2");	//リクエストパラメータから取得
			byte[] bytes_bonus2 = str_tmp_bonus2.getBytes("iso-8859-1");		//文字化けしたデータをbyte型に変換
			String bonus2 = new String(bytes_bonus2, "UTF-8");//UTF-8の文字コードで、String型のインスタンスを生成
			request.setAttribute("bonus2",bonus2);

			// 投稿処理を行う
			PostsDao PosDao = new PostsDao();

			if (PosDao.insert(new Posts(id, users_id, date, photo,
					restaurant, walk, serve, price, genre,  text, point))) {	// 投稿成功

				request.setAttribute("result", new Result("投稿成功！", "投稿が完了しました。", "/buster_moon/Time_lineServlet"));
			}
			else {												// 投稿失敗
				request.setAttribute("result", new Result("投稿失敗！", "投稿することが出来ませんでした。",  "/buster_moon/Time_lineServlet"));
			}


			// タイムラインページにリダイレクトする
			doGet(request, response);
		}

		if(button.equals("x"))
		{
			// タイムラインページにリダイレクトする
			response.sendRedirect("/buster_moon/Time_lineServlet");
		}
	}

	//メソッドの作成
//	private String changeParameter(String tmp) {
//		//文字化けしたデータをbyte型に変換
//
//		//UTF-8の文字コードで、String型のインスタンスを生成
//
//		//変換した結果を返す
//		return "";
//	}

	//ファイルの名前を取得してくる
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }		// TODO 自動生成されたメソッド・スタブ
		return name;
	}

}


