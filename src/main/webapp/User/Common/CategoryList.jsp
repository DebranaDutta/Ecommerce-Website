<%@page import="com.ECW.helper.ConnectionProvider"%>
<%@page import="com.ECW.Category.Dao.CategoryDaoJDBC"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
//List<Category> categories = (ArrayList<Category>) CrudOperationsUsingHibernate.getAllCategoryDetails();
CategoryDaoJDBC categoryDao = new CategoryDaoJDBC(ConnectionProvider.getConnection());
List<Category> categories = categoryDao.getAllCategories();
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
			<a href="#" class="list-group-item" onclick="getProductByCategory(0)">All Products</a>
			<%
			for (Category category : categories) {
			%>
			<div class="categoryGrid">
				<a href="#" class="list-group-item" onclick="getProductByCategory(<%=category.getCategoryId()%>)"><%=category.getCategoryName()%></a>
			</div>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>