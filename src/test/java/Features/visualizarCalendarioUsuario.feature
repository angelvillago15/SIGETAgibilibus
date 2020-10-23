Feature: Visualizar mi calendario semanal con mis reuniones

	Scenario Outline: Como usuario autenticado, quiero entrar en la pantalla de calendario semanal para visualizar mis reuniones de la semana
		Given Estoy autenticado como usuario en el sistema {} {string} {string}
		When Entro a la pantalla de calendario semanal
		Then Veo mis reuniones de la semana