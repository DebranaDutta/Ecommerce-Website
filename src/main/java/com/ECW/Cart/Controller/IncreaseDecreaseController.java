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

@WebServlet(name = "IncreaseDecreaseController", urlPatterns = { "/IncreaseDecreaseController" })
public class IncreaseDecreaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IncreaseDecreaseController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		long userId = Long.parseLong(request.getParameter("userId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		CartDaoJDBC cartDao = new CartDaoJDBC(ConnectionProvider.getConnection());
		if (quantity == 0) {
			boolean status = cartDao.deletefromCartByCartId(cartId);
			if (status == true) {
				List<Cart> carts = cartDao.getCartDetailsByUser(userId);
				out.print(gson.toJson(carts));
			}
		} else if (quantity >= 1) {
			boolean status = cartDao.updateProductQuantityInCart(cartId, quantity);
			if (status == true) {
				List<Cart> carts = cartDao.getCartDetailsByUser(userId);
				out.print(gson.toJson(carts));
			}
		}
	}
}
