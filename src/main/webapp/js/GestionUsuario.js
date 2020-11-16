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
	var tbodyRef = document.getElementById('table').getElementsByTagName('tbody')[0];
	var newRow = tbodyRef.insertRow(0);

	var newCell = newRow.insertCell(0);

	newCell.innerHTML = "<tr><td><a href='javascript:datosUsuario();'>" + "hola" + "</a></td></tr>";
	buscador.row.add([newCell.innerHTML]);


}

function datosUsuario() {
	console.log("TEST");

}