package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;
import model.entity.ProductBean;

/**
 * Servlet implementation class EditProduct2Servlet
 */
@WebServlet("/EditProduct2Servlet")
public class EditProduct2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProduct2Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		try {
			
			//商品情報を格納するBeanを作成
			ProductBean bean = new ProductBean();
			
			//編集する商品のidを引き続き保持する。
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			bean.setId(id);
			
			//フォームから値を受けとってBeanにセット
			String name = request.getParameter("name");
			if(name != null && !name.isEmpty()) {
				bean.setProductName(name);
			}
			
			String priceStr = request.getParameter("price");
			if(priceStr != null && !priceStr.isEmpty()) {
				int price = Integer.parseInt(priceStr);
				bean.setPrice(price);
			}
			
			String stockStr = request.getParameter("stock");
			if(stockStr != null && !stockStr.isEmpty()) {
				int stock = Integer.parseInt(stockStr);
				bean.setStock(stock);
			}
			
			String categoriIdStr = request.getParameter("categoryId");
			if(categoriIdStr != null && !categoriIdStr.isEmpty()) {
				int categoryId = Integer.parseInt(categoriIdStr);
				bean.setCategoryId(categoryId);
			}
			
			//DAO呼び出し
			ProductDAO dao = new ProductDAO();
			dao.EditProduct(bean);
			
			//編集できたら商品一覧へ
			request.getRequestDispatcher("/ProductsList2Servlet").forward(request,response);
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("product", null);
			
			//商品情報が取得できなかったとき
			if(e.getMessage().contains("商品情報を取得できませんでした")) {
				request.setAttribute("errorMsg", "商品情報を取得できませんでした。");
			}else {
				request.setAttribute("errorMsg", "DB接続に失敗しました。");
			}
			
			//削除確認画面に戻す。
			request.getRequestDispatcher("/WEB-INF/editProduct.jsp").forward(request, response);
		}
	}

}
