var buscador = $("#table").DataTable();


$(document).ready(function() {

	$("#input-search").keyup(function() {
		buscador.search($(this).val()).draw();


		if ($("input-search").val() == "") {
			$(".content-search").fadeout();
		} else {
			$(".content-search").fadeIn();
		}
	}).focus(function() {
		$("#table").show();
	}).blur(function() {
		$("#table").hide();
	});
	cargarUsuarios();

});

function cargarUsuarios() {
	buscador.row.add(["<tr><td><a href='javascript:datosUsuario();'>hola</a></td></tr>"]);
}

function datosUsuario() {
	console.log("TEST");

}