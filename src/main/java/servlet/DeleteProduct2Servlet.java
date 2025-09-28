package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;

@WebServlet("/DeleteProduct2Servlet")
public class DeleteProduct2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProduct2Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//商品IDを取得
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);

		try {
			//daoから商品情報を取得
			ProductDAO dao = new ProductDAO();
			dao.deleteProduct(id);
			//削除後、商品一覧ページに遷移。？全てのカテゴリ
			response.sendRedirect("ProductsList2Servlet?choiceCategory=0");

		} catch(SQLException | ClassNotFoundException e) { 
			e.printStackTrace();
			request.setAttribute("product", null);
			
			//商品情報が取得できなかったとき
			if(e.getMessage().contains("商品情報を取得できませんでした")) {
				request.setAttribute("errorMsg", "商品情報を取得できませんでした。");
			}else {
				request.setAttribute("errorMsg", "DB接続に失敗しました。");
			}
			
			//削除確認画面に戻す。
			request.getRequestDispatcher("/WEB-INF/deleteProduct.jsp").forward(request, response);

		}

	}

}