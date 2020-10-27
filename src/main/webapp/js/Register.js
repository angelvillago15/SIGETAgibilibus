$(document).ready(function() {
    $('input[type=password]').keyup(function() {
        var pswd = $(this).val();
        //length
        if ( pswd.length < 8 ) {
            $('#length').removeClass('valid').addClass('invalid');
        } else {
            $('#length').removeClass('invalid').addClass('valid');
        }
        //letter
        if ( pswd.match(/[A-z]/) ) {
            $('#letter').removeClass('invalid').addClass('valid');
        } else {
            $('#letter').removeClass('valid').addClass('invalid');
        }
        //validate number
        if ( pswd.match(/\d/) ) {
            $('#number').removeClass('invalid').addClass('valid');
        } else {
            $('#number').removeClass('valid').addClass('invalid');
        }
        //mayus
        if ( pswd.match(/[A-Z]/) ) {
            $('#capital').removeClass('invalid').addClass('valid');
        } else {
            $('#capital').removeClass('valid').addClass('invalid');
        }

    }).focus(function() {
        $('#alertPass').show();
    }).blur(function() {
        $('#alertPass').hide();
    });

    $("#registro").click(function(){//solo estan como necesarios mail usuario y contraseña como dijimos en el drive
        var mail1 = $("#mail1").val();
        var username = $("#username").val();
        var pass=$("#pass").val();

        if(mail1.length==0 || mail2.length==0 || username.length==0 || pass.length==0){
            alert("Rellena todos los campos");
        }else if(pass.length < 8 ||  !pass.match(/[A-z]/) || !pass.match(/\d/) || !pass.match(/[A-Z]/)){
            alert("La contraseña no tiene los requisitos requeridos");
        }else{
            alert("Usuario registrado");
            window.location="Login.html";
            limpiarCampos();
        }
    });

    function limpiarCampos(){ // resetear todos los campos
        document.getElementById("username").value="";
        document.getElementById("dni").value="";
        document.getElementById("name").value="";
        document.getElementById("Apellidos").value="";
        document.getElementById("telefono").value="";
        document.getElementById("pass").value="";
        document.getElementById("fechaN").value="";
    };
    class Reunion{
        constructor(dni, nombre, apellidos, telefono, fechaN, usuario, password, mail){
            this.dni=dni;
            this.nombre=nombre;
            this.apellidos=apellidos;
            this.telefono=telefono;
            this.fechaN=fechaN;
            this.usuario=usuario;
            this.password=password;
            this.mail=mail;
        }
    
        crearReunion(){
            var msg ={
                type : "nuevo usuario",
                dni : this.dni;
                nombre : this.nombre,
                apellidos : this.apellidos,
                telefono : this.telefono,
                fechaN : this.fechaN,
                usuario : this.usuario,
                password : this.password,
                mail : this.mail,
                rol : "usuario"
            };
            var data = {
                data : JSON.stringify(msg),
                url : "nuevoUsuario",
                type : "post",
                contentType : 'application/json',
                dataType : 'json',
            }
            //pasar a json JSON.stringify(msg)
        }
});