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
import model.dao.ProductDAO;
import model.dao.SupplierDAO;
import model.entity.CategoryBean;
import model.entity.ProductBean;
import model.entity.SupplierBean;

@WebServlet("/AddProductservlet")
public class AddProductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductservlet() {
        super();
    }
    //フォームの「カテゴリ」「取引会社」のプルダウン表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<CategoryBean> categoryList = new CategoryDAO().allCategories();
			List<SupplierBean> supplierList = new SupplierDAO().allSuppliers();
			
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("supplierList", supplierList);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/addProduct.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			//パラメーター取得
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			int supplierId = Integer.parseInt(request.getParameter("supplierId"));
			
			//beanに登録
			ProductBean product = new ProductBean(0,name,price,stock,categoryId,supplierId);
			new ProductDAO().addProduct(product);
			
			//登録成功メッセージ
			request.setAttribute("message", "商品の登録が成功しましたｄ");
			
			//doGetの呼び出し
			doGet(request,response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "登録失敗…TT");
			doGet(request,response);
		}
		
	}

}
