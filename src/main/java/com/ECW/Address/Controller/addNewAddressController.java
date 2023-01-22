package com.ECW.Address.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.Dao.AddressDao;
import com.ECW.Model.Address;
import com.ECW.helper.ConnectionProvider;
import com.mysql.cj.Session;

@WebServlet(name = "addNewAddressController", urlPatterns = { "/addNewAddressController" })
public class addNewAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public addNewAddressController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String addreassDetails = addressLine1 + " " + addressLine2;
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zip = Integer.parseInt(request.getParameter("zip"));
		long userId = Long.parseLong(request.getParameter("userId"));
		Address address = new Address(new Random().nextInt(10000), addreassDetails, city, state, zip, userId);
		boolean stat = new AddressDao(ConnectionProvider.getConnection()).addNewAddress(address);
		if (stat == true) {
			List<Address> addresses = new AddressDao(ConnectionProvider.getConnection()).getAllAddressDetails(userId);
			session.setAttribute("addresses", addresses);
			out.print("success");
		}
	}
}
