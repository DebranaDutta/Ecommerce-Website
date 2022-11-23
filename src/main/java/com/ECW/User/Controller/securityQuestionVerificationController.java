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
import com.ECW.helper.ConnectionProvider;

@WebServlet(name = "securityQuestionVerificationController", urlPatterns = {"/securityQuestionVerificationController"})
public class securityQuestionVerificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public securityQuestionVerificationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String answer=request.getParameter("answer");
		PrintWriter out=response.getWriter();	
		UserDao userDao=new UserDao(ConnectionProvider.getConnection());
		if(userDao.getSecurityAnsweByUserName(userName).equals(answer)) {
			out.print("success");
		}else {
			out.print("error");
		}
	}
}
