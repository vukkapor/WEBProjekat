function guestLogin() {
	$.ajax({
		type : 'POST',
		url : 'rest/users/guestLogin',
		success : function(data) {
			localStorage.setItem("loggedUser", JSON.stringify(data));
			window.location.replace("pocetna.html");
		}
	});
}
