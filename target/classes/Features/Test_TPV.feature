Feature: Genera TPV

  @Busqueda_Cliente_PFAE_CP01
  Scenario Outline: Busqueda_Numero_Cliente
    Given abre navegador en nube perfecto para prueba '<scenario>'
    When inicia sesion en la aplicacion Genera TPV con excel '<RowNum>'
    Then selecciona ultima version TPV
    And realiza busqueda de cliente '<RowNum>'

    Examples:
      | scenario                    | RowNum |
      | CP001 Busqueda Cliente PFAE | 1      |

  @Busqueda_Cliente_PFAE_Inexsistente_CP02
  Scenario Outline: Busqueda_Cliente_Inexistente
    Given abre navegador en nube perfecto para prueba '<scenario>'
    When inicia sesion en la aplicacion Genera TPV con excel '<RowNum>'
    Then selecciona ultima version TPV
    And realiza busqueda de cliente '<RowNum>'


    Examples:
      | scenario                                     | RowNum |
      | CP002 Genera TPVs Manejo de excepciones PFAE | 2      |

  @Busqueda_Cliente_PM_CP03
  Scenario Outline: Busqueda_Cliente_PM
    Given abre navegador en nube perfecto para prueba '<scenario>'
    When inicia sesion en la aplicacion Genera TPV con excel '<RowNum>'
    Then selecciona ultima version TPV
    And realiza busqueda de cliente '<RowNum>'
    And captura datos cuenta cheques '<RowNum>'

    Examples:
      | scenario                                                   | RowNum |
      | CP003 Genera TPVs Generar seccion Informacion de la cuenta | 4      |

  @Busqueda_Cliente_PM_CP04
  Scenario Outline: Captura datos cuenta cheques
    Given abre navegador en nube perfecto para prueba '<scenario>'
    When inicia sesion en la aplicacion Genera TPV con excel '<RowNum>'
    Then selecciona ultima version TPV
    And realiza busqueda de cliente '<RowNum>'
    And captura datos cuenta cheques '<RowNum>'

    Examples:
      | scenario                                                                      | RowNum |
      | CP004 Genera TPVs Modulo Captura datos de cuenta cheques PM_MXN_Transaccional | 4      |

  @Busqueda_Cliente_PM_CP05
  Scenario Outline: Captura Datos del Comercio
    Given abre navegador en nube perfecto para prueba '<scenario>'
    When inicia sesion en la aplicacion Genera TPV con excel '<RowNum>'
    Then selecciona ultima version TPV
    And realiza busqueda de cliente '<RowNum>'
    And captura datos cuenta cheques '<RowNum>'
    And captura datos del comercio y del producto '<RowNum>'
    And captura datos del domicilio y medios de contacto '<RowNum>'

    Examples:
      | scenario                                                   | RowNum |
      | CP005 Genera TPVs Alta en modulo Datos del Comercio PM USD | 4      |

