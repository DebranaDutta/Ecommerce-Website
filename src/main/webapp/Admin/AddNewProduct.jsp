<%@page import="com.ECW.Model.User"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Category"%>
<%@page import="java.util.List"%>
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
<%
List<Category> categories = (ArrayList<Category>) session.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Product</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/AddNewProduct.css">
<link rel="stylesheet" href="CSS/AddNewProduct2.css">
<link rel="stylesheet" href="CSS/commonCss/background.css">
</head>
<body>
	<%@include file="Common/AdminNavbar.jsp"%>
	<div class="container-fluid mt-3">
		<div class="row">
			<!-- First Colomn -->
			<%@include file="Common/listGroup.jsp"%>
			<!-- second colomn -->
			<div class="col-md-10">
				<div class="container-fluid mt-3 main_cont">
					<div class="container">
						<div class="title">Add Product Details</div>
						<form action="#" id="addProductForm" enctype="mutipart/form-data">
							<div class="product-details">
								<div class="input-box">
									<span class="details">Product Name</span>
									<input type="text" placeholder="Enter product name" name="productName" id="productName" required />
								</div>
								<div class="input-box">
									<span class="details">Price</span>
									<input type="text" placeholder="Enter price" name="productPrice" id="productPrice" required />
								</div>
								<div class="input-box">
									<span class="details">Product Category</span> <select name="productCategory" id="productCategory" class="select">
										<%
										for (Category category : categories) {
										%>
										<option value="<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
										<%
										}
										%>
									</select>
								</div>
								<div class="input-box">
									<span class="details">Upload image</span>
									<input type="file" id="productPic" name="productPic" />
									<label for="productPic" id="productPicLabel"><i class="fa-solid fa-upload" style="margin-right: 5px"></i>Choose a file...</label> <br /> 
									<span>
										<span id="productPicName" style="font-size: 12px">No file</span>
									</span>
								</div>
							</div>
							<div class="radio_field">
								<input type="radio" name="available" value="yes" id="dot-1" />
								<input type="radio" name="available" value="no" id="dot-2" />
								<span class="radio_field_title">Available</span>
								<div class="category">
									<label for="dot-1"> <span class="dot one"></span> <span class="available">Yes</span>
									</label> <label for="dot-2"> <span class="dot two"></span> <span class="available">No</span>
									</label>
								</div>
							</div>
							<div class="text-center button">
								<input type="submit" name="" value="Save" id="saveBtn" />
								<input type="submit" name="" value="Cancel" id="cancelBtn" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- BootStrap -->
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
	<script type="text/javascript" src="JS/AddNewProduct.js"></script>
	<script type="text/javascript" src="JS/AddNewProductUploadFile.js"></script>
</body>
</html>