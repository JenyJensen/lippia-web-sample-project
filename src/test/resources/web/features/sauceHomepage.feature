@Saucedemo
  Feature: Agregar y eliminar productos del carrito de compras de saucedemo

Background:
Given estoy en la página de inicio de la aplicación

    @SauceAgregarProductoCarritoEnHomepage
    Scenario: agregar productos al carrito de compras desde homepage
      When hago click en add to cart en el primer producto
      Then verifico que en el icono carrito aparezca el numero uno

    @SauceEliminarProductoCarritoEnHomepage
      Scenario: eliminar productos del carrito de compras desde homepage
      And hago click en add to cart en el primer producto
      When hago click en boton remove del producto agregado al carrito de compras
      Then verifico que el contador del carrito de compras no se ve