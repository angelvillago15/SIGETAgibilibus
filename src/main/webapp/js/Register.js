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
