<%@page import="com.ECW.helper.ConnectionProvider"%>
<%@page import="com.ECW.Dao.CategoryDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.helper.CrudOperationsUsingHibernate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
List<Category> categories = (ArrayList<Category>) CrudOperationsUsingHibernate.getAllCategoryDetails();
/* CategoryDao categoryDao = new CategoryDao(ConnectionProvider.getConnection());
List<Category> categories = categoryDao.getAllCategories(); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/CategoryList.css" />
</head>
<body>
	<div class="col-md-2">
		<div class="list-group text-center bg-light">
			<%
			for (Category category : categories) {
			%>
			<div class="categoryGrid">
				<a href="#" onclick="getProductDetailsByCategory(<%=category.getCategoryId()%>)" class="list-group-item"><%=category.getCategoryName()%></a>
				<input type="hidden" id="catId" value="<%=category.getCategoryId()%>">
				<%-- <input type="hidden" value="<%=user.getUserType()%>"> --%>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>