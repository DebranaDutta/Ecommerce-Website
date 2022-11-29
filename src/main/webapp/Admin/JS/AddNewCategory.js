$(document).ready(function() {
	$('#saveBtn').click(function() {
		var categoryName = document.getElementById("categoryName").value;
		var categoryDetails = document.getElementById("categoryDetails").value;
		console.log(categoryName, categoryDetails);
		var url="http://localhost:8080/E-commerceWebsite/AddNewCategoryController";
		$.ajax({
			type : 'POST',
			url : url,
			data : {
				categoryName : categoryName,
				categoryDetails : categoryDetails
			},
			success: function(data, tetxtStatus, jqXHR){
				if(data.trim()==='success'){
					swal("Category added successfully").then((value)=>{
						window.location='CategoryDetails.jsp';
					});
				}
			},
			error : function(jqXHR, textStatus, errorThrown){}
		});
	});
});