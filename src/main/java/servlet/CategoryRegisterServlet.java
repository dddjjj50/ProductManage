package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.CategoryBean;

@WebServlet("/CategoryRegisterServlet")
public class CategoryRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryRegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/category-register.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//★入力した値に問題あればアラート出す。
		//まずフォームに入力した値を受け取る
		String inputId = request.getParameter("id");
		String inputCategoryName = request.getParameter("categoryName");
		//アラートをリスト化
		List<String> alert = new ArrayList<>();

		try {
			// DAOをインスタンス化
			CategoryDAO dao = new CategoryDAO();
			List<CategoryBean> existingCategories = dao.allCategories();
			int id = 0;
			//まずIDのチェック
			if (inputId == null || inputId.isEmpty()) {
		        alert.add("IDは必須です");
		    } else if (!inputId.matches("^[0-9]+$")) {
		        alert.add("IDは半角数字で入力してください");
		    } else {
		    	id = Integer.parseInt(inputId);
		        for (CategoryBean bean : existingCategories) {
		            if (bean.getId() == id) {
		                alert.add("このIDは既に登録済です");
		                break;
		            }
		        }
		    }

			//次にカテゴリ名のチェック
			if (inputCategoryName == null || inputCategoryName.isEmpty()) {
			    alert.add("カテゴリ名は必須です");
			} else {
			    for (CategoryBean bean : existingCategories) {
			        if (bean.getCategoryName().equals(inputCategoryName)) {
			            alert.add("このカテゴリ名は既に登録済です");
			            break;
			        }
			    }
			}

			if (!alert.isEmpty()) {
			    request.setAttribute("alert", alert);
			    RequestDispatcher rd = request.getRequestDispatcher("/category-register.jsp");
			    rd.forward(request, response);
			    return;
			}
			String categoryName = inputCategoryName;
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
		    request.setAttribute("alert", alert);
		    RequestDispatcher rd = request.getRequestDispatcher("/category-register.jsp");
		    rd.forward(request, response);

		}

	}
}
