<%@page import="java.util.List"%>
<%@page import="com.ECW.User.Dao.UserDaoHibernate"%>
<%@page import="com.ECW.helper.JAVAView"%>
<%@page import="com.ECW.Model.User"%>
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
	session.setAttribute("message", "You are not loggedin!");
	response.sendRedirect(JAVAView.loginView);
	return;
} else {
	if (user.getUserType().equalsIgnoreCase("normal")) {
		session.setAttribute("message", "You are not autorized access this portal");
		response.sendRedirect("login.jsp");
		return;
	}
}
List<User> users = UserDaoHibernate.getAllUsers();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users Details</title>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	rel="stylesheet"
	href="CSS/commonCss/background.css">
<link
	rel="stylesheet"
	href="CSS/AllUserDetails.css">
</head>
<body>
	<%@include file="Common/AdminNavbar.jsp"%>
	<div class="container-fluid mt-3">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Full Name</th>
					<th scope="col">User Name</th>
					<th scope="col">Email</th>
					<th scope="col">Contact No</th>
					<th scope="col">User Type</th>
					<th scope="col">Gender</th>
					<th scope="col">Profile Creation Date</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (User u : users) {
					if (!(u.getUserName().equalsIgnoreCase("Admin"))) {
				%>

				<tr class="userGrid">
					<td><a
						href="#"
						class="userDetails"><%=u.getFullName()%></a></td>
					<input
						type="hidden"
						class="userId"
						value="<%=u.getPhoneNumber()%>">
					<td><%=u.getUserName()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getPhoneNumber()%></td>
					<td><%=u.getUserType()%></td>
					<td><%=u.getGender()%></td>
					<td><%=u.getDate()%></td>
				</tr>

				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
	<!-- BootStrap -->
	<script
		src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<!-- FontAwsome -->
	<script
		src="https://kit.fontawesome.com/400552a932.js"
		crossorigin="anonymous"></script>
	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- Sweetalert -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<!-- CustomScript -->
	<script
		type="text/javascript"
		src="JS/AllUserDetails.js"></script>
</body>
</html>