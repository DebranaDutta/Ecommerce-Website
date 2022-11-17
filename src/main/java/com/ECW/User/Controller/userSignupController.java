package com.ECW.User.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ECW.Model.User;
import com.ECW.helper.CrudOperationsUsingHibernate;

@WebServlet(name = "userSignupController", urlPatterns = {"/userSignupController"})
public class userSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public userSignupController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName=request.getParameter("fullName");
		String userName=request.getParameter("userName");
		String email=request.getParameter("email");
		long phoneNumber=Long.parseLong(request.getParameter("phoneNumber"));
		String password=request.getParameter("password");
		String securityQuestion=request.getParameter("securityQuestion");
		String answer=request.getParameter("answer");
		String gender=request.getParameter("gender");
		PrintWriter out=response.getWriter();
		User user=new User(fullName, userName, email, phoneNumber, password, securityQuestion, answer, gender, new Date());
		
		boolean status= CrudOperationsUsingHibernate.addNewUser(user);
		System.out.println(status);
		if(status==true) {
			out.print("success");
		}
	}
}
