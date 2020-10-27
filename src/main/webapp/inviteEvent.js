function invitar () { // se le llama cuando se da al boton Invitar

	
	modificarReunion();//Aqui cargamos los datos de la reunion
	var reunion= new Reunion($("#nombreReunion").val(),$("#fecha").val(),$("#horaInicio").val(),$("#horaFin").val(),$("#descripcion").val(),$("#url").val(),$("#invitar").val()); //obtenemos un objeto 
	cargarFormulario();
	guardarReunion();
	alert('Se creó una reunion correctamente ');
	window.location.href = "UserCalendar.html";
  
};

function cargarFormulario(){
	
};


class Reunion{
    constructor(nombre, fecha, horaInicio, horaFin, descripcion, url,correos){
        this.nombre=nombre;
        this.correos=correos;
    }

    guardarReunion(){
        var msg ={
            type : "guardar Reunion",
			nombre : this.nombre,
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