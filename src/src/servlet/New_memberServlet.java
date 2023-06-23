package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import model.Users;

/**
 * Servlet implementation class New_memberServlet
 */
@WebServlet("/New_memberServlet")
public class New_memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 新規会員登録画面へフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/new_member.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String mail_address= request.getParameter("MAIL_ADDRESS");
		String password = request.getParameter("PASSWORD");

		// 新規登録処理を行う
		UsersDao sDao = new UsersDao();

		if (sDao.insert(new Users(id, mail_address, password))) {
			// 登録できていればログインサーブレットにリダイレクトする
			request.setAttribute("result", sDao);
			response.sendRedirect("/buster_moon/LoginServlet");
		}
		else {
			System.out.println("不正処理");
		}
	}
}

