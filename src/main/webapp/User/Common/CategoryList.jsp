<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.ECW.helper.CrudOperationsUsingHibernate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	List<Category> categories=(ArrayList<Category>)CrudOperationsUsingHibernate.getAllCategoryDetails();
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
				for(Category category:categories){
			%>
			<a href="#" class="list-group-item"><%=category.getCategoryName()%></a>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>