<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Category</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/CategoryDetails.css">
</head>
<body>
	<div class="container-fluid">
		<%@include file="Common/AdminNavbar.jsp"%>
	</div>
	<div class="container-fluid mt-3">
		<div class="row">
			<!-- First COL -->
			<div class="col-md-2 text-center">
				<%@include file="Common/listGroup.jsp"%>
			</div>
			<!-- Second COL -->
			<div class="col-md-10">
				<div class="container-fluid main_cont">
					<div class="containerAdd">
						<div class="title">Add Category</div>
						<form action="#">
							<div class="category-details">
								<div class="input-box">
									<span class="details">Category Name</span>
									<input type="text" placeholder="Enter category name" id="categoryName" required="required" />
								</div>
								<div class="input-box">
									<span class="details">Category Details</span>
									<input type="text" placeholder="Enter category name" id="categoryDetails" required="required" />
								</div>
							</div>
							<div class="button">
								<input type="button" name="" value="Save" id="saveBtn" />
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
	<script type="text/javascript" src="JS/AddNewCategory.js"></script>
</body>
</html>