#languaje:es
Feature: login

Scenario: como usuario existente, quiero acceder al sistema con mis credenciales correctamente 
Given me he registrado como usuario en el sistema 
When introduzco en el campo usuario <usuario> y contraseña <password>
And pulso el boton <boton>
Then el sistema me muestra la pantalla de inicio <pagina>

Scenario: como usuario existente, quiero acceder al sistema con mis credenciales incorrectas
Given me he registrado como usuario en el sistema 
When introduzco en el campo usuario <usuario> y contraseña <password> incorrectas 
And pulso el boton <boton>
Then el sistema me muestra un mensaje de error <mensaje>
