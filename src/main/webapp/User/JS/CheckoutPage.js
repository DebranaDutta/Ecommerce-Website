$(document).ready(function(){
	$('#paymentMethod').hide();
	$('#checkoutBtn').hide();
	$('input[name="addressDetails"]').change(function(){
		$('#paymentMethod').show("slow");
		
		$('#cardIcons').hide();
		$('#netBankinglist').hide();
		$('#upiIdDetails').hide();
		$('#codLabel').hide();
		$('#checkoutBtn').show("slow");
		
		$('#payWithCard').change(function(){
			if($(this).is(":checked")){
				$('#cardIcons').show("slow");
				$('#netBankinglist').hide("slow");
				$('#upiIdDetails').hide("slow");
				$('#codLabel').hide("slow");
			}
		});
		$('#netBanking').change(function(){
			if($(this).is(":checked")){
				$('#cardIcons').hide("slow");
				$('#netBankinglist').show("slow");
				$('#upiIdDetails').hide("slow");
				$('#codLabel').hide("slow");
			}
		});
		$('#upi').change(function(){
			if($(this).is(":checked")){
				$('#cardIcons').hide("slow");
				$('#netBankinglist').hide("slow");
				$('#upiIdDetails').show("slow");
				$('#codLabel').hide("slow");
			}
		});
		$('#cod').change(function(){
			if($(this).is(":checked")){
				$('#cardIcons').hide("slow");
				$('#netBankinglist').hide("slow");
				$('#upiIdDetails').hide("slow");
				$('#codLabel').show("slow");
			}
		});
		
	});
	
	$('#checkoutBtn').click(function(){
		var addressId = $('input[name="addressDetails"]:checked').val(); 
		var mop=$('input[name="payment"]:checked').val();
		var cartIds=$('#cartIds').val();
		var productIds=$('#productIds').val();
		var userId=$('#userId').val();
		var totalPrice=$('#totalPrice').val();
		var url = "http://localhost:8080/E-commerceWebsite/CheckoutController";
		$.ajax({
			type:'POST',
			url: url,
			data: {
				addressId:addressId,
				mop:mop,
				cartIds:cartIds,
				productIds:productIds,
				userId:userId,
				totalPrice:totalPrice
			},
			success : function(data, tetxtStatus, jqXHR){
				if(data.trim()==='success'){
					swal("Order placed successfully").then((value)=>{
						window.location='UserOrderDetails.jsp';
						
					});
				}
			}
		});
	});
});