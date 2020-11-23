$(document).ready(function() {
	var msg = {
			type : "get my account"
		};
		var data = {
			data : JSON.stringify(msg),
			url : "getMyAccount",
			type : "post",
			contentType : 'application/json',
			dataType : 'json',
			success : function(response) {
				document.getElementById("dni").innerHTML = response.dni;
				document.getElementById("nombre").innerHTML = response.nombre;
				document.getElementById("apellidos").innerHTML = response.apellidos;
				document.getElementById("telefono").innerHTML = response.telefono;
				document.getElementById("username").innerHTML = response.user;
				document.getElementById("mail").innerHTML = response.email;
				document.getElementById("rol").innerHTML = response.rol;
			},
			error : function(response) {
				alert(response.message);
			}
		}
		$.ajax(data);

	
});
