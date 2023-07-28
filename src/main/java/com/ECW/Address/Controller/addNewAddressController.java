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

import com.ECW.Address.Dao.AddressDaoHibernate;
import com.ECW.Address.Dao.AddressDaoJDBC;
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
		String contactNo = request.getParameter("contactNo");
		Address address = new Address();
		address = new Address(new Random().nextInt(10000), addreassDetails, city, state, zip, userId, contactNo);
		// boolean stat = new
		// AddressDaoJDBC(ConnectionProvider.getConnection()).addNewAddress(address);
		boolean stat = AddressDaoHibernate.addNewAddress(address);
		if (stat == true) {
			List<Address> addresses = new AddressDaoJDBC(ConnectionProvider.getConnection()).getAllAddressDetails(userId);
			session.setAttribute("addresses", addresses);
			out.print("success");
		}
	}
}
