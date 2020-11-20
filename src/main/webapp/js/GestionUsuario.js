window.addEventListener('load', 
     function() { 
		getRol();
     }, false);

function getRol() {

	var data = {
		url : "getRol",
		type : "post",

		success : function(response) {
			var datos = JSON.parse(response);
			if (datos.rol != "admin")
				window.location="UserCalendar.html";
		},
		error : function(response) {
			alert("hay un error");
		}
	};
	$.ajax(data);
	
}
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
				var txt ="<tr><td><a href='javascript:mostrarUsuario(\""+usuario.user+"\");'>" + usuario.user + "</a></td></tr>";
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
	alert(usuario);
	
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