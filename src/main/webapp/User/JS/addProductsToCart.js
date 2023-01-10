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
			}
			/*if(data.trim()==='success'){
				 $("#toast").addClass("display");
				 setTimeout(() => {
				        $("#toast").removeClass("display");
				      }, 2000);
				 $(".cart-items").html(`( ${carts.length } )`);
			}*/
		}
	});
}