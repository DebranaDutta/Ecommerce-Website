
<%@page import="com.ECW.helper.ConnectionProvider"%>
<%@page import="com.ECW.Dao.CartDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.Model.Cart"%>
<%@page import="com.ECW.helper.JAVAView"%>
<%
	/* List<Cart> carts=new ArrayList<Cart>();
	carts=new CartDao(ConnectionProvider.getConnection()).getCartDetailsByUser(user.getPhoneNumber());
	System.out.println(carts); */
	//carts=(ArrayList<Cart>) session.getAttribute("carts");
%>
<div class="sticky-top" style="margin-bottom: 15px; box-shadow: 0 3px 20px rgba(0, 0, 0, 0.5);">
	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="border-radius: 15px">
		<div class="container-fluid">
			<i class="fa-solid fa-hippo"></i><a class="navbarTitle" href="UserHomePage.jsp"><b>Shoppy</b></a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item mr-5">
						<a class="nav-link" href="userDetails.jsp"><i class="fa-solid fa-user"></i><%=user.getFullName()%></a>
						<input type="hidden" id="userId" value="<%=user.getPhoneNumber()%>">
					</li>
					<li class="nav-item mr-5"><a class="nav-link" href="#"><i class="fa-solid fa-house"></i>Home</a></li>
					<li class="nav-item mr-5"><a class="nav-link" href="allProducts.jsp"><i class="fa-solid fa-bars"></i>All Products</a></li>
					<li class="nav-item mr-5"><a class="nav-link" id="getCartDetails" href="#" tabindex="-1" aria-disabled="true" data-bs-toggle="modal" data-bs-target="#MyCartModal"><span class="mr-1 mb-1 cart-items">( 0 )</span><i class="fa-solid fa-cart-shopping"></i>My Cart</a></li>
					<li class="nav-item mr-5"><a class="nav-link" href="#" tabindex="-1" aria-disabled="true"><i class="fa-solid fa-arrow-down-a-z"></i>My Orders</a></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="btn my-2 my-sm-0" href="<%=JAVAView.logoutController%>"><i class="fa-solid fa-right-from-bracket"></i>Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<style>

i {
	margin-right: 5px;
}

.fa-hippo {
	font-size: 50px;
	color: rgba(30 120 5/ 50%);
}

.navbarTitle {
	font-size: 30px;
	margin-right: 75px;
	color: rgba(35 135 15/ 50%);
	text-decoration: none;
}

.navbarTitle:hover {
	text-decoration: none;
	color: rgba(45 150 25/ 50%);
}
}
</style>
</div>

<!-- Modal -->
<%-- <div class="modal fade" id="cartModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">My Cart</h5>
				<button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<%if(carts==null){%>
				<h1>Nothing is there</h1>
				<%}else{%>
				<div class="cart-body">
					<table class="table">
						<thead class="thead-light text-center">
							<tr>
								<th>Name</th>
								<th>Price</th>
								<th>Date</th>
								<th>Quantity</th>
								<th>Total Price</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<%for(Cart cart:carts){%>
							<tr>
								<td>
									<div class="child">
										<img alt="" class="img-fluid" src="img/<%=cart.getProductPic()%>">
									</div>
									<div class="child"><%=cart.getProductName()%></div>
								</td>
								<td><%=cart.getProductPrice()%></td>
								<td><%=cart.getDate()%></td>
								<td><a href="#" class="mr-1"><i class="fa-solid fa-plus"></i></a><%=cart.getProductQuantity()%><a href="#" class="ml-2"><i class="fa-solid fa-minus"></i></a></td>
								<td><%=cart.getProductQuantity()*cart.getProductPrice()%></td>
								<td><a href="#" onclick="deleteFromCart(<%=cart.getCartId()%>)"><i class="fa-solid fa-trash-can"></i></a></td>
							</tr>
							<%}%>
						</tbody>
					</table>
				</div>
				<%}%>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary checkout-btn">Checkout</button>
			</div>
		</div>
	</div>
<style>
.child {
	display: inline-block;
}

.img-fluid {
	height: 50px;
}

.fa-plus {
	color: #737373;
}

.fa-plus:hover {
	color: #17A506;
}

.fa-minus {
	color: #737373;
}

.fa-minus:hover {
	color: #D34A38;
}

.fa-trash-can:hover {
	color: #FF0000;
}
</style>

	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- CustomScript -->
	<script type="text/javascript" src="JS/getCartDetails.js"></script>
</div> --%>