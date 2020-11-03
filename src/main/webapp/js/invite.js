var data;
function invitar() {
	if (validarCampo("correos")){
		var msg ={
            type : "invitacion",
			id : $("#idReunion").val(),
            correos: $("#correos").val()
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
	document.getElementById("correos").value="";
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