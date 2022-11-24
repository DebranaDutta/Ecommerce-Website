$(document).ready(function() {
	$('#saveBtn').click(function() {
		var productName = document.getElementById("productName").value;
		var productPrice = document.getElementById("productPrice").value;
		var productCategory = document.getElementById("productCategory").value;
		var available = $('input[name="active"]:checked').val();
		$.ajax({
			type : 'POST',
			url : 'AddNewProductController',
			data : {
				productName : productName,
				productPrice : productPrice,
				productCategory : productCategory,
				available : available
			},
			success: function(data, tetxtStatus, jqXHR){
				if(data.trim()==='success'){
					swal("Product added successfully").then((value)=>{
						window.location='AdminHome.jsp';
					});
				}
			},
			error : function(jqXHR, textStatus, errorThrown){}
		});
	});
});