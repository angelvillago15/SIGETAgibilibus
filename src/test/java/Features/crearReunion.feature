Feature: Crear reunion
  
  Scenario Outline: Como usuario autenticado en el sistema, quiero crear reunion para verla en mi calendario
    Given Estoy autenticado como usuario {} {} {} 
	  When Guardo una nueva reunion {int} {string} {string} {} {} {} {} {string}
 		Then Actualizo mi calendario con la nueva reunion
 
    

 
