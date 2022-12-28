<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" href="CSS/ForgotPasswordPage.css" />
</head>
<body>
<body>
	<div class="center">
		<h1>Fill Below Details</h1>
		<form method="post">
			<div class="txt_field">
				<input type="text" id="userName" required="required" onchange="validateUserName()"/>
				<span></span> <label id="userNameLabel">Enter Username</label>
			</div>
			<div id="enterQandS" hidden>
				<div>
					<span></span> <label id="question"></label>
				</div>
				<div class="txt_field">
					<input type="text" id="answer" required="required" />
					<span></span> <label>Enter Answer</label>
				</div>
				<input type="button" value="Submit" id="submitBtn"/>
			</div>
		</form>
	</div>
</body>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script type="text/javascript" src="JS/ForgotPasswordPage.js"></script>
</html>