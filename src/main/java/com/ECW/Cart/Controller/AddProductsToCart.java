package com.ECW.Cart.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.Dao.CartDao;
import com.ECW.Model.Cart;
import com.ECW.Model.Product;
import com.ECW.helper.ConnectionProvider;
import com.ECW.helper.CrudOperationsUsingHibernate;
import com.ECW.helper.RandomIdGenerator;
import com.google.gson.Gson;

@WebServlet(name = "AddProductsToCart", urlPatterns = { "/AddProductsToCart" })
public class AddProductsToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProductsToCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String produtIdStr = request.getParameter("productId");
		int productId = Integer.parseInt(produtIdStr);
		Long userId = Long.parseLong(request.getParameter("userId"));

		PrintWriter out = response.getWriter();
		CartDao cartDao = new CartDao(ConnectionProvider.getConnection());
		Gson gson = new Gson();

		//Creating art obj
		Product product = CrudOperationsUsingHibernate.getIndividualProductDetails(produtIdStr);
		int cartId = RandomIdGenerator.newIdGenrator();
		String status = "active";
		Cart cart = new Cart(cartId, product.getProductImage(), product.getProductName(), product.getProductPrice(), 1, new Date(), userId, productId, status);
		
		
		// Getting existing cart details
		List<Cart> carts = cartDao.getCartDetailsByUser(userId);
		System.out.println(carts.isEmpty());
		if (carts.isEmpty()) {
			boolean stat = cartDao.addProductToCart(cart);
			if (stat == true) {
				carts = cartDao.getCartDetailsByUser(userId);
				out.print(gson.toJson(carts));
			}
		} else {
			boolean exists = false;
			for (Cart c : carts) {
				if (c.getProductId() == productId) {
					// update product quantity of that particular cart by 1
					exists = cartDao.updateQuantityIfProductExists(c.getCartId(), c.getProductQuantity());
					if (exists == true) {
						carts = cartDao.getCartDetailsByUser(userId);
						out.print(gson.toJson(carts));
					}
				}
				if(!exists) {
					boolean stat=cartDao.addProductToCart(cart);
					if (stat == true) {
						carts = cartDao.getCartDetailsByUser(userId);
						out.print(gson.toJson(carts));
					}
				}
			}
		}

	}

}
