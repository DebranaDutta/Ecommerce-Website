<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" href="CSS/ForgotPasswordPage1.css" />
</head>
<body>
	<div class="center">
		<h1>Fill Below Details</h1>
		<form method="post">
			<div class="txt_field">
				<input type="text" id="userName" required />
				<span></span> <label>Enter Username</label>
			</div>
			<div class="txt_field">
				<input type="text" id="emailId" required="required" />
				<span></span> <label>Enter Registered EmailId</label>
			</div>
			<input type="button" value="Submit" id="submitBtn"/>
		</form>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script type="text/javascript" src="JS/ForgotPasswordPage1.js"></script>
</html>
