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
});

    $("#registro").click(function(){//solo estan como necesarios mail usuario y contraseña como dijimos en el drive
        var mail1 = $("#mail1").val();
        var username = $("#username").val();
        var pass=$("#pass").val();
        var pass2=$("#pass2").val();
        var mail=$("#mail1").val();
        var mail2=$("#mail2").val();
        
        if(mail1.length==0 || mail2.length==0 || username.length==0 || pass.length==0){
            alert("Rellena todos los campos");
        }else if(pass!==pass2){
            alert("Las contraseñas no puede ser distintas");
        }else if(mail1!==mail2){
            alert("Los e-mails no pueden ser distintos");
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
    function register(){
            var info = {
                type : "Register",
                userCompletName : userName.value,
                userName : userName.value,
                userApellidos : userApellidos.value,
                userDni : userDni.value,
                userDate : userDate.value,
                userTelf : userTelf.value,
                userMail : userMail.value,
                pwd1 : pwd1.value,
                pwd2 : pwd2.value

            };
            var data = {
                    data : JSON.stringify(info),
                    url : "register",
                    type : "post",
                    contentType: 'application/json',

                    success : function() {
                        alert("OK");
                    },
                    error : function(response) {
                        alert(response.responseText);
                    }
                };
                $.ajax(data);
        }