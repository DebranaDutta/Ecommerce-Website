$('.list-group-item').click(function() {
	var catId = $(this).closest('.categoryGrid').find('.catId').val();
	var url = "http://localhost:8080/E-commerceWebsite/getProductsByCategoryController";
	$.ajax({
		type : 'POST',
		url : url,
		data:{
			catId:catId
		},
		success : function(data, tetxtStatus, jqXHR){
			$.ajax({
				url:"Common/loadProductsByCategory.jsp",
				success: function(data, tetxtStatus, jqXHR){
					$('#loader').hide();
					$('#loadProductContainer').html(data);
				}
			});
		}
	});
});