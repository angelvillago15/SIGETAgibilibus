
Feature: Como usuario quiero contestar a una invitación a la reunión de un organizador cuando éste me la envíe

	Background: como usuario me llega una notificacion y la respondo
		Given: Me autentiqué como usuario existente en el sistema
			When: me aparece una notificación
				Then: despliego la barra de notificaciones 

					Scenario: Respondo afirmativamente a mi asistencia a la reunión 
						When: Respondo aceptar
							Then: Mi calendario se modifica añadiendo esa reunión
					
					Scenario: Respondo negativamente a mi asistencia a la reunión
						When: respondo rechazar
							Then: Mi calendario no sufre cambios
