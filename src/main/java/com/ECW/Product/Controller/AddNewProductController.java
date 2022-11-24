package com.ECW.Product.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.Model.Product;
import com.ECW.helper.CrudOperationsUsingHibernate;
import com.ECW.helper.RandomIdGenerator;

@WebServlet(name = "AddNewProductController", urlPatterns = { "/AddNewProductController" })
public class AddNewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		String productCategory = request.getParameter("productCategory");
		String available = request.getParameter("available");
		PrintWriter out = response.getWriter();
		Product product = new Product(RandomIdGenerator.newIdGenrator(), productName, productPrice, productCategory, available, new Date());
		System.out.println(product);

		boolean status = CrudOperationsUsingHibernate.addNewProduct(product);
		if (status == true) {
			out.print("success");
		} else {
			out.print("error");
		}

	}
}
