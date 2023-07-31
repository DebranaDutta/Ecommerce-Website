$(document).ready(function() {
	$('.userDetails').click(function() {
		var userId = $(this).closest('.userGrid').find('.userId').val();
		var url="http://localhost:8080/E-commerceWebsite/getIndividualUserDetailsController"
		$.ajax({
			type:'POST',
			url:url,
			data:{
				userId:userId
			},
			success : function(data, tetxtStatus, jqXHR){
				
			}
		})
	})
});