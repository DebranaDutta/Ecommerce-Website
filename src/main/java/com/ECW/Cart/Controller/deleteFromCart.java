package com.ECW.Cart.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.Cart.Dao.CartDaoJDBC;
import com.ECW.Model.Cart;
import com.ECW.helper.ConnectionProvider;
import com.google.gson.Gson;
import com.mysql.cj.Session;

@WebServlet(name = "deleteFromCart", urlPatterns = { "/deleteFromCart" })
public class deleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteFromCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		long userId = Long.parseLong(request.getParameter("userId"));
		boolean status = new CartDaoJDBC(ConnectionProvider.getConnection()).deletefromCartByCartId(cartId);
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		if (status == true) {
			List<Cart> carts = new CartDaoJDBC(ConnectionProvider.getConnection()).getCartDetailsByUser(userId);
			out.print(gson.toJson(carts));
		}
	}

}
