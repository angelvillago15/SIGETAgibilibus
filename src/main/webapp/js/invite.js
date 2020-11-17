var data;
function invitar() {
	if (validarCampo("correos")) {
		var msg = {
			type : "invitacion",
			id : $("#idReunion").val(),
			correos : $("#correos").val()
		};
		data = {
			data : JSON.stringify(msg),
			url : "nuevaInvitacion",
			type : "post",
			contentType : 'application/json',
			dataType : 'json'
		}

	}
	$.ajax(data);
	document.getElementById("correos").value = "";
	alert('Invitación enviada');
}

function validarCampo(campo) { // comprobar que no hay campos vacios
	var valido = new Boolean(true);
	if (document.getElementById(campo).value == '') {
		alert('El campo ' + campo + ' está vacio');
		valido = false;
	}
	return valido;
};

function modificar() {

	var msg = {
		type : "modificar Reunion",
		id : $("#idReunion").val(),
		nombre : $("#nombreReunion").val(),
		fecha : $("#fecha").val(),
		horaInicio : $("#horaInicio").val(),
		horaFin : $("#horaFin").val(),
		descripcion : $("#descripcion").val(),
		url : $("#url").val(),
		correos : $("#correos").val()
	};
	var data = {
		data2 : JSON.stringify(msg),
		url : "modificarReunion",
		type : "post",
		contentType : 'application/json',
		dataType : 'json'
	}

	$.ajax(data);
	document.getElementById("correos").value = "";
	alert('Se ha modificado la reunión');
};


function asistir() {
	var opcion = confirm("¿Estás seguro que no desea asisitir a esta reunión?");
	
	if (opcion == true) {
		var msg = {
			type : "eliminar Reunion",
			idReunion : $("#idReunion").val()
		};
		var data = {
			data : JSON.stringify(msg),
			url : "eliminarReunionUsuario",
			type : "post",
			contentType : 'application/json',
			dataType : 'json'
		}
		$.ajax(data);
		alert('Usted dejó de asistir a la reunión');
	} else {
		window.location.href = "UserCalendar.html";
	}

};
