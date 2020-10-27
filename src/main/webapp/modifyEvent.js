function reunion () { // se le llama cuando se da al boton crear
	
	modificarReunion();//Aqui cargamos los datos de la reunion
	var reunion= new Reunion($("#nombreReunion").val(),$("#fecha").val(),$("#horaInicio").val(),$("#horaFin").val(),$("#descripcion").val(),$("#url").val(),$("#invitar").val()); //obtenemos un objeto 
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