$('#save').click(function() {
	var emailId = document.getElementById("emailId").value;
	var phoneNo = $('#phoneNo').val();
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	var seqQs = document.getElementById("seqQs").value;
	var seqAns = document.getElementById("seqAns").value;
	console.log(phoneNo);
	var url = "http://localhost:8080/E-commerceWebsite/updateUserDetails";
	$.ajax({
		type : 'POST',
		url : url,
		data : {
			emailId : emailId,
			phoneNo : phoneNo,
			userName : userName,
			password : password,
			seqQs : seqQs,
			seqAns : seqAns
		},
		success : function(data, tetxtStatus, jqXHR){
			var response=data.split("|");
			var status=response[0];
			var user=JSON.parse(response[1]);
			if(status.trim()==='success'){
				swal("Updated successfully").then((value)=>{
					window.location='userDetails.jsp'
				});	
			}
		}
	});
});