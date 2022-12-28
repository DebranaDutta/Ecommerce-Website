package com.ECW.Product.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.Dao.CategoryDao;
import com.ECW.Dao.ProductDao;
import com.ECW.Model.Product;
import com.ECW.helper.ConnectionProvider;
import com.google.gson.Gson;

@WebServlet(name = "getProductsByCategoryController", urlPatterns = { "/getProductsByCategoryController" })
public class getProductsByCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getProductsByCategoryController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int catId = Integer.parseInt(request.getParameter("catId"));
		CategoryDao categoryDao = new CategoryDao(ConnectionProvider.getConnection());
		String categoryName = categoryDao.getCategoryNameByCategoryID(catId);

		ProductDao productDao = new ProductDao(ConnectionProvider.getConnection());
		List<Product> products = productDao.getProductsByCategoryName(categoryName);

		Gson gson = new Gson();
		
		HttpSession session=request.getSession();
		session.setAttribute("productsByCategory", products);
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(products));
	}

}
