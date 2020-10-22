
Feature: Como organizador quiero enviar invitacion a los usuarios cuando creo una reunion y que estos contesten

Background: como organizador relleno el formulario para poder enviar una invitacion
Given: he rellenado el formulario para crear la invitacion
When: doy al boton <crearReunion> 

Scenario: le llega a todos los participantes y aparece una notificacion
Then: aparece una notificacion 
And: respondo invitación 

Scenario: hay un fallo y no llega la invitacion a los usuarios 
Then: muestra mensaje de error <mensaje>









