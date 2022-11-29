$(document).ready(function(){
	$.ajax({
		url:"Common/loadProducts.jsp",
		success: function(data, tetxtStatus, jqXHR){
			console.log(data);
			$('#loader').hide();
			$('#loadProductContainer').html(data);
		}
	});
});