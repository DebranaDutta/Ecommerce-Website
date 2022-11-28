package com.ECW.Product.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.Model.Category;
import com.ECW.helper.CrudOperationsUsingHibernate;
@WebServlet(name = "AddNewCategoryController", urlPatterns = {"/AddNewCategoryController"})
public class AddNewCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public AddNewCategoryController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName=request.getParameter("categoryName");
		String categoryDetails=request.getParameter("categoryDetails");
		PrintWriter out=response.getWriter();
		Category category=new Category(new Random().nextInt(1000), categoryName, categoryDetails);
		boolean status= CrudOperationsUsingHibernate.addNewCategory(category);
		if(status==true) {
			out.print("success");
		}else {
			out.print("error");
		}
	}
}
