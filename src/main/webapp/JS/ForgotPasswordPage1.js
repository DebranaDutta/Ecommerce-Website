$(document).ready(function() {
	$('#submitBtn').click(function() {
		var userName = $('#userName').val();
		var emailId = $('#emailId').val();
		console.log(userName, emailId);
		$.ajax({
			type : 'POST',
			url : 'forgotPasswordController1',
			data : {
				userName : userName,
				emailId : emailId
			}, 
			success:function(data, tetxtStatus, jqXHR){
				if(data.trim()==='success'){
					window.location='ForgotPasswordPage2.jsp'
				}else{
					swal("Invalid details").then((value)=>{
						window.location='login.jsp'
					});
				}
			},
			error:function(jqXHR, textStatus, errorThrown){
				
			}
		});
	});
});