$(document).ready(function() {
	$.ajax({
		url:'Common/loadCategory.jsp',
		success: function(data, tetxtStatus, jqXHR){
			console.log(data);
			$('#loader').hide();
			$('#loadCategoryContainer').html(data);
		}
	});
});