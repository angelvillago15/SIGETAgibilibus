Feature: Registrar un nuevo usuario
  
  Background: Como usuario sin registrar en el sistema valido los campos del registro
  Given los campos estan vacios
  And introduzco el nombre de usuario
  And introduzco el email
  And introduzco la primera contraseña
  
  
  Scenario Outline: Contraseña mal
    Given he introducido la primera <contraseña>
	  When he introducido la segunda <contraseña> de manera incorrecta
 		Then mensaje de error <mensaje>
 
  
    Scenario Outline: Contraseña bien
    Given he introducido la primera <contraseña>
	  When he introducido la segunda <contraseña> correctamente
 		Then Las contraseñas son correctas. Se registra el usuario.

 
