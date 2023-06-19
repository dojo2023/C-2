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
import dao.RankDao;
import model.Posts;
import model.Profiles;

/**
 * Servlet implementation class Time_lineServlet
 */
@WebServlet("/Time_lineServlet")
public class Time_lineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// タイムライン画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/time_line.jsp");
				dispatcher.forward(request, response);


				// ランキング（並び替え後の）表示処理を行う
				RankDao rankDao = new RankDao();
				List<Profiles> profilesList = rankDao.select();

				// ランキングselectの結果をリクエストスコープに格納する
				request.setAttribute("profilesList", profilesList);

				// 投稿の表示処理を行う
				PostsDao postsDao = new PostsDao();
				List<Posts> postsList = postsDao.select();

				// 投稿をリクエストスコープに格納する
				request.setAttribute("postsList", postsList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
