package com.ECW.Address.Controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet(name = "showAllAddressController", urlPatterns = { "/showAllAddressController" })
public class showAllAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public showAllAddressController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long userId = Long.parseLong(request.getParameter("userId"));
		/*AddressDaoJDBC addressDao = new AddressDaoJDBC(ConnectionProvider.getConnection());
		List<Address> addresses = addressDao.getAllAddressDetails(userId);*/
		
		List<Address> addresses=AddressDaoHibernate.getAllAddressDetails(userId);
		
		HttpSession session=request.getSession();
		session.setAttribute("addresses", addresses);
		response.sendRedirect("User/viewAddressDetails.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
