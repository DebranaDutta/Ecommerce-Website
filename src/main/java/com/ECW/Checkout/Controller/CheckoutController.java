package com.ECW.Checkout.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.Cart.Dao.CartDaoJDBC;
import com.ECW.Checkout.Dao.CheckoutDao;
import com.ECW.Model.Cart;
import com.ECW.Model.Checkout;
import com.ECW.helper.ConnectionProvider;
import com.ECW.helper.GeneralCalculation;
import com.ECW.helper.RandomIdGenerator;

@WebServlet(name = "CheckoutController", urlPatterns = { "/CheckoutController" })
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckoutController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		String mop = request.getParameter("mop");
		String cartIds = request.getParameter("cartIds");
		String productIds = request.getParameter("productIds");
		long userId = Long.parseLong(request.getParameter("userId"));
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));

		String transactionId = RandomIdGenerator.generateUUID();

		PrintWriter out = response.getWriter();
		
		List<Integer> favList=GeneralCalculation.ConvertStringToArrayList(cartIds);
		
		/*String replace = cartIds.replace("[", "");
		String replace1 = replace.replace("]", "");
		List<String> arrayList = new ArrayList<String>(Arrays.asList(replace1.split(",")));
		List<Integer> favList = new ArrayList<Integer>();
		for (String fav : arrayList) {
			favList.add(Integer.parseInt(fav.trim()));
		}*/
		
		

		try {
			Checkout checkout = new Checkout(transactionId, totalPrice, mop, productIds, cartIds, userId, addressId, new Date());
			CheckoutDao checkoutDao = new CheckoutDao(ConnectionProvider.getConnection());
			CartDaoJDBC cartDao = new CartDaoJDBC(ConnectionProvider.getConnection());
			for (Integer i : favList) {
				cartDao.changeCartStatus(i);
			}
			boolean stat = checkoutDao.insertIntoCheckoutTable(checkout);
			if (stat == true) {
				out.print("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
