Feature: Registrar un nuevo usuario
  
  Background: Como persona externa al sistema quiero registrarme insertando mis datos en el formulario de registro
  Given Todos los campos del formulario estan vacios
  And Introduzco los campos obligatorios <nombre de usuario>, el primer <e-mail> y la primera <contraseña>

  
  Scenario Outline: Validar campos bien
    Given He introducido la segunda <contraseña>
    And He introducido el segundo <e-mail>
	  When Los campos de primera <contraseña> y segunda <contraseña> coinciden
	  And Los campos de primer <e-mail> y segundo <e-mail> coinciden
 		Then Los campos son correctos. Usuario registrado

  Scenario Outline: Validar campos mal
    Given He introducido la segunda <contraseña>
    And He introducido el segundo <e-mail>
	  When Los campos de primera <contraseña> y segunda <contraseña> no coinciden
 		Then Las contraseñas no coinciden. Mostrar mensaje de error <mensaje>

 		Scenario Outline: Validar campos mal
    Given He introducido la segunda <contraseña>
    And He introducido el segundo <e-mail>
	  When Los campos de primer <e-mail> y segundo <e-mail> no coinciden
 		Then Los e-mails no coinciden. Mostrar mensaje de error <mensaje>