$('.removeProduct').click(function(e) {
	e.preventDefault();
	var thisDeleteArea=$(this);
	var productId = $(this).closest('.product-grid').find('.productId').val();
	var url = "http://localhost:8080/E-commerceWebsite/removeProductController"
	$.ajax({
		type : 'POST',
		url : url,
		data : {
			productId : productId
		},
		success : function(data, tetxtStatus, jqXHR) {
			window.location.reload();
			/*thisDeleteArea.closest('.product-grid').remove();*/
		}
	});
});