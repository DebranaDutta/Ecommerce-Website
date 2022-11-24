/*function getLoginDetails(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	
	var form=document.getElementById("loginForm");
	console.log(form);
	form.submit();
}*/
$(document).ready(function() {
	$('#loginBtn').click(function() {
		var userName = $("#userName").val();
		var password = $("#password").val();
		if(userName==="" || password===""){
			alert("Please fillup the required details!");
		}else{
			$.ajax({
				type : 'POST',
				url : 'userLoginController',
				data : {
					userName : userName,
					password : password
				},
				success : function(data, tetxtStatus, jqXHR) {
					if(data.trim()==='error'){
						swal("Invalid username or password").then((value)=>{
							window.location='login.jsp'
						});
					}else if(data.trim()==='success'){
						
						window.location='#'
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
	
				},
			});
		}	
	});
});