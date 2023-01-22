<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/userDetails.css">
</head>
<body>
	<div class="col-md-2">
		<div class="list-group text-left bg-light">
			<a href="userDetails.jsp" class="list-group-item">View Account Details</a>
			<!-- <a href="viewAddressDetails.jsp" class="list-group-item">View Address Details</a> -->
			<!-- <a href="showAllAddressController?userId=0" class="list-group-item">View Address Details</a> -->
			<a href="http://localhost:8080/E-commerceWebsite/showAllAddressController?userId=<%=user.getPhoneNumber()%>" class="list-group-item">View Address Details</a>
			<a href="addNewAddress.jsp" class="list-group-item">Add New Address</a>
			<a href="#" class="list-group-item">View Order History</a>
		</div>
	</div>
</body>
</html>
