package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GathersDao;
import model.Gathers;
import model.Result;
/**
 * Servlet implementation class GatherServlet
 */
@WebServlet("/GatherServlet")
public class GatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				/*HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/buster_moon/LoginServlet");
					return;
				}*/

		// 募集JSPにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gather.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	    //リクエストパラメータを取得する。
		request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("ID");
			System.out.println(id);
			String user_id = request.getParameter("USER_ID");
			System.out.println(user_id);
			String date = request.getParameter("DATE");
			System.out.println(date);
			String point = request.getParameter("POINT");
			System.out.println(point);
		//登録処理を行う
		GathersDao gatherDao = new GathersDao();
			if (request.getParameter("SUBMIT").equals("送信")) {
				if (gatherDao.insert(new Gathers(id, user_id, date, point ))) {	// 登録成功
					request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/buster_moon/GatherServlet"));
			}
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/buster_moon/GatherServlet"));
		}
		//削除処理を行う
			GathersDao gatheDao = new GathersDao();
			if (request.getParameter("SUBMIT").equals("削除")) {
				if (gatheDao.insert(new Gathers(id, user_id, date, point ))) {	// 登録成功
					request.setAttribute("result",
					new Result("削除成功！", "レコードを登録しました。", "/buster_moon/GatherServlet"));
			}
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/buster_moon/GatherServlet"));
		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gather.jsp");
		dispatcher.forward(request, response);
	}
	}
