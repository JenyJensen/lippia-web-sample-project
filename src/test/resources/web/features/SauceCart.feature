@Saucedemo
Feature: carrito de compras de pagina Saucedemo

  Background:
    Given he iniciado sesion y estoy en la pagina de inventario de la aplicacion

  @TerminarCompra
  Scenario Outline: termino compra de productos agregados al carrito
    And agrego <producto> al carrito
    When ingreso al carrito
    And hago click en el boton '<boton>'
    And lleno el formulario con nombre <nombre>, apellido <apellido> y codigo postal <areaCode> y hago click en boton continuar
    And verifico datos en la pagina de overview
    And hago click en el boton '<boton>'
    Then verifico ver la página final de compra terminada

    Examples:
      | producto      | boton    | nombre | apellido | areaCode |boton|
      | dos productos | checkout | Marcia | Sanz     | 1234     |finish|
