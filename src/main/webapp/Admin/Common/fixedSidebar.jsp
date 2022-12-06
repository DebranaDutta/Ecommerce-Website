<%@page import="com.ECW.helper.JAVAView"%>
<div class="col-md-2">
	<div class="sidebar bg-light">
		<ul class="nav">
			<li><a href=""> <i class="fa-solid fa-bars"></i><span>Show All Category</span></a></li>
			<li><a href=""> <i class="fa-solid fa-bell-concierge"></i><span>Show All Products</span></a></li>
			<li><a href=""> <i class="fa-solid fa-calendar-days"></i><span>Add New Category</span></a></li>
			<li><a href="<%=JAVAView.getAllCategoryDetails%>"> <i class="fa-solid fa-gear"></i><span>Add New Product</span></a></li>
		</ul>
	</div>
	<style>
.col-md-2 .sidebar {
	position: fixed;
	width: 200px;
	height: 50%;
	top: 14%;
	bottom: 30%; left : 0;
	z-index: 1;
	left: .5%;
}

.sidebar ul li i {
	margin-right: 15px;
}

.sidebar ul li {
	margin: 5px;
}

.sidebar ul li a {
	color: black;
	padding: 0;
}

.sidebar ul li a:hover {
	color: #000;
	margin-left: 20px;
	transition: all 0.5s ease;
}
</style>
</div>