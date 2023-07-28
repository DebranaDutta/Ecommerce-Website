package com.ECW.Product.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ECW.Model.Product;
import com.ECW.Product.Dao.ProductDaoHibernate;
import com.ECW.helper.fileInputOutput;

@WebServlet(name = "updateProductDetailsController", urlPatterns = "/updateProductDetailsController")
@MultipartConfig
public class updateProductDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateProductDetailsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		String productCategory = request.getParameter("productCategory");
		String available = request.getParameter("available");
		String oldProductPic = request.getParameter("oldProductPic");

		Part part = request.getPart("productPic");
		String newProductPic = part.getSubmittedFileName();

		if (newProductPic != "") {
			InputStream inputStream = part.getInputStream();

			String oldAdminPath = request.getRealPath("/") + "Admin" + File.separator + "img" + File.separator + oldProductPic;
			fileInputOutput.deleteFile(oldAdminPath);
			String oldUserPath = request.getRealPath("/") + "User" + File.separator + "img" + File.separator + oldProductPic;
			fileInputOutput.deleteFile(oldUserPath);

			String newAdminPath = request.getRealPath("/") + "Admin" + File.separator + "img" + File.separator + newProductPic;
			fileInputOutput.saveFile(inputStream, newAdminPath);

			String newUserPath = request.getRealPath("/") + "User" + File.separator + "img" + File.separator + newProductPic;
			fileInputOutput.fileCopy(newAdminPath, newUserPath);

			ProductDaoHibernate.updateProdcutDetails(productId, productName, productPrice, productCategory, available, newProductPic);

		} else if (newProductPic == "") {
			ProductDaoHibernate.updateProdcutDetails(productId, productName, productPrice, productCategory, available, oldProductPic);
		}

		PrintWriter out = response.getWriter();
		out.print("success");
	}
}
