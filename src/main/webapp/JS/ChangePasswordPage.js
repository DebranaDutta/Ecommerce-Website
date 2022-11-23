$(document).ready(function() {
	$('#submitBtn').click(function() {
		var newPassword = $('#newPassword').val();
		var confirmPassword = $('#confirmPassword').val();
		var userName = localStorage.getItem("userName");
		if (newPassword === confirmPassword) {
			$.ajax({
				type : 'POST',
				url : 'changePasswordController',
				data : {
					newPassword : newPassword,
					userName : userName
				},
				success : function(data, tetxtStatus, jqXHR) {
					if(data.trim()==='success'){
						swal('Password changed successfully').then((value)=>{
							window.location='login.jsp';
						});
					}else if(data.trim()==='error'){
						swal('Something went wrong. PLease try again').then((value)=>{
							window.location='ForgotPasswordPage.jsp';
						});
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {

				}
			});
		} else {
			alert("Password mismatch. Please check again!")
		}
	});
});