package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostsDao;
import model.Posts;
import model.Restaurants;
import model.Result;


/**
 * Servlet implementation class PostServlet
 */
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

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id= request.getParameter("id");
			System.out.println(id);
			//session
		String users_id= request.getParameter("users_id");
			System.out.println(users_id);
			//本日の日付
//

		String date= request.getParameter("date");
			System.out.println(date);
		String photo=request.getParameter("photo");
			System.out.println(photo);
		String restaurant= request.getParameter("restaurant");
			System.out.println(restaurant);
//		String genre= request.getParameter("genre");
//		System.out.println(genre);
		String point= request.getParameter("point");
		System.out.println(point);

		String walk= request.getParameter("walk");
			System.out.println(walk);
		String serve= request.getParameter("serve");
			System.out.println(serve);
		String price= request.getParameter("price");
			System.out.println(price);
		String text= request.getParameter("text");
			System.out.println(text);

	    // リクエストパラメータを取得する
	    request.setCharacterEncoding("UTF-8");
//		String posts_restaurant = request.getParameter("POSTS_RESTAURANT");
		String genre = request.getParameter("genre");
		request.setAttribute("genre", genre);
		int genreVal = Integer.parseInt(genre);
		// 検索処理を行う
		PostsDao PDao = new PostsDao();
		//List<Restaurants> restaurantList = ResDao.select(restaurant, 0, 0, 0, 0);

		// 検索結果をリクエストスコープに格納する
		//request.setAttribute("restaurantList", restaurantList);


		//doGet(request, response);

		if(request.getParameter("button").equals("店舗検索"))
		{
			List<Restaurants> shiborikomiList = PDao.selectGenre(genreVal);
			request.setAttribute("shiborikomiList", shiborikomiList);
			doGet(request, response);
			//response.sendRedirect("/WEB-INF/jsp/post.jsp");
		}

		// フォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
//		dispatcher.forward(request, response);


		if(request.getParameter("button").equals("投稿"))
		{
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
			response.sendRedirect("/buster_moon/Time_lineServlet");
		}
	}
}


