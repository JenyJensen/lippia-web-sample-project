@Login@Saucedemo
Feature: login en saucedemo

  Background:
    Given estoy en la página de login de saucedemo

  @LoginExitosoSaucedemo@Smoke@Regression
  Scenario Outline: login exitoso con usuario <usuario> en pagina de inicio de saucedemo
    When ingreso el usuario <usuario> y la contrasenia <contrasenia>
    And hago click en el boton login
    Then verifico ver <resultado>
    Examples:
      | usuario                 | contrasenia  | resultado                         |
      | standard_user           | secret_sauce | el logo de la app en el inventory |
      | problem_user            | secret_sauce | el logo de la app en el inventory |
      | performance_glitch_user | secret_sauce | el logo de la app en el inventory |
      | error_user              | secret_sauce | el logo de la app en el inventory |
      | visual_user             | secret_sauce | el logo de la app en el inventory |

  @FalloLoginSaucedemo@Regression
  Scenario Outline: login fallido por <razon> en pagina de inicio de saucedemo
    When ingreso el usuario <usuario> y la contrasenia <contrasenia>
    And hago click en el boton login
    Then verifico ver <resultado>
    Examples:
      | razon                            | usuario         | contrasenia  | resultado                                                                                  |
      | usuario bloqueado                | locked_out_user | secret_sauce | mensaje de error específico Epic sadface: Sorry, this user has been locked out.            |
      | usuario no registrado            | Jennifer        | Jensen       | mensaje de error Epic sadface: Username and password do not match any user in this service |
      | credenciales incorrectas         | standard_user   | 345juk       | mensaje de error Epic sadface: Username and password do not match any user in this service |
      | usuario incorrecto               | Standard_user   | secret_sauce | mensaje de error Epic sadface: Username and password do not match any user in this service |
      | usuario vacio                    |                 | secret_sauce | mensaje de error Epic sadface: Username is required                                        |
      | contrasenia vacia                | standard_user   |              | mensaje de error Epic sadface: Password is required                                        |
      | insertar en input SQL en usuario | ' OR 1=1 --     | secret_sauce | mensaje de error Epic sadface: Username and password do not match any user in this service |