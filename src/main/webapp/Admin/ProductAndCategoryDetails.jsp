<%@page import="com.ECW.Model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.helper.CrudOperationsUsingHibernate"%>
<%@page import="com.ECW.helper.JAVAView"%>
<%@page import="com.ECW.Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Details Page2</title>
</head>
<body>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="CSS/commonCss/background.css">
	<link rel="stylesheet" href="CSS/commonCss/listGroup2.css">
	<link rel="stylesheet" href="CSS/commonCss/productCardDesignAdmin.css">
	<link rel="stylesheet" href="CSS/commonCss/productEditModal.css">
</head>
<body>
	<%@include file="Common/AdminNavbar.jsp"%>
	<div class="container-fluid mt-3">
		<div class="row">
			<!-- First COL -->
			<%@include file="Common/loadCategory2.jsp"%>
			<!-- Second COL -->
			<div class="col-md-10">
				<div class="container text-center" id="loader">
					<i class="fa-solid fa-rotate fa-4x fa-spin"></i>
					<h3 class="mt-2">Loading...</h3>
				</div>
				<div class="container-fluid" id="loadProductContainer">
					
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<!-- FontAwsome -->
	<script src="https://kit.fontawesome.com/400552a932.js" crossorigin="anonymous"></script>
	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- Sweetalert -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<!-- CustomScript -->
	<!-- <script type="text/javascript" src="Common/CommonJS/ProductDetailsByCategory.js"></script> -->
	<script type="text/javascript" src="Common/CommonJS/loadCategory.js"></script>
</body>
</html>
</body>
</html>