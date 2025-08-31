package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.CategoryBean;

/**
 * Servlet implementation class CategoryRegisterServlet
 */
@WebServlet("/CategoryRegisterServlet")
public class CategoryRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher rd = request.getRequestDispatcher("/category-register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");

		try {
			// DAOをインスタンス化
			CategoryDAO dao = new CategoryDAO();

			// フォームからデータを受け取り、DBに登録
			int id = Integer.parseInt(request.getParameter("id"));
			String categoryName = request.getParameter("categoryName");
			dao.addCategory(id, categoryName);

			// DBに登録後、最新のカテゴリ一覧を取得
			List<CategoryBean> categoriesList = dao.allCategories();

			// 取得したリストをリクエストスコープにセット
			request.setAttribute("categoriesList", categoriesList);

			// カテゴリ一覧ページに転送
			RequestDispatcher rd = request.getRequestDispatcher("/category-list.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/category-list.jsp");
	    rd.forward(request, response);

	}

}
