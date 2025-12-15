@Saucedemo
Feature: login en saucedemo

  @LoginSauce
  Scenario Outline: login <tipo> en pagina de inicio de saucedemo
    Given estoy en la página de login de saucedemo
    When ingreso el usuario <usuario> y la contrasenia <contrasenia>
    And hago click en el boton <boton>
    Then verifico ver <resultado>
    Examples:
      | tipo                                         | usuario                 | contrasenia  | boton | resultado                                                                                  |
      | exitoso con usuario estandard                | standard_user           | secret_sauce | login | el logo de la app en el inventory                                                          |
      | exitoso con usuario con problema             | problem_user            | secret_sauce | login | el logo de la app en el inventory                                                          |
      | exitoso con usuario para performance         | performance_glitch_user | secret_sauce | login | el logo de la app en el inventory                                                          |
      | exitoso con usuario con error                | error_user              | secret_sauce | login | el logo de la app en el inventory                                                          |
      | exitoso con usuario con front roto           | visual_user             | secret_sauce | login | el logo de la app en el inventory                                                          |
      | fallido por usuario bloqueado                | locked_out_user         | secret_sauce | login | mensaje de error específico Epic sadface: Sorry, this user has been locked out.            |
      | fallido por usuario no registrado            | Jennifer                | Jensen       | login | mensaje de error Epic sadface: Username and password do not match any user in this service |
      | fallido por credenciales incorrectas         | standard_user           | 345jukin     | login | mensaje de error Epic sadface: Username and password do not match any user in this service |
      | fallido por usuario incorrecto               | Standard_user           | secret_sauce | login | mensaje de error Epic sadface: Username and password do not match any user in this service |
      | fallido por usuario vacio                    |                         | secret_sauce | login | mensaje de error Epic sadface: Username is required                                        |
      | fallido por contrasenia vacia                | standard_user           |              | login | mensaje de error Epic sadface: Password is required                                        |
      | fallido por insertar en input SQL en usuario | ' OR 1=1 --             | secret_sauce | login | mensaje de error Epic sadface: Username and password do not match any user in this service |