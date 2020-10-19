#languaje:es
Feature: login

Scenario: Hacer login correctamente 
Given estoy registrado como usuario 
When introduzco en el campo usuario <usuario> correctamente
And  introduzco contraseña <password> correctamente 
And pulso el boton de validar <boton>
Then voy a la pagina de inicio del sistema

Scenario: Validar los campos 
Given estoy registrado como usuario 
When relleno los campos usuario <usuario> 
And introduzco  contraseña <password>
And pulso el boton validar <boton>
Then usuario es incorrecto, mostrar el mensaje "Datos incorrectos"
And contraseña es correcta, mostrar el mensaje "Datos incorrectos"


