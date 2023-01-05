/*$('#getCartDetails').click(function(){
	
});*/

function getCartDetails(userId) {
	var url = "http://localhost:8080/E-commerceWebsite/getCartDetails";
	$.ajax({
		type : 'POST',
		url : url,
		data : {
			userId : userId
		},
		success : function(data, tetxtStatus, jqXHR) {
			var carts = JSON.parse(data);
			$(".cart-items").html(`( ${carts.length } )`);
			let table=`
			<table class="table">
				<thead class="thead-light text-center">
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Date</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th>Action</th>
					</tr>
				</thead>
			`;
			let totalPrice = 0;
			carts.map((item)=>{
				table=table+`
				<tbody class="text-center">
					<tr>	
						<td>
							<div class="child">
								<img alt="" class="img-fluid" src="img/${item.productPic}">
							</div>
							<div class="child">${item.productName}</div>
						</td>
						<td>${item.productPrice}</td>
						<td>${item.date}</td>
						<td>
							<a href="#" class="mr-1"><i class="fa-solid fa-plus"></i></a>${item.productQuantity}<a href="#" class="ml-2"><i class="fa-solid fa-minus"></i></a>
						</td>
						<td>${item.productQuantity*item.productPrice}</td>
						<td><a href="#"><i class="fa-solid fa-trash-can"></i></a></td>
					</tr>
				</tbody>	
				`
				totalPrice=totalPrice+(item.productPrice*item.productQuantity);
			});
			table=table+`
			<tr><td colspan="5" class="text-right font-weight-bold m-5">Total Price : ${totalPrice}</td></tr>
			</table>`;
			$(".cart-body").html(table);		
		}
	});
}
$(document).ready(function() {
	console.log("page loaded");
	var userId=$('#userId').val();
	getCartDetails(userId);
});