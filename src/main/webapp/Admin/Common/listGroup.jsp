<%@page import="com.ECW.helper.JAVAView"%>
<div class="list-group">
	<a href="CategoryDetails.jsp" class="list-group-item">Show All Category</a> 
	<a href="ProductDetails.jsp" class="list-group-item">Show All Products</a> 
	<a href="AddNewCategory.jsp" class="list-group-item">Add New Category</a> 
	<a href="<%=JAVAView.getAllCategoryDetails%>" class="list-group-item">Add New Product</a>
	<style>
		.list-group a {
			margin-top: 2px; color : #6F7878;
			border: none;
			border-radius: 15px;
			color: #6F7878;
		}
		.list-group a:hover {
			letter-spacing: 1px;
			font-weight: 600;
			box-shadow: 0 .5rem 1rem rgb(0, 0, 0, 1);
			transition: all 1s ease;
			color: #2B3333;
			background: linear-gradient(100deg,#FFFFFF, #F0F7BF, #F7F0BF, #CFF5F4,  #A7F1A2, #A2A5F1, #E9A2F1);
		}
	</style>
</div>

