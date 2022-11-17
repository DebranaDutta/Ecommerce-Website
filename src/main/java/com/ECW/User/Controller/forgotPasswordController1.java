package com.ECW.User.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.Dao.UserDao;
import com.ECW.Model.User;
import com.ECW.helper.ConnectionProvider;

@WebServlet(name = "forgotPasswordController1", urlPatterns = { "/forgotPasswordController1" })
public class forgotPasswordController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public forgotPasswordController1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String emailId = request.getParameter("emailId");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());
		User user = userDao.getUserDetailsByUserNameAndEmailId(userName, emailId);
		if (user == null) {
			out.print("error");
		} else {
			out.print("success");
			session.setAttribute("editUser", user);
		}
	}
}
