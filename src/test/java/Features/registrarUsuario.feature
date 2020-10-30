Feature: Registrar un nuevo usuario
  
  Scenario Outline: Validar campos
    Given un usuario que ha pulsado el boton Registrarme
	  When cuando introduzco en el campo nombre de usuario <nombre de usuario>
	  And cuando introduzco en el campo contraseña <contraseña>
	  And cuando introduzco en el campo email <email>
	  And cuando introduzco en el campo validar la misma <contraseña>
 		Then Se añade mi nuevo usuario al sistema
 
  
    Scenario Outline: Validar campos
    Given un usuario que ha pulsado el boton Registrarme
	  When cuando introduzco en el campo nombre de usuario <nombre de usuario>
	  And cuando introduzco en el campo contraseña <contraseña>
	  And cuando introduzco en el campo email <email>
	  And cuando introduzco en el campo validar otra <contraseña>
 		Then Las contraseñas no coinciden. Mostrar el mensaje <mensaje>

 
