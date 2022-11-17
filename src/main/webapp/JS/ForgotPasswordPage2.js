$(document).ready(function() {
	$('#submitBtn').click(function() {
		var newPassword = $('#newPassword').val();
		var confirmPassword = $('#confirmPassword').val();
		if (newPassword === confirmPassword) {
			$.ajax({
				type : 'POST',
				url : 'forgotPasswordController2',
				data : {
					newPassword : newPassword,
				},
				success : function(data, tetxtStatus, jqXHR) {
					alert(data);
				},
				error : function(jqXHR, textStatus, errorThrown) {

				}
			});
		}else{
			alert("Password mismatch. Please check again!")
		}
	});
});