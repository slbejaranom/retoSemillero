@PRUEBAS_MODULO_VUELO
Feature: Prueba de origen vacio
  I want to use this template for my feature file

  @PRUEBA_1
  Scenario: Origen vacio en buscar
    Given Dejar el origen vacio
   	And seleccionar casilla de no he decidido la fecha
    When Clic en buscar    
  	Then Validar que salga el letrero    
  @PRUEBA_2
  Scenario: Deshabilitar fechas de ida y vuelta
    Given Oprimir casilla todavia no he decidido fecha           
   Then Validar que los campos queden disabled
  @PRUEBA_3
  Scenario: Seleccion de ida y regreso y luego solo ida
  	Given Llenar origen
 		And Llenar destino
  	When Usuario oprima solo ida
 		Then verificar regreso deshabilitado
  @PRUEBA_4
  Scenario: Llenar modulo de vuelo correctamente
  	Given Llenar bien formulario vuelo
  	When usuario seleccione vuelo
 		Then verificar letrero final
  @PRUEBA_5
  Scenario: Intentar comprar sin llenar el formulario
  	Given dar clic a comprar sin asistencia
  	Then verificar por lo menos un letrero