<%@page import="com.ECW.Model.Category"%>
<%@page import="com.ECW.helper.CrudOperationsUsingHibernate"%>
<%@page import="com.ECW.Model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
List<Product> products = CrudOperationsUsingHibernate.getAllProductDetails();
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
		for(Product product:products){
		%>
		<div class="col-md-3 col-sm-6">
			<div class="product-grid">
				<div class="product-image">
					<a href=""><img class="pic-1" src="img/<%=product.getProductImage()%>" /></a>
					<ul class="social">
						<li><a href="" data-tip="Quick View"><i class="fa fa-search"></i></a></li>
						<li><a href="" data-tip="Edit product details"><i class="fa fa-edit"></i></a></li>
						<li><a href="" data-tip="remove product"><i class="fa fa-remove"></i></a></li>
					</ul>
				</div>
				<div class="product-content">
					<h3 class="title">
						<a href="#"><%=product.getProductName()%></a>
					</h3>
					<div class="price">INR : <%=product.getProductPrice()%></div>
					<a class="add-to-cart" href="">+ Add To Cart</a>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>
	<%-- <div class="row">
		<%
		for (Product product : products) {
		%>
		<div class="col-md-3 col-sm-4 text-center">
			<div class="card">
				<img class="card-img-top" src="img/<%=product.getProductImage()%>" alt="Card image cap">
				<div class="card-body">
					<a href=""><h6><%=product.getProductName()%></h6></a>
					<hr>
					<p class="card-text">
						Price:
						<%=product.getProductPrice()%></p>
					<div class="text-center" style="display: inline-block;">
						<a href="#" class="btn btn-primary mr-3">Edit</a> <a href="#" class="btn btn-primary ml-3">Delete</a>
					</div>

				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>
	<style>
		.card{
			margin-top: 10px;
		}
		.card .card-img-top{ 
			width: 100%;
			height: 50%;
		}
		.card .card-body a{
			text-decoration: none;
			color:  #6F7878;
		}
		.card .card-body a:hover{
			color: #2B3333;
			letter-spacing: 1px;
			transition: all 1s ease;
			text-shadow:  0 .5rem 1rem rgb(0, 0, 0, 0.5);
		}
		.card .card-body a h6{
			padding: 0;
			margin: 0;
		}
	</style> --%>
</body>
</html>