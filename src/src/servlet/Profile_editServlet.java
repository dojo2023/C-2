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
import dao.ProfilesDao;
import model.Posts;
import model.Profiles;
import model.Result;

/**
 * Servlet implementation class Profile_editServlet
 */
@WebServlet("/Profile_editServlet")
public class Profile_editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 検索処理を行う
	    ProfilesDao profilesDao = new ProfilesDao();
	    List<Profiles> profilesList = profilesDao.select(new Profiles("", "", "", "", "", 0, 0, 0));

	    PostsDao postsDao = new PostsDao();
	    List<Posts> postspList = postsDao.select(new Posts("", "", "", "", "", "", "", "", "", "", ""));

	    // 検索結果をリクエストスコープに格納する
	    request.setAttribute("profilesList", profilesList);
	    request.setAttribute("postsList", postspList);

	    // プロフィール編集画面にフォワードする。
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile_edit.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/buster_moon/LoginServlet");
//			return;
//		}

		// リクエストパラメータを取得する
		String name = request.getParameter("name");
		String icon = request.getParameter("icon");
		String introduction = request.getParameter("introduction");
		String users_id = "1";
				//request.getParameter("users_id");

		ProfilesDao bDao = new ProfilesDao();
		if (request.getParameter("completion") != null) {
			if (bDao.update(name, icon, introduction, users_id)) {	// 更新成功
				request.setAttribute("result",
				new Result("更新成功！", "レコードを更新しました。", "/buster_moon/My_profileServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "レコードを更新できませんでした。", "/buster_moon/My_profileServlet"));
			}

			doGet(request,response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/my_profile.jsp");
//	        dispatcher.forward(request, response);
		}
	}
}
