<%@page import="com.ECW.helper.gettingSecurityQuestionDetails"%>
<%@page import="com.ECW.Dao.CartDao"%>
<%@page import="com.ECW.Model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.helper.JAVAView"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
	session.setAttribute("message", "You are not loggedin!");
	response.sendRedirect(JAVAView.loginView);
	return;
}
//List<Cart> carts = (ArrayList<Cart>) session.getAttribute("carts");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<!-- bootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!--Custom CSS only -->
<link rel="stylesheet" href="CSS/userDetails.css">
<link rel="stylesheet" href="CSS/cartFunctions.css">
</head>
<body>
	<%@include file="Common/UserHomePageNavbar.jsp"%>
	<%@include file="Common/CartModal.jsp"%>
	<div class="mt-2">
		<div class="row">
			<!-- First COL -->
			<%@include file="Common/userDetailsList.jsp"%>
			<!-- Second COL -->
			<div class="col-md-10">
				<div class="container-fluid">
					<div class="userDetails">
						<div class="mt-2">
							<div class="text-center" id="userImgdiv">
								<img src="img/user.png" class="img-fluid" id="userImg" alt="...">
							</div>
							<hr style="border: 2px dotted #C2B9B7; margin-left: 50px; margin-right: 50px;">
							<div class="card-body" style="margin-left: 30px;">
								<div class="titleDetails">
									<h5 class="details" style="color: #7C7C7C;">Full Name:</h5>
									<h5 class="details" style="color: #9C9C9C;"><%=user.getFullName()%></h5>
								</div>
								<div class="titleDetails">
									<h5 class="details" style="color: #7C7C7C;">Email Id:</h5>
									<h5 class="details" style="color: #9C9C9C;"><%=user.getEmail()%></h5>
								</div>
								<div class="titleDetails">
									<h5 class="details" style="color: #7C7C7C;">Phone No:</h5>
									<h5 class="details" style="color: #9C9C9C;"><%=user.getPhoneNumber()%></h5>
								</div>
								<div class="titleDetails">
									<h5 class="details" style="color: #7C7C7C;">User Name:</h5>
									<h5 class="details" style="color: #9C9C9C;"><%=user.getUserName()%></h5>
								</div>
								<div class="titleDetails">
									<h5 class="details" style="color: #7C7C7C;">Password:</h5>
									<h5 class="details" style="color: #9C9C9C;"><%=user.getPassword()%></h5>
								</div>
								<div class="titleDetails">
									<h5 class="details" style="color: #7C7C7C;">Security Question:</h5>
									<h5 class="details" style="color: #9C9C9C;"><%=gettingSecurityQuestionDetails.getSecurityQuestion(user.getSecurityQuestion())%></h5>
								</div>
								<div class="titleDetails">
									<h5 class="details" style="color: #7C7C7C;">Answer:</h5>
									<h5 class="details" style="color: #9C9C9C;"><%=user.getAnswer()%></h5>
								</div>
							</div>
							<div class="text-center mb-2">
								<a href="#" class="btn btn-primary text-center" style="border-radius: 5px" data-bs-toggle="modal" data-bs-target="#exampleModalCenter">Edit</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- EDIT USERDETAILS MODAL -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Edit Personal Details:</h5>
					<button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="titleDetails">
						<h5 class="details" style="color: #7C7C7C;">Full Name:</h5>
						<h5 class="details" style="color: #9C9C9C;"><%=user.getFullName()%></h5>
					</div>
					<div class="titleDetails">
						<h5 class="details" style="color: #7C7C7C;">Email Id:</h5>
						<input class="details" id="emailId" value="<%=user.getEmail()%>">
					</div>
					<div class="titleDetails">
						<h5 class="details" style="color: #7C7C7C;">Phone No:</h5>
						<h5 class="details" style="color: #9C9C9C;"><%=user.getPhoneNumber()%></h5>
						<input id="phoneNo" type="hidden" value="<%=user.getPhoneNumber()%>">
					</div>
					<div class="titleDetails">
						<h5 class="details" style="color: #7C7C7C;">User Name:</h5>
						<input class="details"  id="userName" value="<%=user.getUserName()%>">
					</div>
					<div class="titleDetails">
						<h5 class="details" style="color: #7C7C7C;">Password:</h5>
						<input class="details" id="password" value="<%=user.getPassword()%>">
					</div>
					<div class="titleDetails">
						<h5 class="details" style="color: #7C7C7C;">Security Question:</h5>
						<%-- <h5 class="details" style="color: #9C9C9C;"><%=gettingSecurityQuestionDetails.getSecurityQuestion(user.getSecurityQuestion())%></h5> --%>
						<select class="selectDropdown" id="seqQs">
							<%
							if (user.getSecurityQuestion().equals("1")) {
							%>
							<option value="1" class="op1"><%=gettingSecurityQuestionDetails.getSecurityQuestion(user.getSecurityQuestion())%></option>
							<option value="2">What was first school?</option>
							<option value="3">What is your mother's maiden name?</option>
							<option value="4">what was your first pet name?</option>
							<%
							}else if(user.getSecurityQuestion().equals("2")){
							%>
							<option value="2">What was first school?</option>
							<option value="1">What was your first Car?</option>
							<option value="3">What is your mother's maiden name?</option>
							<option value="4">what was your first pet name?</option>
							<%	
							}else if(user.getSecurityQuestion().equals("3")){
							%>
							<option value="3">What is your mother's maiden name?</option>
							<option value="2">What was first school?</option>
							<option value="1">What was your first Car?</option>
							<option value="4">what was your first pet name?</option>
							<%
							}else{
							%>
							<option value="4">what was your first pet name?</option>
							<option value="3">What is your mother's maiden name?</option>
							<option value="2">What was first school?</option>
							<option value="1">What was your first Car?</option>
							<%}%>
						</select>
					</div>
					<div class="titleDetails">
						<h5 class="details" style="color: #7C7C7C;">Answer:</h5>
						<input class="details" id="seqAns" value="<%=user.getAnswer()%>">
					</div>
				</div>
				<hr style="border: 1px solid #C2B9B7; margin-left: 50px; margin-right: 50px;">
				<div class="text-center mb-2">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="save">Save</button>
				</div>
			</div>
		</div>
	</div>
	<!-- BootStrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<!-- FontAwsome -->
	<script src="https://kit.fontawesome.com/400552a932.js" crossorigin="anonymous"></script>
	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- Sweetalert -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<!-- CustomScript -->
	<script type="text/javascript" src="JS/updateUserDetails.js"></script>
	<script type="text/javascript" src="JS/cartFunctions.js"></script>
</body>
</html>