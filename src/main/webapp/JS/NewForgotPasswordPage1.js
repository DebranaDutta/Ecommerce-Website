function validateUserName(){
	var userName=document.getElementById("userName").value;
	$.ajax({
		type:'POST',
		url:'UserNameVerificationCOntroller',
		data:{
			userName:userName,
		},
		success : function(data, tetxtStatus, jqXHR){
			var response=data.split(",");
			var status=response[0];
			var question=response[1];
			if(status.trim()==='success'){
				document.getElementById("enterQandS").removeAttribute("hidden");
				document.getElementById("question").textContent=question;
				document.getElementById("userName").readOnly=true;
				$('#userNameLabel').remove();
				if(question!==""){
					$('#submitBtn').click(function(){
						var answer=document.getElementById("answer").value;
						console.log(answer);
					});
				}
			}else if(status.trim()==='error'){
				swal('Invalid Username!').then((value)=>{
					window.location='NewForgotPasswordPage1.jsp';
				});
			}
			
		},
		error : function(jqXHR, textStatus, errorThrown){
			
		}
	});
}