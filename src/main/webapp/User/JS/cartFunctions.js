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
			if(carts.length==0){
				$(".cart-body").html("<h3>Cart is empty</h3>");
				$(".cart-items").html(`( ${carts.length } )`);
				$(".checkout-btn").addClass('disabled');
			}else{
				let totalPrice = 0;
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
					carts.map((item)=>{
						table=table+`
						<tbody class="text-center">
							<tr>	
								<td>
									<div class="child"><img alt="" class="img-fluid" src="img/${item.productPic}"></div>
									<div class="child">${item.productName}</div>
								</td>
								<td>${item.productPrice}</td>
								<td>${item.date}</td>
								<td>
									<a href="#" class="mr-1" onClick='IncreaseDecreaseQuantity(${item.cartId}, ${item.productQuantity}, ${item.userId}, "increase")'><i class="fa-solid fa-plus"></i></a>${item.productQuantity}<a href="#" class="ml-2" onClick='IncreaseDecreaseQuantity(${item.cartId}, ${item.productQuantity}, ${item.userId}, "decrease")'><i class="fa-solid fa-minus"></i></a>
								</td>
								<td>${item.productQuantity*item.productPrice}</td>
								<td><a href="#" onClick='deleteItemFromCart(${item.cartId} , ${item.userId})'><i class="fa-solid fa-trash-can"></i></a></td>
							</tr>
						</tbody>
						`
						totalPrice=totalPrice+(item.productPrice*item.productQuantity);
					})
				table=table+`
					<tr>
						<td colspan="5" class="text-right font-weight-bold m-5">Total Price : ${totalPrice}</td>
					</tr>
				</table>`	
				$(".cart-body").html(table);
			}
		}
	});
}
function IncreaseDecreaseQuantity(cartId, quantity, userId, str){
	if(str==='increase'){
		quantity=quantity+1;
	}else if(str==='decrease'){
		quantity=quantity-1;
	}
	var url = "http://localhost:8080/E-commerceWebsite/IncreaseDecreaseController";
	$.ajax({
		url:url,
		type:'POST',
		data:{
			cartId:cartId,
			userId:userId,
			quantity:quantity,
		},
		success: function(data, tetxtStatus, jqXHR){
			var carts=JSON.parse(data);
			$(".cart-items").html(`( ${carts.length } )`);
			getCartDetails(userId);
		}
	});
}

function addToCart(productId, userId) {
	var url = "http://localhost:8080/E-commerceWebsite/AddProductsToCart";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			productId : productId,
			userId : userId
		},
		success: function(data, tetxtStatus, jqXHR){
			var response=data.split("|");
			var status=response[0];
			var carts=JSON.parse(response[1]);
			if(status.trim()==='success'){
				$("#toast").addClass("display");
				 setTimeout(() => {
				        $("#toast").removeClass("display");
				      }, 2000);
				 $(".cart-items").html(`( ${carts.length } )`);
				 getCartDetails(userId);
			}
		}
	});
}

function deleteItemFromCart(cartId, userId){
	var url = "http://localhost:8080/E-commerceWebsite/deleteFromCart";
	$.ajax({
		url:url,
		type:'POST',
		data:{
			cartId:cartId,
			userId:userId
		},
		success: function(data, tetxtStatus, jqXHR){			
				var carts=JSON.parse(data);
				$(".cart-items").html(`( ${carts.length } )`);
				getCartDetails(userId);
		}
	});
}

$(document).ready(function() {
	var userId=$('#userId').val();
	getCartDetails(userId);
});