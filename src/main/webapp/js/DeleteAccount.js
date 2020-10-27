$("#remove").click(function(){
    var mensaje = confirm("¿Estás seguro de que quieres eliminar esta cuenta?");
    var selection = $("#cause").val();
  
    if(mensaje==false){
      alert("Operación cancelada");
    }else if(selection!=1 && selection!=2 && selection!=3 && selection!=4 && selection!=5){
      alert("Seleccciona una razón, si no no se puede continuar con el proceso"); 
    }else{
      alert("Cuenta Eliminada");
    }    
  }); 