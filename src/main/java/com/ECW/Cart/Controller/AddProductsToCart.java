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

import org.hibernate.internal.build.AllowSysOut;

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
		HttpSession session = request.getSession();

		Product product = CrudOperationsUsingHibernate.getIndividualProductDetails(produtIdStr);
		Cart cart = new Cart(RandomIdGenerator.newIdGenrator(), product.getProductImage(), product.getProductName(), product.getProductPrice(), 1, new Date(), userId, productId, "active");
		List<Cart> carts = cartDao.getCartDetailsByUser(userId);

		try {
			if (carts.isEmpty()) {
				boolean stat = cartDao.addProductToCart(cart);
				carts = cartDao.getCartDetailsByUser(userId);
				if (stat == true) {
					session.setAttribute("carts", carts);
					String data=gson.toJson(carts);
					System.out.print(data);
					out.print("success"+"|"+data);
				}
			} else {
				for (Cart c : carts) {
					if (c.getProductId() == productId) {
						boolean stat = cartDao.updateQuantityIfProductExists(c.getCartId(), c.getProductQuantity());
						carts = cartDao.getCartDetailsByUser(userId);
						if (stat == true) {
							session.setAttribute("carts", carts);
							String data=gson.toJson(carts);
							out.print("success"+"|"+data);
						}
					} else {
						boolean stat = cartDao.addProductToCart(cart);
						carts = cartDao.getCartDetailsByUser(userId);
						if (stat == true) {
							session.setAttribute("carts", carts);
							String data=gson.toJson(carts);
							out.print("success"+"|"+data);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
