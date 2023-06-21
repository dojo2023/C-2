package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostsDao;
import model.Posts;
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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/buster_moon/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id= request.getParameter("ID");
		String users_id= request.getParameter("USERS_ID");
		String date= request.getParameter("DATE");
		String photo= request.getParameter("PHOTO");
		String restaurant= request.getParameter("RESTAURANT");
		String walk= request.getParameter("WALK");
		String serve= request.getParameter("SERVE");
		String price= request.getParameter("PRICE");
		String genre= request.getParameter("GENRE");
		String text= request.getParameter("TEXT");
		String point= request.getParameter("POINT");



//		// 投稿処理を行う
		PostsDao PosDao = new PostsDao();
		if (PosDao.insert(new Posts(id, users_id, date, photo,
				restaurant, walk, serve, price, genre,  text, point))) {	// 投稿成功

			request.setAttribute("time_line", new Result("投稿成功！", "投稿が完了しました。", "/buster_moon/Time_lineServlet"));
		}
		else {												// 投稿失敗
			request.setAttribute("result", new Result("投稿失敗！", "投稿することが出来ませんでした。",  "/buster_moon/Time_lineServlet"));
		}


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/time_line.jsp");
					dispatcher.forward(request, response);
	}
}


