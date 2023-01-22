function deleteData(id){
	var userId=$('#userId').val();
	var url = "http://localhost:8080/E-commerceWebsite/removeAddressController";
	$(document).ready(function(){
		Swal.fire({
			  title: 'Are you sure?',
			  text: "You won't be able to revert this!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes, delete it!'
			}).then((result) => {
			  if (result.isConfirmed) {
				  $.ajax({
					 type:'POST',
					 url:url,
					 data:{
						 addressId:id,
						 userId:userId
					 },
					 success : function(data, tetxtStatus, jqXHR){
						 if(data.trim()==='success'){
							 Swal.fire(
								      'Deleted!',
								      'Your file has been deleted.',
								      'success'
								    );
							 document.getElementById(id).style.display="none";
						 }
					 }
				  });
			    
			  }
			});
	});
}



$('#saveId').click(function(){
	var addressLine1= $('#addressLine1').val();
	var addressLine2= $('#addressLine2').val();
	var city= $('#city').val();
	var state= $('#state').val();
	var zip= $('#zip').val();
	var userId=$('#userId').val();
	var url = "http://localhost:8080/E-commerceWebsite/addNewAddressController";
	if( addressLine1=='' || city=='' || state=='' || zip=='' ){
		swal({
			title: "Some Fields Are Empty",
			text:"Please fill all mandatory details",
			icon:"warning",
			button:"ok"
		});
	}else{
		$.ajax({
			type:'POST',
			url:url,
			data:{
				addressLine1:addressLine1,
				addressLine2:addressLine2,
				city:city,
				state:state,
				zip:zip,
				userId:userId
			},
			success : function(data, tetxtStatus, jqXHR){
				console.log(data);
				if(data.trim()==='success'){
					console.log(data);
						/*
						 * $("#toast").addClass("display"); setTimeout(() => {
						 * $("#toast").removeClass("display"); }, 2000);
						 * window.location='viewAddressDetails.jsp';
						 */
					
						/*
						 * swal({ title:"Hello", type:"info", showConfirmButton:
						 * true, confirmButtonText: "Ok", closeOnConfirm: true
						 * });
						 */
					 
					swal("Address added successfully").then((value)=>{
						window.location='viewAddressDetails.jsp';
					});	
				}
			},
		});
	}	
});
