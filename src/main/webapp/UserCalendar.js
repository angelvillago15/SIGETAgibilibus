  var self;
  
  function ViewModel() {
	self = this;
	
	function getSemana () {
		var data = {

				url : "getSemana",
				type : "post",
				
				success : function(response) {

					for (var i=0; i<response.length; i++) {
					//se escribe el dia
					$("#dia"+i).val(response[i].fecha);
						
						var reunion = response[i].reuniones;
						var html ="";
						for (var j=0; j<reunion.length; j++) {
							html = html + "<tr><td>"+reunion[j].nombre+"</td></tr>";
						}
						$("#tabla"+i).val(html);

					}
				},
				error : function(response) {
					alert(response.message);
				}
			};
			$.ajax(data);
	}
	getSemana();
	
	self.semanaSiguiente = function getSemanaSiguiente () {
		var data = {

				url : "getSemanaSiguiente",
				type : "post",
				
				success : function(response) {
					for (var i=0; i<response.length; i++) {
					//se escribe el dia
					$("#dia"+i).val(response[i].fecha);
						
						var reunion = response[i].reuniones;
						var html ="";
						for (var j=0; j<reunion.length; j++) {
							html = html + "<tr><td>"+reunion[j].nombre+"</td></tr>";
						}
						$("#tabla"+i).val(html);

					}
				},
				error : function(response) {
					alert(response.message);
				}
			};
			$.ajax(data);
	}
	self.semanaAnterior = function getSemanaAnterior () {
		var data = {

				url : "getSemanaAnterior",
				type : "post",
				
				success : function(response) {
					for (var i=0; i<response.length; i++) {
					//se escribe el dia
					$("#dia"+i).val(response[i].fecha);
						
						var reunion = response[i].reuniones;
						var html ="";
						for (var j=0; j<reunion.length; j++) {
							html = html + "<tr><td>"+reunion[j].nombre+"</td></tr>";
						}
						$("#tabla"+i).val(html);

					}

				},
				error : function(response) {
					alert(response.message);
				}
			};
			$.ajax(data);
	}
}

var vm = new ViewModel();


