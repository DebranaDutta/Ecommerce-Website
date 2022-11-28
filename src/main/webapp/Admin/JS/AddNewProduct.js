$(document).ready(function() {
	/*var url="http://localhost:8080/E-commerceWebsite/getAllCategoryDetails";
	$.ajax({
		type:'POST',
		url:url
	});*/
	/*$('#productCategory').click(function(){
		console.log("clicked");
		var url="http://localhost:8080/E-commerceWebsite/getAllCategoryDetails";
		
	});*/
	
	$('#saveBtn').click(function() {
		var productName = document.getElementById("productName").value;
		var productPrice = document.getElementById("productPrice").value;
		var productCategory = document.getElementById("productCategory").value;
		var available = $('input[name="active"]:checked').val();
		console.log(productName, productPrice, productCategory, available)
		var url="http://localhost:8080/E-commerceWebsite/AddNewProductController";
		$.ajax({
			type : 'POST',
			url : url,
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