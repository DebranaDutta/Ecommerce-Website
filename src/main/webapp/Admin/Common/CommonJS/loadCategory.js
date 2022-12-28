function getProductDetailsByCategory(catId) {
	$.ajax({
		url : "Common/loadProducts.jsp",
		data : {
			catId : catId
		},
		success : function(data, tetxtStatus, jqXHR) {
			$('#loader').hide();
			$('#loadProductContainer').html(data);
		}
	})
}
$(document).ready(function() {
	getProductDetailsByCategory(0);
})
