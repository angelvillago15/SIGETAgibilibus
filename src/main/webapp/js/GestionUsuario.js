var buscador = $("#table").DataTable();
getUsuarios();
$(document).ready(function() {
	getUsuarios();
	$("#input-search").keyup(function(){
        buscador.search($(this).val()).draw();
        
        if($("input-search").val()==""){
            $(".content-search").fadeout();
        }else{
            $(".content-search").fadeIn();
        }
    }).focus(function() {
        $("#table").show();
    }).blur(function() {
        $("#table").hide();
    });
});


function getUsuarios() {
	alert("hola!");
	var data = {

		url: "getUsuarios",
		type: "post",

		success: function(response) {
			var datos = JSON.parse(response);

			var cnt = datos.usuarios.length;
			$('#cnt').text(cnt);

			var txt = "<thead><tr><td></td></tr></thead>";

			for (var i in datos.usuarios) {
				var inv = datos.usuarios[i];
				txt = txt + "<tbody><tr> <td><a href=""#"">" + user.nombre + "</a></td></tr>";
					if (i+1===null)
						txt = txt + "</tbody>";
			}
				document.getElementById('usuarios').innerHTML = txt;
			},
			error: function(response) {
			alert(response.message);
		}
	};
	$.ajax(data);
}