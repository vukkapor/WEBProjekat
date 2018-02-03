$(document).on('submit', '#regTerrForm', function(e)
{
	e.preventDefault();
	var terrInfo = {
		naziv : $('input#naziv').val(),
		povrsina : $('input#povrsina').val(),
		stanovnika : $('input#stanovnika').val()
	}
	
	console.log(terrInfo);

	$.ajax({
		type : 'POST',
		url : 'rest/users/registrujTeritoriju',
		dataType : 'json',
		data : JSON.stringify(terrInfo),
		contentType : 'application/json',
		success : function(data) {
			window.location.replace("profileAdmin.html");
		},
		error : function() { console.log("Error"); }
	});
});