<%@page import="com.ECW.Model.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.helper.JAVAView"%>
<%@page import="com.ECW.Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
	session.setAttribute("message", "You are not loggedin!");
	response.sendRedirect(JAVAView.loginView);
	return;
}
List<Cart> carts = (ArrayList<Cart>) session.getAttribute("carts");
List<Address> addresses = (ArrayList<Address>) session.getAttribute("addresses");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Address Details</title>
<!-- bootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!--Custom CSS only -->
<link rel="stylesheet" href="CSS/viewAddressDetails.css">
<link rel="stylesheet" href="CSS/toast.css">
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
			<input type="hidden" value="<%=user.getPhoneNumber()%>" id="userId" />
			<div class="col-md-10">
				<div class="container-fluid">
					<%
					for (Address address : addresses) {
					%>
					<div class="addNewAddressClass" id="<%=address.getAddressId()%>">
						<div class="divh5" style="display: flex;">
							<h5><%=address.getAddressDetails() + " " + address.getCity() + " " + address.getState() + " " + address.getZip()%></h5>
						</div>
						<div style="display: flex;">
							<input type="hidden" value="<%=address.getAddressId()%>" class="addressId" />
							<a class="btn btn-primary" style="color: white;">Edit</a> <a class="btn btn-danger" style="color: white;" onclick="deleteData(<%=address.getAddressId()%>)">Delete</a>
						</div>
					</div>
					<%
					}
					%>
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
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<!-- CustomScript -->
	<script type="text/javascript" src="JS/addressFunctions.js"></script>
	<script type="text/javascript" src="JS/cartFunctions.js"></script>
</body>
</html>