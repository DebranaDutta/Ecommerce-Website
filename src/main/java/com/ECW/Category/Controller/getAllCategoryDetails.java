package com.ECW.Category.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.Category.Dao.CategoryDaoHibernate;
import com.ECW.Category.Dao.CategoryDaoJDBC;
import com.ECW.Model.Category;
import com.ECW.helper.ConnectionProvider;

@WebServlet(name = "getAllCategoryDetails", urlPatterns = { "/getAllCategoryDetails" })
public class getAllCategoryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getAllCategoryDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = CategoryDaoHibernate.getAllCategoryDetails();
		// List<Category> categories=new
		// CategoryDao(ConnectionProvider.getConnection()).getAllCategories();
		HttpSession session = request.getSession();
		session.setAttribute("categories", categories);
		response.sendRedirect("Admin/AddNewProduct.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
