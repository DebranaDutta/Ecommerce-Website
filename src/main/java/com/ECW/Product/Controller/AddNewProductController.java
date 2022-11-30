package com.ECW.Product.Controller;

import java.io.File;
import java.io.FileOutputStream;
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
import com.ECW.helper.CrudOperationsUsingHibernate;
import com.ECW.helper.RandomIdGenerator;
import com.ECW.helper.fileInputOutput;

@WebServlet(name = "AddNewProductController", urlPatterns = { "/AddNewProductController" })
@MultipartConfig
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
		Part part = request.getPart("productPic");
		String productPic = part.getSubmittedFileName();
		if (productPic != "") {
			InputStream inputStream = part.getInputStream();
			String path = request.getRealPath("/") + "Admin" + File.separator + "img" + File.separator + productPic;
			fileInputOutput.saveFile(inputStream, path);
		} else {
			productPic = "default.png";
			InputStream inputStream = part.getInputStream();
			String path = request.getRealPath("/") + "Admin" + File.separator + "img" + File.separator + productPic;
			fileInputOutput.saveFile(inputStream, path);
		}
		Product product = new Product(RandomIdGenerator.newIdGenrator(), productName, productPrice, productCategory, available, new Date(), productPic);
		PrintWriter out = response.getWriter();

		boolean status = CrudOperationsUsingHibernate.addNewProduct(product);
		if (status == true) {
			out.print("success");
		} else {
			out.print("error");
		}
		
		/*InputStream inputStream = part.getInputStream();
		byte data[] = new byte[inputStream.available()];
		inputStream.read(data);
		String path = request.getRealPath("/") + "Admin" + File.separator + "img" + File.separator + productPic;
		System.out.println(path);
		FileOutputStream fileOutputStream = new FileOutputStream(path);
		fileOutputStream.write(data);*/
	}
}
