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

import com.ECW.Cart.Dao.CartDaoJDBC;
import com.ECW.Model.Cart;
import com.ECW.Model.Product;
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
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		Long userId = Long.parseLong(request.getParameter("userId"));

		PrintWriter out = response.getWriter();
		CartDaoJDBC cartDao = new CartDaoJDBC(ConnectionProvider.getConnection());
		Gson gson = new Gson();

		//Product product = CrudOperationsUsingHibernate.getIndividualProductDetails(produtIdStr);
		Product product=new ProductDaoJDBC(ConnectionProvider.getConnection()).getIndividualProductDetails(productId);
		Cart cart = new Cart(RandomIdGenerator.newIdGenrator(), product.getProductImage(), product.getProductName(), product.getProductPrice(), 1, new Date(), userId, productId, "active");
		List<Cart> carts = cartDao.getCartDetailsByUser(userId);

		try {
			if (carts.isEmpty()) {
				boolean stat = cartDao.addProductToCart(cart);
				carts = cartDao.getCartDetailsByUser(userId);
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
					boolean stat = cartDao.updateQuantityIfProductExists(cartId, productQuantity);
					carts = cartDao.getCartDetailsByUser(userId);
					if (stat == true) {
						String data = gson.toJson(carts);
						out.print("success" + "|" + data);
					}
				} else if (isExists == false) {
					boolean stat = cartDao.addProductToCart(cart);
					carts = cartDao.getCartDetailsByUser(userId);
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
