function getProductByCategory(catId) {
	$.ajax({
		url : "Common/loadProductsByCategory.jsp",
		data : {
			catId : catId
		},
		success : function(data, tetxtStatus, jqXHR) {
			$('#loader').hide();
			$('#loadProductContainer').html(data);
		}
	});
}

$(document).ready(function() {
	getProductByCategory(0);
});
