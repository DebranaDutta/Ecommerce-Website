package com.ECW.User.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ECW.Dao.UserDao;
import com.ECW.helper.ConnectionProvider;

@WebServlet(name = "changePasswordController", urlPatterns = {"/changePasswordController"})
public class changePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public changePasswordController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newPassword=request.getParameter("newPassword");
		String userName=request.getParameter("userName");
		UserDao userDao=new UserDao(ConnectionProvider.getConnection());
		PrintWriter out=response.getWriter();
		boolean status= userDao.updateUserPassword(newPassword, userName);
		if(status==true) {
			out.print("success");
		}else {
			out.print("error");
		}
	}
}
