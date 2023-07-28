package com.ECW.Address.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.Address.Dao.AddressDaoJDBC;
import com.ECW.Model.Address;
import com.ECW.helper.ConnectionProvider;

@WebServlet(name = "removeAddressController", urlPatterns = { "/removeAddressController" })
public class removeAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public removeAddressController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		Long userId = Long.parseLong(request.getParameter("userId"));
		boolean status = new AddressDaoJDBC(ConnectionProvider.getConnection()).removeAddress(addressId);
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		if (status == true) {
			List<Address> addresses=new AddressDaoJDBC(ConnectionProvider.getConnection()).getAllAddressDetails(userId);
			session.setAttribute("addresses", addresses);
			out.print("success");
		}
	}

}
