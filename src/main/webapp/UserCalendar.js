function ViewModel() {
	var self = this;
	
  	function getSemana () {
		var data = {

				url : "getSemana",
				type : "post",
				
				success : function(response) {
					var datos =  JSON.parse(response);
					for(var i=0;i<7;i++){
						$('#d'+i).text(datos['d'+i]);
						var ls = datos['ls'+i];
					}	
				},
				error : function(response) {
					alert(response.message);
				}
			};
			$.ajax(data);
	}
	getSemana();
	
	
	self.siguiente = function getSemanaSiguiente () {
		var data = {

				url : "getSemanaSiguiente",
				type : "post",
				
				success : function(response) {
					var datos =  JSON.parse(response);
					for(var i=0;i<7;i++){
						$('#d'+i).text(datos['d'+i]);
					}	
				},
				error : function(response) {
					alert(response.message);
				}
			};
			$.ajax(data);
	}
	 self.anterior = function getSemanaAnterior () {
		var data = {
				
				url : "getSemanaAnterior",
				type : "post",
				
				success : function(response) {
					var datos =  JSON.parse(response);
					for(var i=0;i<7;i++){
						$('#d'+i).text(datos['d'+i]);
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
ko.applyBindings(vm);

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


