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

function register(){
		var info = {
			type : "Register",
			userCompletName : userName.value,
			userName : userName.value,
			userApellidos : userApellidos.value,
			userDni : userDni.value,
			userDate : userDate.value,
			userTelf : userTelf.value,
			userMail1 : userMail1.value,
			userMail2 : userMail2.value,
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