$('.list-group-item').click(function(){
	alert($(this).hasClass('actv'))
	$(this).removeClass('actv');
});