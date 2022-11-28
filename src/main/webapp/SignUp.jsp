<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<link rel="stylesheet" href="CSS/SignUp.css" />
</head>
<body>
	<div class="container">
		<div class="title">Registration</div>
		<form action="#">
			<div class="user-details">
				<div class="input-box">
					<span class="details">Full Name</span>
					<input type="text" placeholder="Enter your full name" id="fullName" required />
				</div>
				<div class="input-box">
					<span class="details">Username</span>
					<input type="text" placeholder="Enter your username" id="userName" required />
				</div>
				<div class="input-box">
					<span class="details">Email</span>
					<input type="email" placeholder="Enter your email" id="email" required />
				</div>
				<div class="input-box">
					<span class="details">Phone Number</span>
					<input type="text" placeholder="Enter your number" id="phoneNumber" required />
				</div>
				<div class="input-box">
					<span class="details">Password</span>
					<input type="password" placeholder="Enter your password" id="password" required />
				</div>
				<div class="input-box">
					<span class="details">Confirm Password</span>
					<input type="password" placeholder="Confirm your password" id="cnfPassword" required />
				</div>
				<div class="input-box">
					<span class="details">Security Question</span> <select name="" id="securityQuestion" class="select">
						<option value="1" class="op1">What was your first Car?</option>
						<option value="2">What was first school?</option>
						<option value="3">What is your mother's maiden name?</option>
						<option value="4">what was your first pet name?</option>
					</select>
				</div>
				<div class="input-box">
					<span class="details">Answer</span>
					<input type="text" placeholder="Enetre answer" id="answer" required />
				</div>
			</div>
			<div class="getnder-details">
				<input type="radio" name="gender" value="male" id="dot-1" />
				<input type="radio" name="gender" value="female" id="dot-2" />
				<input type="radio" name="gender" value="other" id="dot-3" />
				<span class="gender-title">Gender</span>
				<div class="category">
					<label for="dot-1"> <span class="dot one"></span> <spann class="gender">Male</spann>
					</label> <label for="dot-2"> <span class="dot two"></span> <spann class="gender">Female</spann>
					</label> <label for="dot-3"> <span class="dot three"></span> <spann class="gender">Other</spann>
					</label>
				</div>
			</div>
			<div class="button">
				<input type="button" name="" value="Register" id="registerBtn" />
			</div>
			<div class="login">
				<a href="login.jsp">Login</a>
			</div>
		</form>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script type="text/javascript" src="JS/SignUp.js"></script>
</html>