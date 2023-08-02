package com.ECW.User.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.Address.Dao.AddressDaoHibernate;
import com.ECW.Cart.Dao.CartDaoHibernate;
import com.ECW.Checkout.Dao.CheckoutDaoHibernate;
import com.ECW.Model.Address;
import com.ECW.Model.Cart;
import com.ECW.Model.Checkout;
import com.ECW.Model.User;
import com.ECW.User.Dao.UserDaoHibernate;

@WebServlet(name = "getIndividualUserDetailsController", urlPatterns = { "/getIndividualUserDetailsController" })
public class getIndividualUserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getIndividualUserDetailsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strUserId = request.getParameter("userId");
		long userId = Long.parseLong(strUserId);
		User particularUser = UserDaoHibernate.getUserDetails(userId);
		List<Address> addresses = AddressDaoHibernate.getAllAddressDetails(userId);
		HttpSession session = request.getSession();
		session.setAttribute("particularUser", particularUser);
		session.setAttribute("addresses", addresses);
		
		PrintWriter out = response.getWriter();
		out.print("success");
	}

}
