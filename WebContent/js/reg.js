$(document).ready(function() {
	$.ajax({
		type : 'GET',
		url : 'rest/users/getTeritorije',
		success : function(data) {
			var keys = Object.keys(data.teritorije);
			var territoryList = $("#teritorijaLista");
			for(var i = 0; i < keys.length; i++)
				territoryList.append("<option value=\"" + keys[i] + "\">" + keys[i] + "</option>");
		}
	});
});
var korisnicko1 = $("#korisnicko").val();
var lozinka1 = $("#lozinka").val();

var login = {
		korisnicko : korisnicko1,
		lozinkaSlanje : lozinka1			
}
function register() {
	var user = {
			email : $('input#email').val(),
			korisnicko : $('input#korisnicko').val(),
			lozinka : $('input#lozinka').val(),
			ime : $('input#ime').val(),
			prezime : $('input#prezime').val(),
			telefon : $('input#telefon').val(),
			teritorija : $('#teritorijaLista').val()
	}
	
	
	$.ajax({
		type : 'POST',
		url : 'rest/users/register',
		contentType : 'application/json',
		dataType : 'json',
		data : JSON.stringify(user),
		success : function(data) {
			if(data) {
				var file = $("#slika")[0].files[0];
				uploadImage(file);
				window.location.replace("login.html");
			}
			else
				alert("Korisnik vec postoji!");
		}
	});
};

function uploadImage(file) {
	$.ajax({
        type : 'POST',
		url : 'rest/users/uploadImage',
        contentType : "multipart/form-data",
        data : file,
        processData : false
	}); 
}