<%@page import="com.ECW.Model.Cart"%>
<%@page import="com.ECW.Model.Address"%>
<%@page import="com.ECW.helper.GeneralCalculation"%>
<%@page import="com.ECW.Cart.Dao.CartDaoJDBC"%>
<%@page import="com.ECW.Address.Dao.AddressDaoJDBC"%>
<%@page import="com.ECW.helper.ConnectionProvider"%>
<%@page import="com.ECW.Checkout.Dao.CheckoutDaoJDBC"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Checkout"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.helper.JAVAView"%>
<%@page import="com.ECW.Model.User"%>
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
List<Checkout> checkouts = (ArrayList) session.getAttribute("checkouts");
CheckoutDaoJDBC checkoutDao = new CheckoutDaoJDBC(ConnectionProvider.getConnection());
AddressDaoJDBC addressDao = new AddressDaoJDBC(ConnectionProvider.getConnection());
CartDaoJDBC cartDao = new CartDaoJDBC(ConnectionProvider.getConnection());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Individual User Order Details</title>
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
					<%
					if (checkouts.isEmpty()) {
					%>
					<div class="text-center">
						<h1 id="Notice">
							No orders placed by <span style="color: #FF4711"><%=particularUser.getFullName()%></span>
						</h1>
					</div>
					<%
					} else {
					%>
					<div
						class="card"
						style="border-radius: 7px;">
						<%
						for (Checkout checkout : checkouts) {
							Address address = addressDao.getAddressDetilsByAddressId(checkout.getAddressId());
							List<Integer> cartIds = GeneralCalculation.ConvertStringToArrayList(checkout.getCartId());
						%>
						<div
							class="card m-3"
							style="border-radius: 10px;">
							<div>
								<div
									class="mt-2"
									style="display: flex;">
									<div
										class="ml-3"
										style="display: flex;">
										<span class="mr-2 span1">Transaction Id:</span>
										<p><%=checkout.getTransactionId()%></p>
									</div>
									<div
										class="ml-5"
										style="display: flex;">
										<span class="mr-2 span1">Total Amount:</span>
										<p><%=checkout.getTotalPrice()%></p>
									</div>
									<div
										class="ml-5"
										style="display: flex">
										<span class="mr-2 span1">Date:</span>
										<p><%=checkout.getDate()%></p>
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
									<div
										class="card"
										style="width: 12rem; height: 10rem; border-radius: 7px;">
										<div class="text-center">
											<img
												src="img/<%=cart.getProductPic()%>"
												class="card-img-top mt-1"
												alt="">
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
							<div class="text-center mb-2">
								<a
									class="btn btn-primary"
									style="color: white">Approve</a> <a
									class="btn btn-secondary ml-2"
									style="color: white">Cancel</a>
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
			</div>
		</div>
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

#Notice {
	text-shadow: 0 .2rem .3rem rgb(0, 0, 0, .5);
	margin-top: 50px;
}
</style>

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