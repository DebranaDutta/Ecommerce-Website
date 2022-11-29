<%@page import="com.ECW.helper.JAVAView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
	<div class="container text-center mt-3" style="width: 450px;">
		<%@include file="CommonPages/message.jsp"%>
	</div>
	<div class="center">
		<h1>Login</h1>
		<form id="loginForm">
			<div class="txt_field">
				<input type="text" id="userName" name="userName" required="required" />
				<span></span> <label>Username</label>
			</div>
			<div class="txt_field">
				<input type="password" id="password" name="password" required="required" />
				<span></span> <label>Password</label>
			</div>
			<div class="pass">
				<a href="ForgotPasswordPage.jsp"> Forgot Password?</a>
			</div>
			<input type="button" value="Login" id="loginBtn" />
			<div class="singup_link">
				Not a member?<a href="SignUp.jsp" class="">Signup</a>
			</div>
		</form>
	</div>
</body>
<!-- BootStrap -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!-- FontAwsome -->
<script src="https://kit.fontawesome.com/400552a932.js" crossorigin="anonymous"></script>
<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Sweetalert -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script type="text/javascript" src="JS/login.js"></script>
</html>