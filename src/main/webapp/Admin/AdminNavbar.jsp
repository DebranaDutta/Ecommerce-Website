<%@page import="com.ECW.helper.JAVAView"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="border-radius: 20px">
	<a class="navbar-brand" style="font-family: cursive;" href="AdminHome.jsp"><b>Welcome to Admin</b></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse ml-5" id="navbarSupportedContent" >
		<ul class="navbar-nav mr-auto">
			<li class="nav-item mr-5"><a class="nav-link" href="AddNewProduct.jsp"><i class="fa-solid fa-plus"></i>Add New Product<span class="sr-only">(current)</span></a></li>
			<%-- <li class="nav-item mr-5"><a class="nav-link" href="<%=JavaView.ViewProductsServelts%>"><i class="fa-solid fa-border-all"></i>All Products</a></li> --%>
			<li class="nav-item mr-5"><a class="nav-link" href="AllProducts.jsp"><i class="fa-solid fa-border-all"></i>All Products</a></li>
			<li class="nav-item mr-5"><a class="nav-link" href="AllUserDetails.jsp"><i class="fa-solid fa-user"></i>Users</a></li>
			<li class="nav-item mr-5"><a class="nav-link" href="#"><i class="fa-solid fa-envelope"></i>Message Reviewed</a></li>
			<li class="nav-item mr-5"><a class="nav-link" href="#"><i class="fa-solid fa-list"></i>Orders Received</a></li>
			<li class="nav-item mr-5"><a class="nav-link" href="#"><i class="fa-solid fa-xmark"></i>Cancel Orders</a></li>
			<li class="nav-item"><a class="nav-link" href="#"><i class="fa-solid fa-truck"></i>Delivered Orders</a></li>
		</ul>
		
		<!-- <form class="form-inline my-2 my-lg-0 mr-5">
			<input class="form-control mr-sm-2 ml-3" type="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form> -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="btn my-2 my-sm-0" href="<%=JAVAView.logoutController%>"><i class="fa-solid fa-right-from-bracket"></i>Logout</a></li>
		</ul>
	</div>
</nav>