<%@page import="com.ECW.helper.JAVAView"%>
<div class="col-md-2">
<input type="checkbox" name="" id="toggler" />
<label for="toggler" class="fas fa-bars toggle-bar"></label>
<div class="list-group" id="listGroup">
	<a href="CategoryDetails.jsp" class="list-group-item">Show All Category</a>
	<a href="ProductDetails.jsp" class="list-group-item">Show All Products</a> 
	<a href="AddNewCategory.jsp" class="list-group-item">Add New Category</a> 
	<a href="<%=JAVAView.getAllCategoryDetails%>" class="list-group-item">Add new Product</a>
</div>
	<style>			
		.list-group{	
			text-align:center;
			position:fixed;	
			width: 12%;
			top:2;
			left:1;
			/* background: linear-gradient(100deg, #F0F7BF, #F7F0BF, #CFF5F4);  */
			background:#E5E7E9 ;
			box-shadow: 0 .2rem .2rem rgb(0, 0, 0, .5);
			border-radius: 10px;
		}	
		.list-group a {
			background:none;
			color : black ;
			font-weight:500;
			border: none;
		}
		.list-group .actv{
			background: #fff;
			box-shadow: 0 .2rem .2rem rgb(0, 0, 0, 1);
			color: black;
			font-weight:500;
			border-radius: 10px;
		}
		
		.list-group a:hover {
			letter-spacing: 1px;
			font-weight: 700;
			background:white;
			box-shadow: 0 .5rem 1rem rgb(0, 0, 0, 1);
			transition: all .5s ease;
			color: black;
			border-radius: 10px;
		}
		#toggler {
 		 	display: none;
		}
		.toggle-bar {
			position:absolute;
		  	font-size: 1rem;
		 	color: black;
		  	border-radius: 1rem;
		  	padding: 0.5rem 1.5rem;
		  	cursor: pointer;
		  	border: 0.1rem solid rgba(0, 0, 0, 0.3);
		}
		@media (max-width: 800px) {
			.list-group{
				left:-12%;
				transition: all 1s ease-in;
			}
		
			.toggle-bar{
				display: block;
				position: static;
			}
			#toggler:checked ~ .list-group{
				left:0;
				transition: all 1s ease-out;
				position:relative;
				width: 50%;
				margin:0;
				padding: 0;
			}
			
			#toggler:checked ~ .list-group a:hover{
				left:0;
				background:none;
				letter-spacing: 1px;
				font-weight: 700;
				background:white;
				box-shadow: 0 .5rem 1rem rgb(0, 0, 0, 1);
				transition: all .5s ease;
				color: black;
				border-radius: 10px;
			}
		};
		
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="Common/CommonJS/listGroup.js"></script> -->
</div>