<%@page import="com.ECW.helper.GeneralCalculation"%>
<%@page import="com.ECW.Address.Dao.AddressDaoJDBC"%>
<%@page import="com.ECW.Model.Address"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.ECW.Model.Checkout"%>
<%@page import="com.ECW.Dao.CheckoutDao"%>
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
CheckoutDao checkoutDao = new CheckoutDao(ConnectionProvider.getConnection());
AddressDaoJDBC addressDao = new AddressDaoJDBC(ConnectionProvider.getConnection());
CartDaoJDBC cartDao = new CartDaoJDBC(ConnectionProvider.getConnection());
List<Checkout> checkouts = checkoutDao.getOrderDetails(user.getPhoneNumber());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>
<!-- bootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!--Custom CSS only -->
<link rel="stylesheet" href="CSS/cartFunctions.css">
</head>
<body>
	<%@include file="Common/UserHomePageNavbar.jsp"%>
	<%@include file="Common/CartModal.jsp"%>
	<div class="container-fluid">
		<%
		if (checkouts.isEmpty()) {
		%>
		<div class="card text-center" style="border-radius: 7px;">
			<h1>You havent ordered in a while!</h1>
		</div>
		<%
		} else {
		%>
		<div class="card mb-2" style="border-radius: 7px;">
			<%
			for (Checkout checkout : checkouts) {
				Address address = addressDao.getAddressDetilsByAddressId(checkout.getAddressId());
				List<Integer> cartIds = GeneralCalculation.ConvertStringToArrayList(checkout.getCartId());
			%>
			<div class="card m-3" style="border-radius: 10px;">
				<div>
					<div class="mt-2" style="display: flex;">
						<div class="ml-3" style="display: flex;">
							<span class="mr-2 span1">Transaction Id:</span>
							<p><%=checkout.getTransactionId()%></p>
						</div>
						<div class="ml-5" style="display: flex;">
							<span class="mr-2 span1">Total Amount:</span>
							<p><%=checkout.getTotalPrice()%></p>
						</div>
					</div>
					<div class="ml-3">
						<div style="display: flex;">
							<span class="mr-2 span1">Delivery Address:</span>
							<p><%=address.getAddressDetails() + " " + address.getCity() + " " + address.getZip() + " " + address.getState()%></p>
						</div>
						<div style="display: flex;">
							<span class="mr-2 span1">Contact No:</span>
							<p><%=address.getContactNo()%></p>
						</div>
					</div>
				</div>
				<div class="row">
					<%
					for (Integer i : cartIds) {
						Cart cart = cartDao.getCartDetailsByCartIdAsIncative(i);
					%>
					<div class="col ml-3 mb-3">
						<div class="card" style="width: 12rem; height: 10rem; border-radius: 7px;">
							<div class="text-center">
								<img src="img/<%=cart.getProductPic()%>" class="card-img-top mt-1" alt="">
							</div>
							<div class="text-center">
								<span class="span1"><%=cart.getProductName()%></span>
							</div>
							<div class="ml-3">
								<div style="display: flex;">
									<span class="mr-1 span1">Quantity:</span> <label><%=cart.getProductQuantity()%></label>
								</div>
								<div style="display: flex;">
									<span class="mr-1 span1">Unit Price:</span> <label><%=cart.getProductPrice()%></label>
								</div>
							</div>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
			<%
			}
			%>
		</div>
		<%
		}
		%>
	</div>
	<style>
p {
	font-size: 13px;
	font-weight: 500;
	color: #6C6A6A;
}

.span1 {
	font-size: 14px;
	font-weight: 600;
	color: #8D1900;
}

label {
	font-size: 13px;
	font-weight: 500;
	color: #6C6A6A;
}

.card-img-top {
	width: 6rem;
	height: 4rem;
}
</style>
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
	<script type="text/javascript" src="JS/cartFunctions.js"></script>
</body>
</html>