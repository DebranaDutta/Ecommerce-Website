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

import com.ECW.Cart.Dao.CartDaoHibernate;
import com.ECW.Cart.Dao.CartDaoJDBC;
import com.ECW.Model.Cart;
import com.ECW.Model.Product;
import com.ECW.Product.Dao.ProductDaoHibernate;
import com.ECW.Product.Dao.ProductDaoJDBC;
import com.ECW.helper.ConnectionProvider;
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
		Gson gson = new Gson();

		Product product = ProductDaoHibernate.getIndividualProductDetails(produtIdStr);
		Cart cart = new Cart(RandomIdGenerator.newIdGenrator(), product.getProductImage(), product.getProductName(), product.getProductPrice(), 1, new Date(), userId, productId,
				"active");
		List<Cart> carts = CartDaoHibernate.getCartDetailsByUser(userId);

		// Product product=new
		// ProductDaoJDBC(ConnectionProvider.getConnection()).getIndividualProductDetails(productId);
		// CartDaoJDBC cartDao = new CartDaoJDBC(ConnectionProvider.getConnection());

		try {
			if (carts.isEmpty()) {
				boolean stat = CartDaoHibernate.addProductToCart(cart);
				carts = CartDaoHibernate.getCartDetailsByUser(userId);
				if (stat == true) {
					String data = gson.toJson(carts);
					out.print("success" + "|" + data);
				}
			} else if (carts != null) {
				ArrayList<Cart> list = (ArrayList<Cart>) carts;
				int cartId = 0;
				int productQuantity = 0;
				boolean isExists = false;
				for (Cart c : list) {
					while (c.getProductId() == productId) {
						isExists = true;
						cartId = c.getCartId();
						productQuantity = c.getProductQuantity();
						break;
					}
				}
				if (isExists == true) {
					boolean stat = CartDaoHibernate.updateQuantityIfProductExists(cartId, productQuantity);
					carts = CartDaoHibernate.getCartDetailsByUser(userId);
					if (stat == true) {
						String data = gson.toJson(carts);
						out.print("success" + "|" + data);
					}
				} else if (isExists == false) {
					boolean stat = CartDaoHibernate.addProductToCart(cart);
					carts = CartDaoHibernate.getCartDetailsByUser(userId);
					if (stat == true) {
						String data = gson.toJson(carts);
						out.print("success" + "|" + data);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
