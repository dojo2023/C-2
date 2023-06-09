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
import model.Posts;
import model.Restaurants;


/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
*/
    public RestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 店舗詳細ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/restaurant.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		String restaurant = request.getParameter("RESTAURANT");
//		String walkString = request.getParameter("WALK");
//		int walk = Integer.parseInt(walkString);
//		String serveString = request.getParameter("SERVE");
//		int serve = Integer.parseInt(serveString);
//		String priceString = request.getParameter("PRICE");
//		int price = Integer.parseInt(priceString);
//		String genreString = request.getParameter("GENRE");
//		int genre = Integer.parseInt(genreString);
//
//		// 検索処理を行う
//		RestaurantsDao ResDao = new RestaurantsDao();
//		List<Restaurants> restaurantList = ResDao.select(restaurant, walk, serve, price, genre);
//
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("restaurantList", restaurantList);
//
//		// 結果ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/restaurant.jsp");
//		dispatcher.forward(request, response);



		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String restaurant = request.getParameter("RESTAURANT");

		// 検索処理を行う
		RestaurantsDao ResDao = new RestaurantsDao();
		List<Restaurants> restaurantList = ResDao.select(restaurant, 0, 0, 0, 0);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("restaurantList", restaurantList);

		// 検索処理を行う
		RestaurantsDao RessDao = new RestaurantsDao();
		List<Posts> shousaiList = RessDao.text_photo(restaurant);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("shousaiList", shousaiList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/restaurant.jsp");
		dispatcher.forward(request, response);
	}
}



