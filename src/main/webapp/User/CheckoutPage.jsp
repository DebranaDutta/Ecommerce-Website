<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Cart.Dao.CartDaoJDBC"%>
<%@page import="com.ECW.Model.Cart"%>
<%@page import="com.ECW.helper.ConnectionProvider"%>
<%@page import="com.ECW.Address.Dao.AddressDaoJDBC"%>
<%@page import="com.ECW.Model.Address"%>
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
List<Address> addresses = new AddressDaoJDBC(ConnectionProvider.getConnection())
		.getAllAddressDetails(user.getPhoneNumber());
List<Cart> carts = new CartDaoJDBC(ConnectionProvider.getConnection()).getCartDetailsByUser(user.getPhoneNumber());
int totalPrice = 0;
for (Cart cart : carts) {
	totalPrice = totalPrice + (cart.getProductQuantity() * cart.getProductPrice());
}

int deliveryCharge = (totalPrice * 15) / 100;

int subTotal=totalPrice+deliveryCharge;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout Page</title>
<!-- bootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- Custom CSS -->
<link rel="stylesheet" href="CSS/CheckoutPage.css">
</head>
<body>
	<div class="sticky-top" style="margin-bottom: 15px; box-shadow: 0 3px 3px rgba(0, 0, 0, 0.5);">
		<nav class="navbar navbar-light bg-light">
			<div style="display: flex;">
				<i class="fa-solid fa-hippo"></i><b>Shoppy</b>
			</div>
			<span>Checkout</span>
		</nav>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-7">
				<div class="ml-3">
					<h4 style="font-weight: 600; color: #A51E01;" id="address">1. Select a delivery address</h4>
					<div class="card mr-4" style="border-radius: 7px;">
						<%
						for (Address a : addresses) {
						%>
						<div class="card-body">
							<input type="radio" value="<%=a.getAddressId()%>" name="addressDetails">
							<label><%=a.getAddressDetails() + " " + a.getCity() + " " + a.getZip() + " " + a.getState()%></label> <br>
							
							<%
							if (a.getContactNo() == null) {
							%>
							<div class="ml-3">
								<span>Contact no: </span><%=user.getPhoneNumber()%>
							</div>
							<%
							} else {
							%>
							<div class="ml-3">
								<span>Contact no: </span><%=a.getContactNo()%>
							</div>
							<%
							}
							%>
						</div>
						<%
						}
						%>
						<div style="display: flex;">
							<a href="#" class="btn" id="addNewadd">+ add new address</a> 
						</div>
					</div>
					<hr class="ml-3 mr-5">
					<div class="container-fluid" id="paymentMethod">
						<h4 style="font-weight: 600; color: #A51E01;">2. Payment method</h4>
						<div class="card mr-4" style="border-radius: 7px;">
							<div class="card-body">
								<div id="div1">
									<input type="radio" name="payment" id="payWithCard" value="payWithCard">
									<label for="payWithCard">Pay with Debit/Credit/ATM Cards</label>
									<div id="cardIcons">
										<div style="display: flex;">
											<img alt="" src="img/visa.png"> <img alt="" src="img/rupay.png"> <img alt="" src="img/master.png"> <img alt=""
												src="img/maestro.png">
										</div>
										<div>
											<a class="ml-3" href="#" style="color: #B7D2D5; font-size: 15px;">Enter card details > </a><span style="font-size: 14px;">Shoppy
												accepts all major credit & cards</span>
										</div>

									</div>
								</div>
								<div>
									<input type="radio" name="payment" id="netBanking" value="netBanking">
									<label for="netBanking">Net Banking</label>
									<div>
										<select id="netBankinglist" class="ml-3" style="border-radius: 10px;">
											<option>STATE BANK OF INDIA</option>
											<option>AXIS BANK</option>
											<option>HDFC BANK</option>
											<option>Canara BANK</option>
											<option>ICICI BANK</option>
										</select>
									</div>

								</div>
								<div>
									<input type="radio" name="payment" id="upi" value="upi">
									<label for="upi">UPI</label>
									<div id="upiIdDetails" class="ml-3">
										<label>Please enter your UPI ID</label>
										<div>
											<input type="text" placeholder="Ex:MobileNumber@upi" style="border: 0.5px solid; border-radius: 5px;">
											<a class="btn text-center" href="#">Verify</a>
										</div>
									</div>
								</div>
								<div>
									<input type="radio" name="payment" id="cod" value="cod">
									<label for="cod">Cash On Delivery</label>
									<div id="codLabel">
										<label class="ml-3" style="font-size: 13px; color: #B7D2D5">You can pay using UPI or Cash at your door step</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-5">
				<div>
					<h4 style="font-weight: 600; color: #A51E01;">Order Summery</h4>
					<div class="card mr-4" style="border-radius: 7px;">
						<div class="card-body">
							<table class="table">
								<thead class="class="thead-lighttext-center"">
									<tr>
										<th>Name</th>
										<th class="text-center">Quantity</th>
										<th class="text-center">Price</th>
									</tr>
								</thead>
								<tbody class="text-left">
									<%
									List<Integer> cartIds=new ArrayList<Integer>();
									List<Integer> prodIds=new ArrayList<Integer>();
									for (Cart c : carts) {
										cartIds.add(c.getCartId());
										prodIds.add(c.getProductId());
									%>
									<tr>
										<td>
											<div class="child">
												<img alt="" class="img-fluid" src="img/<%=c.getProductPic()%>">
											</div>
											<div class="child"><%=c.getProductName()%></div>
										</td>
										<td class="text-center"><%=c.getProductQuantity()%></td>
										<td class="text-center"><%=c.getProductQuantity() * c.getProductPrice()%></td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
							<hr>
							<h6 style="font-size: 13px; font-weight: 400; color: #5D5C5C" class="ml-2">
								Deliver Charges:
								<%=deliveryCharge%></h6>
							<h6 style="color: #831705; font-size: 17px; font-weight: 700;" class="ml-2">
								Total Order:
								<%=totalPrice%></h6>
							<hr style="width: 32%; margin-left: 0;">
							<h6 style="color: #831705; font-size: 17px; font-weight: 700;" class="ml-2">
								Sub Total:
								<%=totalPrice + deliveryCharge%></h6>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="text-center mt-3 mb-1">
			<input type="hidden" value="<%=cartIds%>" id="cartIds">
			<input type="hidden" value="<%=prodIds%>" id="productIds">
			<input type="hidden" value="<%=user.getPhoneNumber()%>" id="userId">
			<input type="hidden" value="<%=subTotal%>" id="totalPrice">
			<a class="btn" id="checkoutBtn" href="#">Checkout</a>
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
	<!-- Custome Script -->
	<script type="text/javascript" src="JS/CheckoutPage.js"></script>
</body>

<style>
i {
	margin-right: 5px;
}

b {
	font-size: 25px;
	color: rgba(30 120 5/ 50%);
}

.navbar span {
	font-weight: 300;
	font-size: 25px;
}

.fa-hippo {
	font-size: 35px;
	color: rgba(30 120 5/ 50%);
}

#addNewadd {
	color: #B7D2D5;
	margin-left: 20px;
	margin-bottom: 10px;
}

#addNewadd:hover {
	color: #B7D2D5;
	text-decoration: none;
}
</style>
</html>