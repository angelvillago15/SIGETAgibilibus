var invitaciones = [];

function openNav() {
	document.getElementById("mySidenav").style.width = "270px";
	document.getElementById("main").style.marginLeft = "270px";
	document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
	getRol();
}

function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
	document.getElementById("main").style.marginLeft = "0";
	document.body.style.backgroundColor = "white";

}

function getRol() {

	var data = {
		url : "getRol",
		type : "post",

		success : function(response) {
			var datos = JSON.parse(response);
			if (datos.rol == "admin")
				$("#gestionUser").show();
			else
				$("#gestionUser").hide();

		},
		error : function(response) {
			alert("hay un error");
		}
	};
	$.ajax(data);
}

function getInvitaciones() {
	var data = {

		url : "recibirInvitacion",
		type : "post",

		success : function(response) {
			var datos = JSON.parse(response);
			
			invitaciones = datos.invitaciones;
			
			var cnt = datos.invitaciones.length;
			$('#cnt').text(cnt);

			var txt = "";

			for ( var i in datos.invitaciones) {
				var inv = datos.invitaciones[i];

				txt = txt + "<p><label>" + inv.reunion.organizador.nombre + "</label> te ha invitado a una reunión</p>"
					+ " <button type='button' class='btn btn-success' onclick='aceptarInvitacion("+i+")'>Aceptar</button>"
					+ " <button type='button' class='btn btn-danger' onclick='rechazarInvitacion("+i+")'>Rechazar</button>"
					+ " <br><div class='panel panel-info autocollapse'>"
					+ " <div class='panel-heading clickable'><h6 class='panel-title'>Quiero saber más</h6></div>"
					+ " <div class='panel-body'><div class='alert alert-info' role='alert'>"
					+ " - Título: <label>" + inv.reunion.title + "</label><br> - Descripción: <label>" + inv.reunion.descripcion + "</label><br>"
					+ " </div></div></div>";
			}
			document.getElementById('invitaciones').innerHTML = txt;
		},
		error : function(response) {
			alert(response.message);
		}
	};
	$.ajax(data);
}
getInvitaciones();


function aceptarInvitacion(i) {
            var info = {
                idInv : invitaciones[i].id,
                opcion : true
            };
            
            var data = {
                    data : JSON.stringify(info),
                    url : "responderInvitacion",
                    type : "post",
                    contentType: 'application/json',

                    success: function(response) {
                    	alert("Invitacion aceptada");
                    	location.reload();
                    },
                    error : function(response) {
                        alert(response.responseText);
                    }
                };
                $.ajax(data);
       
}

function rechazarInvitacion(i) {
            var info = {
                idInv : invitaciones[i].id,
                opcion : false
            };
            
            var data = {
                    data : JSON.stringify(info),
                    url : "responderInvitacion",
                    type : "post",
                    contentType: 'application/json',

                    success: function(response) {
                    	alert("Invitacion rechazada");
                    	location.reload();
                    },
                    error : function(response) {
                        alert(response.responseText);
                    }
                };
                $.ajax(data);
                
}


document.addEventListener('DOMContentLoaded', function() {

	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'timeGridWeek',
		nowIndicator : true,
		headerToolbar : {
			left : 'prev,next today',
			center : 'title',
			right : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
		},
		eventSources : [ {
			url : '/getReuniones',
			method : 'POST',
			failure : function() {
				alert('Hay un error cargando los eventos!');
			},

			editable : true,
			selectable : true
		} ],
		eventClick : function(event, jsEvent, view) {
			var msg = {
				type : "load Reunion",
				id : event.event._def.publicId,

			};
			var data = {
				data : JSON.stringify(msg),
				url : "loadReunion",
				type : "post",
				contentType : 'application/json',
				dataType : 'json',
				success : function(response) {					
					$('#nombreReunion').val(response.title);
					$('#descripcion').val(response.descripcion);
					$('#url').val(response.url);
					$('#fecha').val(response.fecha);
					$('#horaInicio').val(response.start);
					$('#horaFin').val(response.end);
					$('#idReunion').val(response.id);
					
					var organizador = response.organizador;
					var usuarioSesion=response.userSesion;
					
					if(organizador == usuarioSesion){
						document.getElementById("nombreReunion").readOnly = false;
						document.getElementById("url").readOnly = false;
						document.getElementById("fecha").readOnly = false;
						document.getElementById("horaInicio").readOnly = false;
						document.getElementById("horaFin").readOnly = false;
						document.getElementById("descripcion").readOnly = false;
					}

				},
				error : function(response) {
					alert(response.message);
				}

			}
			$.ajax(data);
			
			$('#modalTitle').text(event.title);
			$('#modalBody').text(event.description);
			$('#calendarModal').modal();

		},
		
		locale : 'es',
		navLinks : true, // can click day/week names to navigate views
		selectMirror : true,
		dayMaxEvents : true, // allow "more" link when too many events
	});

	calendar.render();
});



$(document).on('click', '.panel div.clickable', function(e) {
	var $this = $(this); // Heading
	var $panel = $this.parent('.panel');
	var $panel_body = $panel.children('.panel-body');
	var $display = $panel_body.css('display');

	if ($display == 'block') {
		$panel_body.slideUp();
	} else if ($display == 'none') {
		$panel_body.slideDown();
	}
});

$(document).ready(function(e) {
	var $classy = '.panel.autocollapse';
	var $found = $($classy);
	$found.find('.panel-body').hide();
	$found.removeClass($classy);
});