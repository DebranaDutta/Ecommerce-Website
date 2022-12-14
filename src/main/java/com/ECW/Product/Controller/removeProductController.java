package com.ECW.Product.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.helper.CrudOperationsUsingHibernate;

@WebServlet(name = "removeProductController", urlPatterns = { "/removeProductController" })
public class removeProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public removeProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("productId");
		CrudOperationsUsingHibernate.removeProducts(productId);
	}
}
