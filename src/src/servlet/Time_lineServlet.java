package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentsDao;
import dao.PostsDao;
import dao.RankDao;
import model.Comments;
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


				request.setCharacterEncoding("UTF-8");

				// ランキング（並び替え後の）select処理を行う
				RankDao rankDao = new RankDao();
				List<Profiles> profilesList = rankDao.select();

				// ランキングselectの結果をリクエストスコープに格納する
				request.setAttribute("profilesList", profilesList);

				//--------------------------------------------------------------------

				// 投稿の表示処理を行う
				PostsDao postsDao = new PostsDao();
				List<Posts> postsList = postsDao.select();

				// 投稿をリクエストスコープに格納する
				request.setAttribute("postsList", postsList);

				// タイムライン画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/time_line.jsp");
				dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODOAuto-generated method stub


		request.setCharacterEncoding("UTF-8");

		String users_id="2";
		String posts_id = request.getParameter("ID");
		String text=request.getParameter("TEXT");

		CommentsDao cDao=new CommentsDao();
		if(request.getParameter("SUBMIT").equals("コメント表示"))
		{
			List<Comments> commentsList = cDao.select(posts_id);
			request.setAttribute("commentsList", commentsList);
			doGet(request,response);
		}

		if(request.getParameter("SUBMIT").equals("送信"))
		{
			Comments comments =new Comments(users_id,posts_id,text);
			cDao.insert(comments);
			doGet(request,response);
		}

	}

}
