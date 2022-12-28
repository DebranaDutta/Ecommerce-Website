<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
List<Product> products = (ArrayList<Product>) session.getAttribute("productsByCategory");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
						<li><a href="#" data-tip="Add to Wishlist" class="editProduct"><i class="fa fa-shopping-bag"></i></a></li>
						<li><a href="" data-tip="Add to Cart" class="removeProduct"><i class="fa fa-shopping-cart"></i></a></li>
					</ul>
				</div>
				<div class="product-content">
					<h3 class="title">
						<a href="#"><%=product.getProductName()%></a>
						<input type="hidden" class="productId" value="<%=product.getProductId()%>">
					</h3>
					<div class="price">INR : <%=product.getProductPrice()%></div>
					<a class="buyNow" href="">+ Buy Now</a>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>