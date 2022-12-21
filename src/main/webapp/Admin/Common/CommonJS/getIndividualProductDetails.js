$(document).ready(function(){
	$(document).on('click','.editProduct', function(){
		var productId = $(this).closest('.product-grid').find('.productId').val();
		$('#editProductDetails').modal('show');
		
		var newProductPic=$('#productPic').val();
		if(newProductPic!==''){
			newProductPic='';
			$('#productPic').val(newProductPic);
			document.getElementById('newProductPicName').textContent='no new file is selected';
		}
		
		var url = "http://localhost:8080/E-commerceWebsite/getIndividualProductDetailsController";
			
		$.ajax({
			type:'POST',
			url:url,
			data:{
				productId : productId
			},
			success : function(data, tetxtStatus, jqXHR){
				var obj=JSON.parse(data);
				console.log(obj);
				$('#spanProdId').val(obj.productId);
				$('#productName').val(obj.productName);
				$('#productPrice').val(obj.productPrice);
				$('#productCategory').val(obj.productCategory);
				if(obj.productAvailability==='yes'){
					$('#dot-1').prop('checked',true);
				}else{
					$('#dot-2').prop('checked',true);
				}
				$('#oldProductPicName').val(obj.productImage);
				/*var product=$.parseJSON(data);
				alert(product.productId);*/
				$('#oldProductPic').val(obj.productImage);
				$('#productId').val(obj.productId);
			}
		});
	});
});