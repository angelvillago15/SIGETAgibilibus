function invitar () { // se le llama cuando se da al boton Invitar
	
		var reunion= new Reunion($("#nombreReunion").val(),$("#fecha").val(),$("#horaInicio").val(),$("#horaFin").val(),$("#descripcion").val(),$("#url").val(),$("#invitar").val()); //obtenemos un objeto 
		guardarReunion();
		alert('Se creó una reunion correctamente ');
	
	window.location.href = "UserCalendar.html";
};

function Cancelar(){
	window.location.href = "UserCalendar.html";
};

function loadEvento() {
	var data = {

		url : "loadEvento",
		type : "post",
		
		success : function(response) {
		
			document.getElementById("nombreReunion").value=response.nombre;
			document.getElementById("fecha").value=response.fecha;
			document.getElementById("horaInicio").value=response.horaInicio;
			document.getElementById("horaFin").value=response.horaFin;
			document.getElementById("descripcion").value=response.descripcion;
			document.getElementById("url").value=response.url;
			document.getElementById("invitar").value=response.invitar;
		}
	};
};



class Reunion{
    constructor(nombre, fecha, horaInicio, horaFin, descripcion, url,correos){
    	this.nombre=nombre;
        this.fecha=fecha;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.descripcion=descripcion;
        this.url=url;
        this.correos=correos;
    }

    guardarReunion(){
        var msg ={
            type : "guardar Reunion",
			nombre : this.nombre,
			fecha : this.fecha,
            horaInicio : this.horaInicio,
			horaFin : this.horaFin,
            descripcion : this.descripcion,
            url: this.url,
            correos: this.correos
        };
        var data = {
            data : JSON.stringify(msg),
            url : "guardarReunion",
            type : "post",
            contentType : 'application/json',
            dataType : 'json',
        }
        
    }
}