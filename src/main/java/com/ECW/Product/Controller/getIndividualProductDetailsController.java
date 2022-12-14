package com.ECW.Product.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.Model.Product;
import com.ECW.helper.CrudOperationsUsingHibernate;
import com.google.gson.Gson;

@WebServlet(name = "getIndividualProductDetailsController", urlPatterns = { "/getIndividualProductDetailsController" })
public class getIndividualProductDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getIndividualProductDetailsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		Product product = CrudOperationsUsingHibernate.getIndividualProductDetails(productId);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		//System.out.print(gson.toJson(product));
		out.print(gson.toJson(product));
	}
}
