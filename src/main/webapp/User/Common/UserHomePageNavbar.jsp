
<%@page import="com.ECW.helper.ConnectionProvider"%>
<%@page import="com.ECW.Dao.CartDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.Model.Cart"%>
<%@page import="com.ECW.helper.JAVAView"%>
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

</style>
</div>