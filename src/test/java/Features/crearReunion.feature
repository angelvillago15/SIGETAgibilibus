#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Crear reunion
  
  Scenario: Como usuario autenticado en el sistema, quiero crear reunion para verla en mi calendario
    Given Estoy autenticado como usuario en el sistema con <httpSession>, <userName>, <pwd>:
	    | httpSession  | userName    | pwd   |
	    | 		 				 | hola			   | aaa   |
    When Guardo una nueva reunion con los atributos <idReunion>, <titulo>, <descripcion>, <horaInicio>, <horaFin>, <organizador>, <asistentes>, <url>:
    	| idReunion  | titulo    			| descripcion   		|  horaInicio  | horaFin	|	organizador | asistentes	|	url														|
	    | 1234 			 | Inicio Spring	| Reunion de inicio |  18:30  		 | 19:00		| usuario1		| usuario2		| https://www.reunionInicio.es	| 
    Then Actualizo mi calendario con la nueva reunion
 
    

 
