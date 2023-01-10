package com.ECW.User.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.Dao.UserDao;
import com.ECW.Model.User;
import com.ECW.helper.ConnectionProvider;

@WebServlet(name = "updateUserDetails", urlPatterns = { "/updateUserDetails" })
public class updateUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateUserDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("emailId");
		long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String seqQs = request.getParameter("seqQs");
		String seqAns = request.getParameter("seqAns");
		
		PrintWriter out=response.getWriter();
		User user = new User(userName, emailId, phoneNo, password, seqQs, seqAns);
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());
		boolean stat = userDao.updateUserDetails(user);
		if(stat==true) {
			
			out.print("success");
		}
	}

}
