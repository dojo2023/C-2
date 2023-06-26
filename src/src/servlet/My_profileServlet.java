package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostsDao;
import dao.ProfilesDao;
import model.Posts;
import model.Profiles;
import model.Users;

/**
 * Servlet implementation class My_profileServlet
 */
@WebServlet("/My_profileServlet")
public class My_profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String users_id = "";
		if(session.getAttribute("id") != null) {
			users_id=((Users)session.getAttribute("id")).getId();
		}


		// 検索処理を行う
	    ProfilesDao profilesDao = new ProfilesDao();
	    List<Profiles> profilesList = profilesDao.select(users_id);

	    PostsDao postsDao = new PostsDao();
	    List<Posts> postspList = postsDao.select(users_id);

	    // 検索結果をリクエストスコープに格納する
	    request.setAttribute("profilesList", profilesList);
	    request.setAttribute("postsList", postspList);
	    request.setAttribute("users_id", users_id);
	    System.out.println(users_id);

	    // 自分のプロフィール画面にフォワードする。
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/my_profile.jsp");
	    dispatcher.forward(request, response);
	}
}
