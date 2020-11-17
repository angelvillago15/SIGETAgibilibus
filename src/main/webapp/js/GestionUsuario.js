var buscador = $("#table").DataTable();

$(document).ready(function() {
	
	$("#input-search").keyup(function() {
		buscador.search($(this).val()).draw();

		if ($("input-search").val() == "") {
			$(".content-search").fadeout();
		} else {
			$(".content-search").fadeIn();
		}
	}).focus(function() {
		$("#table").show();
	}).blur(function() {
		$("#table").hide(500);
	});
	getUsuarios();
});

function getUsuarios() {
	var data = {

		url: "getUsuarios",
		type: "post",

		success: function(response) {
			var datos = JSON.parse(response);
			
			for (var i in datos.usuarios) {
				var usuario = datos.usuarios[i];
				var txt ="<tr><td><a href='javascript:mostrarUsuario(\""+usuario+"\");'>" + usuario.user + "</a></td></tr>";
				buscador.row.add([txt]);
			}
		},
		error: function(response) {
			alert(response.message);
		}
	};
	$.ajax(data);
}

function mostrarUsuario(usuario){
	document.getElementById("userDni").value=usuario.dni;
	document.getElementById("userCompletName").value=usuario.nombre;
	document.getElementById("userApellidos").value=usuario.apellidos;
	document.getElementById("userTelf").value=usuario.telefono;
	document.getElementById("userDate").value=usuario.nacimiento;
	document.getElementById("userName").value=usuario;
	document.getElementById("pwd1").value=usuario.password;
	document.getElementById("userMail").value=usuario.email;	
}


function Delete() {
	var data;
	var msg = {
		type: "eliminar Usuario",
		id: document.getElementById("userName").value
	};
	data = {
		data: JSON.stringify(msg),
		url: "eliminarUsuario",
		type: "post",
		contentType: 'application/json',
		dataType: 'json'
	}
	$.ajax(data);
};