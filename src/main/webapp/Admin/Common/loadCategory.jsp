<%@page import="com.ECW.helper.CrudOperationsUsingHibernate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Category"%>
<%@page import="java.util.List"%>
<%
/* List<Category> categories = (ArrayList<Category>) session.getAttribute("categories"); */
List<Category> categories= CrudOperationsUsingHibernate.getAllCategoryDetails();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/loadCategory.css">
</head>
<body>
	<div class="row">
	<%
		for(Category category:categories){
	%>
		<div class="col-md-3 mt-3 text-center">
			<div class="card">
				<div class="card-body">
					<a id="catName" class="card-title" href="#"><%=category.getCategoryName()%></a>
				</div>
			</div>
		</div>
	<%
		}
	%>	
	</div>
</body>
</html>
