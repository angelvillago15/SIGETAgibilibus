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
				var txt ="<tr><td><a href='javascript:mostrarUsuario(\""+ datos.usuarios[i].user+"\");'>" + datos.usuarios[i].user + "</a></td></tr>";
				buscador.row.add([txt]);
			}
		},
		error: function(response) {
			alert(response.message);
		}
	};
	$.ajax(data);
}

function mostrarUsuario(username){
	var data = {
			data : JSON.stringify(msg),
			url: "loadUser",
			type: "post",
			contentType : 'application/json',
			dataType : 'json',

			success: function(response) {
				document.getElementById("userDni").innerHTML = response.dni;
				document.getElementById("userCompletName").value = $('#datos.nombre');
				document.getElementById("userApellidos").value = $('#datos.apellidos');
				document.getElementById("userTelf").value = ('#datos.telefono');
				document.getElementById("userDate").value = $('#datos.nacimiento');
			},
			error: function(response) {
				alert(response.message);
			}
		};
		$.ajax(data);
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