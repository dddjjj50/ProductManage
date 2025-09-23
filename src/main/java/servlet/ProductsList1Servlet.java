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

@WebServlet("/ProductsList1Servlet")
public class ProductsList1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductsList1Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<CategoryBean> categoryList = new CategoryDAO().allCategories();
			request.setAttribute("categoryList", categoryList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/productsList1.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
