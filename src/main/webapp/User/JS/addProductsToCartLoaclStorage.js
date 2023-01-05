//
function addToCart(productId, ProductName, ProductPrice) {
	let cart = localStorage.getItem("cart");
	if (cart == null) {
		// No cart is present yet
		let products = [];
		let product = {
			productId : productId,
			ProductName : ProductName,
			ProductPrice : ProductPrice,
			productQuantity : 1
		}
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
	} else {
		// cart is already present
		let	pcart = JSON.parse(cart);
		let oldProduct=pcart.find((item)=>item.productId==productId);
		if(oldProduct){
			// we have to increase the quantity
			oldProduct.productQuantity = oldProduct.productQuantity+1;	
			pcart.map((item)=>{
				if(item.productId==oldProduct.productId){
					item.productQuantity=oldProduct.productQuantity;
				}
			})
			localStorage.setItem("cart", JSON.stringify(pcart));	
		}else{
			// we have to add the product
			let product = {
				productId : productId,
				ProductName : ProductName,
				ProductPrice : ProductPrice,
				productQuantity : 1
			}
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart));		
		}
	}
	updateCart();
}

//update cart
function updateCart(){
	let cartString = localStorage.getItem("cart");
	let	cart = JSON.parse(cartString);
	if(cart==null || cart.length==0){
		console.log("Cart is empty");
		$(".cart-items").html("( 0 )");
		$(".cart-body").html("<h3>No items present</h3>");
		$(".checkout-btn").addClass('disabled');
	}else{
		$(".cart-items").html(`( ${cart.length } )`);
		let table=`
			<table class="table">
				<thead class="thead-light">
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th>Action</th>
					</tr>
				</thead>	
		`;
		cart.map((item)=>{
			table=table+`
				<tr>
					<td>${item.ProductName}</td>
					<td>${item.ProductPrice}</td>
					<td>${item.productQuantity}</td>
					<td>${item.productQuantity*item.ProductPrice}</td>
					<td><button class='btn btn-danger btn-sm'>Remove</button></td>
				</tr>
			`
		});
		table=table+`</table>`;
		$(".cart-body").html(table);
	}
}

$(document).ready(function() {
	updateCart();
});

