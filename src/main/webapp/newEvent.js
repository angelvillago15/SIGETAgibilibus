function crear () {
   var reunion= new Reunion($("#nombreReunion").val(),$("#fecha").val(),$("#horaInicio").val(),$("#horaFin").val(),$("#descripcion").val(),$("#url").val());
};

class Reunion{
    constructor(nombre, fecha, horaInicio, horaFin, descripcion, url){
        this.nombre=nombre;
        this.fecha=fecha;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.descripcion=descripcion;
        this.url=url;
    }

    crearReunion(){
        var msg ={
            type : "reunion",
			subtype : "nuevaReunion",
			nombre : self.nombre,
            fecha : this.fecha,
            horaInicio : horaInicio,
			horaFin : this.horaFin,
            descripcion : this.descripcion,
            url: this.url
        };
    }
}