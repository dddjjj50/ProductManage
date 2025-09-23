package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;
import model.entity.ProductBean;

@WebServlet("/ProductsList2Servlet")
public class ProductsList2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductsList2Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//カテゴリIDを取得
			String categoryIdStr = request.getParameter("choiceCategory"); 
			int categoryId = Integer.parseInt(categoryIdStr);
			
			//DAOで商品一覧を取得
			ProductDAO dao = new ProductDAO();
			List<ProductBean> productList;
			
			//カテゴリ選択の切り分け
			if(categoryId == 0) {
				productList = dao.choiceAllCategories();
			}else{
				productList = dao.choiceCategories(categoryId);
			}
			
			//リクエストにセット
			request.setAttribute("productList", productList);
			
			//JSPにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/productsList2.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "商品一覧の取得に失敗しました");
		}
		
	}

}
