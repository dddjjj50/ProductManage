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
 * Servlet implementation class CategoryListServlet
 */
@WebServlet("/CategoryListServlet")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryListServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			//daoからカテゴリ一覧を取得
			List<CategoryBean> categoriesList = new CategoryDAO().allCategories();

			//リクエストスコープにセット
			request.setAttribute("categoriesList", categoriesList);

			//JSPに転送
			RequestDispatcher rd = request.getRequestDispatcher("/category-list.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			System.err.println("カテゴリ一覧取得中に例外発生: " + e.getMessage());
		    e.printStackTrace();

		}

	}

}
