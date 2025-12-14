@Saucedemo
Feature: carrito de compras de pagina Saucedemo

  Background:
    Given he iniciado sesion y estoy en la pagina de inventario de la aplicacion
@TerminarCompra
  Scenario Outline: termino compra de productos agregados al carrito
    And he agregado <producto> al carrito
    Then verifico que en el icono carrito aparezca el numero uno

    Examples:
      | producto      |
      | dos productos |