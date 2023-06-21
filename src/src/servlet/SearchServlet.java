package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantsDao;
import model.Restaurants;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//検索ページにフォアードする
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/simpleBC/LoginServlet");
//			return;
//		}

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String restaurant = request.getParameter("RESTAURANT");
		String genreString = request.getParameter("GENRE");
		int genre = Integer.parseInt(genreString);
			System.out.println(genre);
		String priceString = request.getParameter("PRICE");
		int price = Integer.parseInt(priceString);
			System.out.println(price);
		String walkString = request.getParameter("WALK");
		int walk = Integer.parseInt(walkString);
			System.out.println(walk);
		String serveString = request.getParameter("SERVE");
		int serve = Integer.parseInt(serveString);
			System.out.println(serve);

		//検索処理を行う
		RestaurantsDao kDao = new RestaurantsDao();
		List<Restaurants> restaurantList = kDao.select(restaurant, genre, price, walk, serve);

		//検索結果をリクエストスコープに格納する
		request.setAttribute("restaurantList", restaurantList);


		//結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);


		//店舗詳細ページにフォワードする
		//RestaurantsDao rDao=new RestaurantsDao();
		if(request.getParameter("SUBMIT").equals("店舗詳細表示"))
		{
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/jsp/restaurant.jsp");
			dispatcher.forward(request, response);
		}

	}

}
