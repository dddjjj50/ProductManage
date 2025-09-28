package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;
import model.entity.ProductBean;

@WebServlet("/DeleteProduct1Servlet")
public class DeleteProduct1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProduct1Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//商品IDを取得
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		try {
			//daoから商品情報を取得
			ProductDAO dao = new ProductDAO();
			ProductBean product = dao.ProductInfoById(id);
			//商品情報をリクエストスコープにセット
			request.setAttribute("product", product);
			//削除確認画面にフォワード
			request.getRequestDispatcher("/WEB-INF/deleteProduct.jsp").forward(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
