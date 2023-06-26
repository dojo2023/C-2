package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import model.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String mail_address= request.getParameter("MAIL_ADDRESS");
		String password = request.getParameter("PASSWORD");

		// ログイン処理を行う
		UsersDao iDao = new UsersDao();

//		Users users = iDao.isLoginOK();
//		if (users == null) {}
		if (iDao.isLoginOK(new Users(mail_address, password)) == null) {	// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			doGet(request, response);
//			request.setAttribute("result",
//			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/buster_moon/LoginServlet"));
		}
		else {									// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", iDao.isLoginOK(new Users(mail_address, password)));

			// タイムラインサーブレットにリダイレクトする
			response.sendRedirect("/buster_moon/My_profileServlet");
			}
	}

}
