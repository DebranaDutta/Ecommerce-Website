<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Category"%>
<%@page import="com.ECW.helper.CrudOperationsUsingHibernate"%>
<%@page import="com.ECW.Model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
List<Product> products = CrudOperationsUsingHibernate.getAllProductDetails();
List<Category> categories = CrudOperationsUsingHibernate.getAllCategoryDetails();
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<%
		for (Product product : products) {
		%>
		<div class="col-md-3 col-sm-6">
			<div class="product-grid">
				<div class="product-image">
					<a href=""><img class="pic-1" src="img/<%=product.getProductImage()%>" /></a>
					<ul class="social">
						<li><a href="" data-tip="Quick View"><i class="fa fa-search"></i></a></li>
						<li><a href="#" data-tip="Edit product details" class="editProduct"><i class="fa fa-edit"></i></a></li>
						<li><a href="" data-tip="remove product" class="removeProduct"><i class="fa fa-remove"></i></a></li>
					</ul>
				</div>
				<div class="product-content">
					<h3 class="title">
						<a href="#"><%=product.getProductName()%></a>
						<input type="hidden" class="productId" value="<%=product.getProductId()%>">
						<input type="hidden" class="productPic" value="<%=product.getProductImage()%>">
					</h3>
					<div class="price">
						INR :
						<%=product.getProductPrice()%></div>
					<a class="add-to-cart">Product Id: <%=product.getProductId()%></a>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>
	
	
	<!-- Start of Edit Product MODAL -->
	<div class="modal fade" id="editProductDetails" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Product ID : <input value="" id="spanProdId" type="text" disabled="disabled"> </h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="#" id="editProductForm" enctype="mutipart/form-data">
						<input	type="text" name="productId" id="productId">
						<input	type="text" name="oldProductPic" id="oldProductPic">
						<div class="product-details">
							<div class="input-box">
								<span class="details">Product Name</span>
								<input type="text" value="" name="productName" id="productName">
							</div>
							<div class="input-box">
								<span class="details">Product Price</span>
								<input type="text" value="" name="productPrice" id="productPrice">
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
								<span class="details">Update image:</span>
								<input type="file" id="productPic" name="productPic" />
								<label for="productPic" id="productPicLabel"><i class="fa-solid fa-upload" style="margin-right: 5px"></i>Choose a file...</label> 
								<br /> 
								<span>
									<span id="newProductPicName">no new file is selected</span><br/>
									<span>Old file: </span> 
									<input type="text" value="" id="oldProductPicName" name="oldProductPicName" disabled="disabled">
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
						<div class="modal-footer text-center">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary" id="saveDetails">Save changes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- End of Edit Product MODAL -->

	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- BootStrap -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<!-- FontAwsome -->
	<script src="https://kit.fontawesome.com/400552a932.js" crossorigin="anonymous"></script>	
	<!-- Sweetalert -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script> -->
	<!-- CustomScript -->
	<script type="text/javascript" src="Common/CommonJS/removeProducts.js"></script>
	<script type="text/javascript" src="Common/CommonJS/getIndividualProductDetails.js"></script>
	<script type="text/javascript" src="Common/CommonJS/NewProductPicUpload.js"></script>
	<script type="text/javascript" src="Common/CommonJS/loadUpdatedDetails.js"></script>
</body>
</html>