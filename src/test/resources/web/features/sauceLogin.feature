@Saucedemo
Feature: login en saucedemo

  @LoginSauce
  Scenario Outline: login <tipo> en página de inicio de saucedemo
    Given estoy en la página de login de saucedemo
    When ingreso el usuario <usuario> y la contrasenia <contrasenia>
    And hago click en el botón <boton>
    Then verifico ver <resultado>
    Examples:
      | tipo    | usuario                 | contrasenia  | boton | resultado                                                                       |
      | exitoso | standard_user           | secret_sauce | login | el logo de la app en el homepage                                                |
      | exitoso | problem_user            | secret_sauce | login | el logo de la app en el homepage                                                |
      | exitoso | performance_glitch_user | secret_sauce | login | el logo de la app en el homepage                                                |
      | exitoso | error_user              | secret_sauce | login | el logo de la app en el homepage                                                |
      | exitoso | visual_user             | secret_sauce | login | el logo de la app en el homepage                                                |
      | fallido | locked_out_user         | secret_sauce | login | mensaje de error específico Epic sadface: Sorry, this user has been locked out. |
