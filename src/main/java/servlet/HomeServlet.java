package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//セッションチェック
		HttpSession session = request.getSession(false); //falseで新規作成しない
		
		//セッションが切れた場合はログインフォームへ
		if(session == null || session.getAttribute("user") == null) {
			request.setAttribute("alert", "セッションが切れました。在庫管理をする場合はログインしてください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login_form.jsp");
			dispatcher.forward(request,response);
			return;
		}
		
		//ログイン済（セッション有り）ならhome.jspに飛ぶ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
