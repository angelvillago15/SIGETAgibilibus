$("#edit").click(function(){
    var username = $("#Nusername").val();
    var pass=$("#Npass").val();
    var passConfirm=$("#CNpass").val();

    if(username.length==0 || pass.length==0||passConfirm.length==0){
      alert("Rellena todos los datos");
    }else if(pass!=passConfirm){
      alert("La contraseña debe ser la misma");
    }else{
      alert("Cuenta editada");
      setInterval(this.location.href=location.href,20000);
    }

  });