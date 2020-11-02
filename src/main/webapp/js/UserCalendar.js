function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
  document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
  document.body.style.backgroundColor = "white";
}

function invitar() {
	var msg = {
		type : "asistentes nuevos",
		id : this.id,
		correos : this.correos
	};
	var data = {
		data : JSON.stringify(msg),
		url : "asistentesNuevos",
		type : "post",
		contentType : 'application/json',
		dataType : 'json',
	}
	$.ajax(data);

	window.location.href = "UserCalendar.html";
}


