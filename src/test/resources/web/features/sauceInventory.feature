
Feature: Agregar y eliminar productos del carrito de compras de saucedemo

  Background:
    Given he iniciado sesion y estoy en la pagina de inventario de la aplicacion

  @SauceAgregarProductoCarrito
  Scenario Outline: agregar productos al carrito de compras desde inventory page
    When agrego <producto> al carrito
    Then verifico que en el icono carrito aparezca el numero <numero>
    Examples:
      | producto  | numero |
      | el primer | 1      |

  @SauceEliminarProductoCarritoEnInventory
  Scenario Outline: eliminar productos del carrito de compras desde inventory page
    And agrego <producto> al carrito
    When hago click en boton remove del producto agregado al carrito de compras
    Then verifico que el contador del carrito de compras no se ve
    Examples:
      | producto  |
      | el primer |