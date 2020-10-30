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
        var mail1 = $("#userMail").val();
        var username = $("#userName").val();
        var pass=$("#pwd1").val();
        var pass2=$("#pwd2").val();
        var mail2=$("#mail2").val();
        
        if(mail1.length==0 || mail2.length==0 || username.length==0 || pass.length==0){
            alert("Rellena todos los campos");
        }else if(pass!==pass2){
            alert("Las contraseñas no puede ser distintas");
        }else if(mail1!==mail2){
            alert("Los e-mails no pueden ser distintos");
        }
    });


    function limpiarCampos(){ // resetear todos los campos
        document.getElementById("userCompletName").value="";
        document.getElementById("userDni").value="";
        document.getElementById("userName").value="";
        document.getElementById("userApellidos").value="";
        document.getElementById("userTelf").value="";
        document.getElementById("userMail").value="";
        document.getElementById("pwd1").value="";
        document.getElementById("userDate").value="";
        document.getElementById("pwd2").value="";
        document.getElementById("mail2").value="";
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
                alert("Usuario registrado");
                limpiarCampos();
                window.location="Login.html";
        }