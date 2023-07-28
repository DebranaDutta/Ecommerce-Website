package com.ECW.User.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ECW.User.Dao.UserDaoJDBC;
import com.ECW.helper.ConnectionProvider;
import com.ECW.helper.gettingSecurityQuestionDetails;

@WebServlet(name = "UserNameVerificationCOntroller", urlPatterns = {"/UserNameVerificationCOntroller"})
public class UserNameVerificationCOntroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserNameVerificationCOntroller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		UserDaoJDBC userDao=new UserDaoJDBC(ConnectionProvider.getConnection());
		String securityQuestionId=userDao.getSecurityQuestionByUserName(userName);
		PrintWriter out=response.getWriter();
		if(securityQuestionId==null) {
			out.println("error"+","+"");
		}else {
			String securityQuestion= gettingSecurityQuestionDetails.getSecurityQuestion(securityQuestionId);
			out.println("success"+","+securityQuestion);
		}
	}
}
