package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.PostsDao;
import dao.ProfilesDao;
import model.Posts;
import model.Profiles;
import model.Result;
import model.Users;

/**
 * Servlet implementation class Profile_editServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\img") // アップロードファイルの一時的な保存先
@WebServlet("/Profile_editServlet")
public class Profile_editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

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

		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータを取得する
		String name = request.getParameter("name");
		String icon = request.getParameter("icon");
		String introduction = request.getParameter("introduction");
		HttpSession session = request.getSession();
		String users_id=((Users)session.getAttribute("id")).getId(); //セッションスコープから
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		Part photoPart = request.getPart("photo"); // getPartで取得

					String photo = this.getFileName(photoPart);
					request.setAttribute("photo", photo);
					// サーバの指定のファイルパスへファイルを保存
			        //場所はクラス名↑の上に指定してある
					photoPart.write(photo);
					System.out.println(photo);


		ProfilesDao bDao = new ProfilesDao();
		if (request.getParameter("SUBMIT").equals("変更を完了する")) {
			if (bDao.update(name, icon, introduction, users_id)&& bDao.updatePassword(users_id, password, newPassword)) {	// 更新成功
				request.setAttribute("result",
				new Result("更新成功！", "レコードを更新しました。", "/buster_moon/My_profileServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "レコードを更新できませんでした。", "/buster_moon/My_profileServlet"));
			}
		}

//		//パスワードの更新
//		else if (request.getParameter("SUBMIT").equals("")) {
//			if (ProfilesDao.updatePassword(users_id, password, newPassword)) {
//                // パスワード変更成功
//                request.setAttribute("result",
//                        new Result("パスワード変更成功！", "パスワードを変更しました。", "/buster_moon/My_profileServlet"));
//            } else {
//                // パスワード変更失敗
//                request.setAttribute("result",
//                        new Result("パスワード変更失敗！", "パスワードを変更できませんでした。", "/buster_moon/My_profileServlet"));
//            }
//        }

		//投稿の削除
		else if (request.getParameter("SUBMIT").equals("削除")){
			if (bDao.delete(id)) {	// 削除成功
				request.setAttribute("result",
				new Result("削除成功！", "レコードを削除しました。", "/buster_moon/My_profileServlet"));
			}
			else {						// 削除失敗
				request.setAttribute("result",
				new Result("削除失敗！", "レコードを削除できませんでした。", "/buster_moon/My_profileServlet"));
			}
		}


			doGet(request,response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/my_profile.jsp");
//	        dispatcher.forward(request, response);
		}

	private String getFileName(Part part) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	}


