package com.ECW.User.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "forgotPasswordController2", urlPatterns = {"/forgotPasswordController2"})
public class forgotPasswordController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public forgotPasswordController2() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newPassword=request.getParameter("newPassword");
		PrintWriter out=response.getWriter();
		
	}

}
