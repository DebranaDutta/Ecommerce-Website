<%@page import="com.ECW.Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
User user=(User) session.getAttribute("currentUser");
	if(user==null){
		session.setAttribute("message", "You are not loggedin!");
		response.sendRedirect(JAVAView.loginView);
		return;
	}
	//List<Cart> carts=(ArrayList<Cart>) session.getAttribute("carts");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
<!-- bootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!--Custom CSS only -->
<link rel="stylesheet" href="CSS/productCardDesignUser.css">
<link rel="stylesheet" href="CSS/cartFunctions.css">

</head>
<body>
	<%@include file="Common/UserHomePageNavbar.jsp"%>
	<%@include file="Common/CartModal.jsp"%>
	<div class="mt-2">
		<div class="row">
			<!-- First COL -->
			<%@include file="Common/CategoryList.jsp"%>
			<!-- Second COL -->
			<div class="col-md-10">
				<div class="container text-center" id="loader">
					<i class="fa-solid fa-rotate fa-4x fa-spin"></i>
					<h3 class="mt-2">Loading...</h3>
				</div>
				<div class="container-fluid" id="loadProductContainer"></div>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<!-- CustomScript -->
	<script type="text/javascript" src="JS/getProductsByCategory.js"></script>
	<script type="text/javascript" src="JS/cartFunctions.js"></script>
</body>
</html>