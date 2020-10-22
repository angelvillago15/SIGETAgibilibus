
  function getSemana () {
		var data = {

				url : "getSemana",
				type : "post",
				
				success : function(response) {

					for (var i=0; i<response.length; i++) {
					//se escribe el dia
					$("#d"+i).val(response[i].fecha);
						
						var reunion = response[i].reuniones;
						var html ="<table>";
						for (var j=0; j<reunion.length; j++) {
							html = html + "<tr><td>"+reunion[j].nombre+"</td></tr>";
						}
						html = html +"</table>"
						$("#ls"+i).val(html);

					}
				},
				error : function(response) {
					alert(response.message);
				}
			};
			$.ajax(data);
	}
	getSemana();
	
	function getSemanaSiguiente () {
		alert("siguiente");
		var data = {

				url : "getSemanaSiguiente",
				type : "post",
				
				success : function(response) {
					for (var i=0; i<response.length; i++) {
					jso = JSON.parse(response[i]);
					//se escribe el dia
					$("#d"+i).val(jso.fecha);
						
						var reunion = jso.reuniones;
						var html ="<table>";
						for (var j=0; j<reunion.length; j++) {
							html = html + "<tr><td>"+reunion[j].nombre+"</td></tr>";
						}
						html = html +"</table>"
						$("#ls"+i).val(html);

					}
				},
				error : function(response) {
					alert(response.message);
				}
			};
			$.ajax(data);
	}
	 function getSemanaAnterior () {
	 	alert("anterior");
		var data = {
				
				url : "getSemanaAnterior",
				type : "post",
				
				success : function(response) {
					for (var i=0; i<response.length; i++) {
					//se escribe el dia
					$("#d"+i).val(response[i].fecha);
						
						var reunion = response[i].reuniones;
						var html ="<table>";
						for (var j=0; j<reunion.length; j++) {
							html = html + "<tr><td>"+reunion[j].nombre+"</td></tr>";
						}
						html = html +"</table>"
						$("#ls"+i).val(html);

					}

				},
				error : function(response) {
					alert(response.message);
				}
			};
			$.ajax(data);
	}


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


