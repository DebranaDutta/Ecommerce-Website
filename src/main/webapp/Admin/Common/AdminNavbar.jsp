<%@page import="com.ECW.helper.JAVAView"%>
<div class="sticky-top" style="margin-bottom: 15px; box-shadow: 0 3px 20px rgba(0, 0, 0, 0.5); ">
	<nav class="navbar navbar-expand-lg">
		<a class="navbar-brand" href="AdminHome.jsp"><b>Welcome to Admin</b></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"><i class="fa-solid fa-list mt-1" style="color:white; font-size: 20px;"></i></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="CategoryDetails.jsp"><i class="fa-solid fa-bars"></i>Category & Products</a></li>
				<li class="nav-item"><a class="nav-link" href="AllUserDetails.jsp"><i class="fa-solid fa-user"></i>Users</a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fa-solid fa-envelope"></i>Message Reviewed</a></li>
				<li class="nav-item"><a class="nav-link" href="ReceivedOrders.jsp"><i class="fa-solid fa-list"></i>Orders Received</a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fa-solid fa-xmark"></i>Cancel Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fa-solid fa-truck"></i>Delivered Orders</a></li>
			</ul>
			<ul class="" style="margin-top: 15px;">
				<a class="" href="<%=JAVAView.logoutController%>" style="color: white;"><i class="fa-solid fa-right-from-bracket"></i>Logout</a>
			</ul>
		</div>
	</nav>
	<style>
	.navbar{
		background: #474443;
		height: 40px;
		
	}
	.navbar-brand{
		font-family: cursive;
		font-size: 17px;
		color: white;
	}
	.navbar-brand:hover{
		color: white;
	}
	.nav-item{
		margin-left: 20px;
		margin-right: 20px;
	}
	.nav-link{
		font-size: 14px;
		color: #EFEFEF;
	}
	.nav-link:hover{
		font-size: 14px;
		color: #EFEFEF;
	}
	.fa-solid{
		margin-right: 3px;
	}
	</style>
</div>
