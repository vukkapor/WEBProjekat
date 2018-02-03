$(document).on('submit', '#loginForma', function(e){
	
	var korisnicko = $("#korisnicko").val();
	var lozinka = $("#lozinka").val();
	
	var login = {
			korisnickoSlanje : korisnicko,
			lozinkaSlanje : lozinka			
	}
	console.log(login);

	$.ajax({
		type : 'POST',
		url : 'rest/users/login',
		dataType : 'json',
		data : JSON.stringify(login),
		contentType : 'application/json',
		success : function(data) {
			if(data != null) {
				localStorage.setItem("logovanKorisnik", JSON.stringify(data));
				window.location.replace("pocetna.html");
			}
			else
				alert("Pogresan user ili pw");
		},
		error : function() { console.log("Greska"); }
	});
});
