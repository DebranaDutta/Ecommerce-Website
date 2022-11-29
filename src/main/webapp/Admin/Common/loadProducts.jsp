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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<%
		for (Product product : products) {
		%>
		<div class="col-md-3 mt-3 ml-3 text-center">
			<div class="card" style="width: 15rem;">
				<img class="card-img-top" src="img/img1.png" alt="Card image cap">
				<div class="card-body">

					<a href=""><h5 class="card-title"><%=product.getProductName()%></h5></a>
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
</body>
</html>