#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios


Feature: Visualizar mi calendario semanal con mis reuniones

Scenario: Como usuario autenticado, quiero entrar en la pantalla de calendario semanal para visualizar mis reuniones de la semana

Given Estoy autenticado como usuario en el sistema
When Entro a la pantalla de calendario semanal
Then Veo mis reuniones de la semana
