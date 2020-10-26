function guardar () { // se le llama cuando se da al boton crear
    
    if(false!=(validarCampo("nombreReunion") && validarCampo("fecha") && validarCampo("horaInicio")&& validarCampo("horaFin") && validarCampo("descripcion") && validarCampo("url") && validarCampo("invitar"))){ // no hay un campo vacio
        if(fechaCorrecta()){ //se comprueba la fecha
            var reunion= new Reunion($("#nombreReunion").val(),$("#fecha").val(),$("#horaInicio").val(),$("#horaFin").val(),$("#descripcion").val(),$("#url").val(),$("#invitar").val()); // crear objeto reunion
            alert('Se modificó una reunión correctamente ');
            
        }
    };
};