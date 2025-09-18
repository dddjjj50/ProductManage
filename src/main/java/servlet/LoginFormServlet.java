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
 * ユーザー認証を行うサーブレット
 */
@WebServlet("/LoginFormServlet")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	

	/**
	 * POSTリクエストを処理し、ユーザー認証を行う
	 */
	
	//認証情報。今回は正解のIDとパスはここで指定
	private static final String VALID_ID = "aaaa";
	private static final String VALID_PASS = "bbbb";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//リクエストパラメーターのエンコーディングを指定
		request.setCharacterEncoding("UTF-8");
		
		//入力フォームで入力された値
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//認証処理
		if(id.equals(VALID_ID) && pass.equals(VALID_PASS)) {
			//セッションにユーザー名を保存
			HttpSession session = request.getSession();
			session.setAttribute("user", id);
			
			//認証成功時の転送先
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
			dispatcher.forward(request, response);
			return;
		}else {
			//認証失敗時
			request.setAttribute("alert", "IDかパスワード、もしくは両方とも間違っています！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login_form.jsp");
			dispatcher.forward(request, response);
		}
	}
}
