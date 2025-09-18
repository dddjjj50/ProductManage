package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Postリクエストを処理し、ログアウト成果を表示する
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//セッションからユーザー名を取得し、セッションを無効化
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		request.setAttribute("alert", "ログアウトしました。在庫管理を行う場合は再度ログインしてください。");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login_form.jsp");
		dispatcher.forward(request, response);
		
	}
}
