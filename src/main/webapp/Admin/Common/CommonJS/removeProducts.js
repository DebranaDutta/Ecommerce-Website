$('.removeProduct').click(function(e) {
	e.preventDefault();
	var thisDeleteArea=$(this);
	var productId = $(this).closest('.product-grid').find('.productId').val();
	var productPic = $(this).closest('.product-grid').find('.productPic').val();
	var url = "http://localhost:8080/E-commerceWebsite/removeProductController"
	$.ajax({
		type : 'POST',
		url : url,
		data : {
			productId : productId,
			productPic : productPic
		},
		success : function(data, tetxtStatus, jqXHR) {
			window.location.reload();
			/*thisDeleteArea.closest('.product-grid').remove();*/
		}
	});
});