#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
Feature: Uso de cucumber en el que se va a probar el funcionamiento de una lista de tareas.

Scenario: Se inserta una tarea
Given Una nueva tarea
When se inserta
Then no ha habido fallos
