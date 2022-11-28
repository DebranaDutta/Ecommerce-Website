<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/AddNewProduct.css">
</head>
<body>
	<div class="container-fluid">
		<%@include file="Common/AdminNavbar.jsp"%>
	</div>
	<div class="container-fluid mt-3 main_cont">
		<div class="container">
			<div class="title">Add Product Details</div>
			<form action="#">
				<div class="product-details">
					<div class="input-box">
						<span class="details">Product Name</span>
						<input type="text" placeholder="Enter product name" id="productName" required />
					</div>
					<div class="input-box">
						<span class="details">Price</span>
						<input type="text" placeholder="Enter price" id="productPrice" required />
					</div>
					<div class="input-box">
						<span class="details">Product Category</span> <select name="productCategory" id="productCategory" class="select">
							<option value="Cloths">Cloths</option>
							<option value="Shoes">Shoes</option>
							<option value="Kitchen Essentials">Kitchen Essentials</option>
							<option value="Food">Food</option>
							<option value="Pet Supplies">Pet Supplies</option>
							<option value="Home Essential">Home Essential</option>
							<option value="Grocery">Grocery</option>
							<option value="Electronics">Electronics</option>
							<option value="Medicine">Medicine</option>
						</select>
					</div>
				</div>
				<div class="radio_field">
					<input type="radio" name="active" value="yes" id="dot-1" />
					<input type="radio" name="active" value="no" id="dot-2" />
					<span class="radio_field_title">Available</span>
					<div class="category">
						<label for="dot-1"> <span class="dot one"></span> <span class="active">Yes</span>
						</label> <label for="dot-2"> <span class="dot two"></span> <span class="active">No</span>
						</label>
					</div>
				</div>
				<div class="button">
					<input type="button" name="" value="Save" id="saveBtn" />
				</div>
			</form>
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
</body>
</html>