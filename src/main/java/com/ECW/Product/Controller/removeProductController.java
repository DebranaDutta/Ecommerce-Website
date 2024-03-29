package com.ECW.Product.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.Product.Dao.ProductDaoHibernate;
import com.ECW.helper.fileInputOutput;

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
		String productId = request.getParameter("productId");
		String productPic = request.getParameter("productPic");

		String adminProductPicPath = request.getRealPath("/") + "Admin" + File.separator + "img" + File.separator + productPic;
		fileInputOutput.deleteFile(adminProductPicPath);
		String userProductPicPath = request.getRealPath("/") + "User" + File.separator + "img" + File.separator + productPic;
		fileInputOutput.deleteFile(userProductPicPath);

		ProductDaoHibernate.removeProducts(productId);
	}
}
