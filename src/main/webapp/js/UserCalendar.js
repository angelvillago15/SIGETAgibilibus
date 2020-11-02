function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
  document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
  document.body.style.backgroundColor = "white";
}

function getInvitaciones () {
		var data = {

				url : "recibirInvitacion",
				type : "post",
				
				success : function(response) {
					var datos =  JSON.parse(response);
					
					var cnt = datos.invitaciones.length;
					$('#cnt').text(cnt);
					    
					var txt ="";
					    
					for (i in datos.invitaciones) {
					 var inv = datos.invitaciones[i];
						txt = txt + "<p><label>"+ inv.reunion.organizador.nombre +"</label> te ha invitado a una reunión</p>"
						+" <button type='button' class='btn btn-success'>Aceptar</button>"
                        +" <button type='button' class='btn btn-danger'>Rechazar</button>"
						+" <br><div class='panel panel-info autocollapse'>"
                        +" <div class='panel-heading clickable'><h6 class='panel-title'>Quiero saber más</h6></div>"
                        +" <div class='panel-body'><div class='alert alert-info' role='alert'>"
                        +" - Título: <label>"+inv.reunion.titulo+"</label><br> - Descripción: <label>"+inv.reunion.descripcion+"</label><br>"
                        +" </div></div></div>";					
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

