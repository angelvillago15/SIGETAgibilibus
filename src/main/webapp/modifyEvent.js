function reunion () { // se le llama cuando se da al boton crear
	
	cargarFormulario();
	guardarReunion();
	alert('Se creó una reunion correctamente ');
	window.location.href = "UserCalendar.html";
  
};

function cargarFormulario(){
	document.getElementById("nombreReunion").value="";
    document.getElementById("fecha").value="";
    document.getElementById("horaInicio").value="";
    document.getElementById("horaFin").value="";
    document.getElementById("descripcion").value="";
    document.getElementById("url").value="";
    document.getElementById("invitar").value="";
};

function guardarReunion(){
	
};

