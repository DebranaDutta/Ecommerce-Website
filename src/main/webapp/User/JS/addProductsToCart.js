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
			if(data.trim()==='success'){
				 $("#toast").addClass("display");
				 setTimeout(() => {
				        $("#toast").removeClass("display");
				      }, 2000);
			}
		}
	});
}