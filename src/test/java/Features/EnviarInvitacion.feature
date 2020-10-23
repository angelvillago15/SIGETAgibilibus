
Feature: Como organizador quiero enviar invitacion a los usuarios cuando creo una reunion y que estos contesten

Background: como organizador relleno el formulario para poder enviar una invitacion
Given: He creado una reunion
When: envio la invitacion a los asistentes <asistentes>


Scenario: como usuario me llega una notificacion y la respondo
Then: me aparece una notificacion 
And: respondo invitación 

Scenario: como ornganizador no se pudo enviar la invitacion  
Then: muestra mensaje de error <mensaje> al organizacion









