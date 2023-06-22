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

import dao.GathersDao;
import model.Gathers;
import model.Users;
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
		request.setCharacterEncoding("UTF-8");
		// select処理を行う
		GathersDao gatherDao = new GathersDao();
		List<Gathers> gathersList = gatherDao.select1();	
		//リクエストスコープに格納する
		request.setAttribute("gathersList", gathersList);
		
		
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/buster_moon/LoginServlet");
					return;
				}

		// 募集JSPにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gather.jsp");
				dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();

		
	    //リクエストパラメータを取得する。
		request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("ID");
			System.out.println(id);
			String users_id = ((Users)session.getAttribute("id")).getId();
		    System.out.println(users_id);
			String date = request.getParameter("DATE");
			System.out.println(date);
		    String point = request.getParameter("POINT");
			System.out.println(point);
			String restaurant_name = request.getParameter("RESTAURANT_NAME");
			System.out.println(restaurant_name);
			String timeString = request.getParameter("TIME");
			int time = Integer.parseInt(timeString);
			System.out.println(time);
			String placeString = request.getParameter("PLACE");
			int place = Integer.parseInt(placeString);
			System.out.println(place);
			//登録処理を行う
			GathersDao gatherDao = new GathersDao();
				if (request.getParameter("SUBMIT").equals("送信")) {
					Gathers gather = new Gathers(id,users_id,date,point,restaurant_name,time,place);
					boolean result = gatherDao.insert(gather);
//					ArrayList<Gathers> gathersList = new ArrayList<Gathers>();
//					gathersList.add(gather);
					List<Gathers> gathersList = gatherDao.select1();	
					//検索結果をリクエストスコープに格納する
					request.setAttribute("gathersList", gathersList);
				
				}

			
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gather.jsp");
			dispatcher.forward(request, response);
			
			
					//登録処理を行う
//		GathersDao gatherDao = new GathersDao();
//			if (request.getParameter("SUBMIT").equals("送信")) {
//				List<Gathers>gathersList=gatherDao.select(restaurant_name,time,place);
//			    }
			
			
		//削除処理を行う
/*		GathersDao gatheDao = new GathersDao();
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
			*/
	
	}
}

