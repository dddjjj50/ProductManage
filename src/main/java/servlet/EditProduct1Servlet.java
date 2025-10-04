package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.ProductDAO;
import model.entity.CategoryBean;
import model.entity.ProductBean;

@WebServlet("/EditProduct1Servlet")
public class EditProduct1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProduct1Servlet() {
		super();
	}

	//editProduct.jspのカテゴリのプルダウン
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<CategoryBean> categoryList = new CategoryDAO().allCategories();

			request.setAttribute("categoryList", categoryList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editProduct.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		try {
			//productList2.jspで編集ボタンを押したIDを取得
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
		
			//商品情報を取得
			ProductDAO dao = new ProductDAO();
			ProductBean bean = dao.ProductInfoById_edit(id);
			
			List<CategoryBean> categoryList = new CategoryDAO().allCategories();
			
			//リクエストにセット
			request.setAttribute("product", bean);
			request.setAttribute("categoryList", categoryList);
		
			//editProduct.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editProduct.jsp");
			dispatcher.forward(request, response);
		
		
		}catch(SQLException | ClassNotFoundException e) { 
			e.printStackTrace();
			request.setAttribute("product", null);
		
			//商品情報が取得できなかったとき
			if(e.getMessage().contains("商品情報を取得できませんでした")) {
				request.setAttribute("errorMsg", "商品情報を取得できませんでした。");
			}else {
				request.setAttribute("errorMsg", "DB接続に失敗しました。");
			}
		
			//編集確認画面に戻す。
			request.getRequestDispatcher("/WEB-INF/editProduct.jsp").forward(request, response);
		}
	}

}
