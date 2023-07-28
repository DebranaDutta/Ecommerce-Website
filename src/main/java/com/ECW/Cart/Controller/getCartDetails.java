package com.ECW.Cart.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.Cart.Dao.CartDaoJDBC;
import com.ECW.Model.Cart;
import com.ECW.Model.Product;
import com.ECW.helper.ConnectionProvider;
import com.google.gson.Gson;

@WebServlet(name = "getCartDetails", urlPatterns = "{/getCartDetails}")
public class getCartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getCartDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long userId = Long.parseLong(request.getParameter("userId"));
		CartDaoJDBC cartDao = new CartDaoJDBC(ConnectionProvider.getConnection());
		List<Cart> carts = cartDao.getCartDetailsByUser(userId);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(carts));

		HttpSession session = request.getSession();
		session.setAttribute("carts", carts);
	}

}
