$('#saveDetails').click(function(){
	event.preventDefault();
	const form=document.getElementById('editProductForm');
	const formData=new FormData(form);
	var url="http://localhost:8080/E-commerceWebsite/updateProductDetailsController"
	
	$.ajax({
		type:'POST',
		url:url,
		data:formData,
		success: function(data, tetxtStatus, jqXHR){
			if(data.trim()==='success'){
				swal("Details updated successfully").then((value)=>{
					/*window.location='ProductAndCategoryDetails.jsp';*/
					window.location.reload();
				});
			}
		},
		error : function(jqXHR, textStatus, errorThrown){},
		processData:false,
		contentType:false
	});
});