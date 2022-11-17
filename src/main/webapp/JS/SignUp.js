$(document).ready(function() {
	$('#registerBtn').click(function() {
		var fullName=$('#fullName').val();
		var userName=$('#userName').val();
		var email=$('#email').val();
		var phoneNumber=$('#phoneNumber').val();
		var password=$('#password').val();
		var cnfPassword=$('#cnfPassword').val();
		var securityQuestion=$('#securityQuestion').val();
		var answer=$('#answer').val();
		var gender=$('input[name = "gender"]:checked').val();
		if(password===cnfPassword){
			$.ajax({
				type:'POST',
				url:'userSignupController',
				data:{
					fullName:fullName,
					userName:userName,
					email:email,
					phoneNumber:phoneNumber,
					password:password,
					securityQuestion:securityQuestion,
					answer:answer,
					gender:gender
				},
				success: function(data, tetxtStatus, jqXHR){
					console.log(data);
					if(data.trim()==='success'){
						swal("Registration successful").then((value)=>{
							window.location='login.jsp'
						});
					}else{
						swal("Something went wrong!").then((value)=>{
							window.location='SignUp.jsp'
						});
					}
				},
				error : function(jqXHR, textStatus, errorThrown){
					swal("Something went wrong. Please try again");
				},
			});
		}else{
			swal("Password Mismatch");
		}
		
	});
});

/*
 * function getRegistrationDetails() { var fullName =
 * document.getElementById("fullName").value; var userName =
 * document.getElementById("userName").value; var email =
 * document.getElementById("email").value; var phoneNumber =
 * document.getElementById("phoneNumber").value; var password =
 * document.getElementById("password").value; var cnfPassword =
 * document.getElementById("cnfPassword").value; var securityQuestion =
 * document.getElementById("securityQuestion").value; var answer =
 * document.getElementById("answer").value; var gender =
 * document.querySelector('input[name = "gender"]:checked').value; console.log(
 * fullName, userName, email, password, phoneNumber, cnfPassword,
 * securityQuestion, answer, gender ); }
 */