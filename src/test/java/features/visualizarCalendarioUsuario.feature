#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
Feature: Uso de cucumber en el que se va a probar la visualización del calendario.

Scenario: Como usuario autenticado, quiero estar en mi pagina principal para visualizar mi calendario semanal

Given Me autentico como usuario
When Estoy en mi pagina principal
Then Visualizo mi calendario semanal
