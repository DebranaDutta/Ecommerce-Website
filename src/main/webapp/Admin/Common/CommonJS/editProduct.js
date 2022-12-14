$(document).ready(function(){
	$(document).on('click','.editProduct', function(){
		var productId = $(this).closest('.product-grid').find('.productId').val();
		$('#editProductDetails').modal('show');
		var url = "http://localhost:8080/E-commerceWebsite/getIndividualProductDetailsController"
		$.ajax({
			type:'POST',
			url:url,
			data:{
				productId : productId
			},
			success : function(data, tetxtStatus, jqXHR){
				var obj=JSON.parse(data);
				console.log(obj);
				$('#productName').val(obj.productName);
				$('#productPrice').val(obj.productPrice);
				$('#productCategory').val(obj.productCategory);
				/*var product=$.parseJSON(data);
				alert(product.productId);*/
			}
		});
	});
});