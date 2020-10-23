
Feature: login

Scenario Outline: Validar campos
Given estoy registrado como usuario 
When introduzco en el campo usuario <usuario> 
And  introduzco contraseña <password>  
Then voy a la pagina de inicio del sistema <pagina>


Examples: 
|usuario	|password	|boton  	 |pagina	|
|hola	  	| aaa  	  |validar 	 |  login	|


Scenario Outline: Validar los campos 
Given estoy registrado como usuario 
When relleno los campos usuario <usuario> 
And introduzco  contraseña <password>
Then usuario es incorrecto, mostrar el mensaje <mensaje>
And contraseña es correcta, mostrar el mensaje <mensaje>

Examples: 
|usuario	|password	|boton  	 |mensaje						|
|Amanda  	| aaa  	  |validar 	 | Error en  login 	|
|usuario	|					|validar 	 | Error en  login	|
|			  	| trx  	  |validar 	 | Error en  login	|



