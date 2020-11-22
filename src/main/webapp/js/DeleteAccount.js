$("#remove").click(function(){
    var mensaje = confirm("¿Estás seguro de que quieres eliminar esta cuenta?");
    var selection = $("#cause").val();
  
    if(mensaje==false){
      alert("Operación cancelada");
    }else if(selection!=1 && selection!=2 && selection!=3 && selection!=4 && selection!=5){
      alert("Seleccciona una razón, si no no se puede continuar con el proceso"); 
    }else{
   	  eliminarCuenta();
    }    
  }); 
  
   function eliminarCuenta(){
        var info = {
        id : sessionStorage.getItem("id") };
        var data = {
                data : JSON.stringify(info),
                url : "eliminarUsuario",
                type : "post",
                contentType: 'application/json',
                success: function(response){
                	alert("Cuenta eliminada correctamente.");
             		sessionStorage.clear();
                	window.location.href = "index.html";
                    	
                },
                error : function(response) {
                	var respuesta = JSON.parse(response);
                	alert(respuesta.message);
                }
            };
            $.ajax(data);
    }