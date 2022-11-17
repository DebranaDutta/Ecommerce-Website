<%@page import="com.ECW.helper.JAVAView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
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
				<a href="ForgotPasswordPage1.jsp"> Forgot Password?</a>
			</div>
			<input type="button" value="Login" id="loginBtn" />
			<div class="singup_link">
				Not a member?<a href="SignUp.jsp" class="">Signup</a>
			</div>
		</form>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script type="text/javascript" src="JS/login.js"></script>
</html>