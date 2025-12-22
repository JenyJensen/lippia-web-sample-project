package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.SauceInventoryService;

public class SauceInventorySteps extends PageSteps {
    @Given("he iniciado sesion y estoy en la pagina de inventario de la aplicacion")
    public void getInventoryPage() {
        SauceInventoryService.gettingInventoryPage();
    }

    @Then("verifico que en el icono carrito aparezca el numero (.*)")
    public void verificoIconoCarritoMuestraUno(int numero) {
        SauceInventoryService.verificoContadorCarrito(numero);
    }

    @And("hago click en boton remove del producto agregado al carrito de compras")
    public void clickRemoveDelProductoAgregado() {
        SauceInventoryService.clickRemove();
    }

    @Then("verifico que el contador del carrito de compras no se ve")
    public void verificoContadorDelCarritoNoVisible() {
        SauceInventoryService.verificoContadorCarritoVacio();
    }

    @And("agrego (.*) al carrito")
    public void heAgregadoProductosAlCarrito(String producto) {
        SauceInventoryService.agregoProductosAlCarrito(producto);
    }

    @When("ingreso al carrito")
    public void ingresoAlCarrito() {
        SauceInventoryService.ingresarCarrito();
    }
}