<%@page import="java.util.ArrayList"%>
<%@page import="com.ECW.Model.Cart"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="MyCartModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">My Cart</h5>
					<button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="cart-body"></div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-secondary" data-bs-dismiss="modal" style="color: white;">Close</a>
					<a class="btn btn-primary checkout-btn" style="color: white;" href="CheckoutPage.jsp">Checkout</a>
				</div>
			</div>
		</div>
	</div>
</body>
<style>
.child {
	display: inline-block;
}

.img-fluid {
	height: 50px;
}

.fa-plus {
	color: #737373;
}

.fa-plus:hover {
	color: #17A506;
}

.fa-minus {
	color: #737373;
}

.fa-minus:hover {
	color: #D34A38;
}

.fa-trash-can:hover {
	color: #FF0000;
}
</style>
</html>