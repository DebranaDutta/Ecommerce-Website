<%@page import="com.ECW.helper.gettingSecurityQuestionDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.Model.User"%>
<%@page import="com.ECW.helper.JAVAView"%>
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
	session.setAttribute("message", "You are not loggedin!");
	response.sendRedirect(JAVAView.loginView);
	return;
} else {
	if (user.getUserType().equalsIgnoreCase("normal")) {
		session.setAttribute("message", "You are not autorized access this portal");
		response.sendRedirect("login.jsp");
		return;
	}
}
User particularUser = (User) session.getAttribute("particularUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Individual User Account Details</title>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	rel="stylesheet"
	href="CSS/commonCss/background.css">
</head>
<body>
	<%@include file="Common/AdminNavbar.jsp"%>
	<div class="mt-2">
		<div class="row">
			<!-- First COL -->
			<%@include file="userDetailsList.jsp"%>
			<!-- Second COL -->
			<div class="col-md-10">
				<div class="container-fluid">
					<div class="userDetails">
						<div class="mt-2">
							<div
								class="text-center"
								id="userImgdiv">
								<img
									src="img/user.png"
									class="img-fluid"
									id="userImg"
									alt="...">
							</div>
							<hr style="border: 2px dotted #C2B9B7; margin-left: 50px; margin-right: 50px;">
							<div
								class="card-body"
								style="margin-left: 30px;">
								<div class="titleDetails">
									<h5
										class="details"
										style="color: #7C7C7C;">Full Name:</h5>
									<h5
										class="details"
										style="color: #9C9C9C;"><%=particularUser.getFullName()%></h5>
								</div>
								<div class="titleDetails">
									<h5
										class="details"
										style="color: #7C7C7C;">Email Id:</h5>
									<h5
										class="details"
										style="color: #9C9C9C;"><%=particularUser.getEmail()%></h5>
								</div>
								<div class="titleDetails">
									<h5
										class="details"
										style="color: #7C7C7C;">Phone No:</h5>
									<h5
										class="details"
										style="color: #9C9C9C;"><%=particularUser.getPhoneNumber()%></h5>
								</div>
								<div class="titleDetails">
									<h5
										class="details"
										style="color: #7C7C7C;">User Name:</h5>
									<h5
										class="details"
										style="color: #9C9C9C;"><%=particularUser.getUserName()%></h5>
								</div>
								<div class="titleDetails">
									<h5
										class="details"
										style="color: #7C7C7C;">Security Question:</h5>
									<h5
										class="details"
										style="color: #9C9C9C;"><%=gettingSecurityQuestionDetails.getSecurityQuestion(particularUser.getSecurityQuestion())%></h5>
								</div>
								<div class="titleDetails">
									<h5
										class="details"
										style="color: #7C7C7C;">Answer:</h5>
									<h5
										class="details"
										style="color: #9C9C9C;"><%=particularUser.getAnswer()%></h5>
								</div>
							</div>
							<div class="text-center mb-2">
								<a
									href="#"
									class="btn btn-primary text-center"
									style="border-radius: 5px"
									data-bs-toggle="modal"
									data-bs-target="#exampleModalCenter">Contact</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- BootStrap -->
			<script
				src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
				integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
				integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
				integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
				crossorigin="anonymous"></script>
			<!-- FontAwsome -->
			<script
				src="https://kit.fontawesome.com/400552a932.js"
				crossorigin="anonymous"></script>
			<!-- JQuery -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<!-- Sweetalert -->
			<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
			<!-- CustomScript -->
</body>
</html>