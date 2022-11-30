$(document).ready(function(){
	console.log('loaded');
	$('#addProductForm').on('submit',function(event){
		event.preventDefault();
		//var formData=$(this).serialize();-> use only if form contains textdata
		var formData=new FormData(this);
		var url="http://localhost:8080/E-commerceWebsite/AddNewProductController";
		$.ajax({
			type:'POST',
			url:url,
			data:formData,
			success: function(data, tetxtStatus, jqXHR){
				if(data.trim()==='success'){
					swal("Product added successfully").then((value)=>{
						window.location='ProductDetails.jsp';
					});
				}
			},
			error : function(jqXHR, textStatus, errorThrown){},
			processData:false,
			contentType:false
		});
	})
});