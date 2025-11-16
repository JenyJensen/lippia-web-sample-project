package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.SauceInventoryService;

import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static lippia.web.services.SauceLoginService.clickLoginButton;
import static lippia.web.services.SauceLoginService.ingresoUsuYConPorParametros;

public class SauceInventorySteps extends PageSteps {
    @Given("estoy en la página de inicio de la aplicación")
    public void homepage() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
        ingresoUsuYConPorParametros("standard_user", "secret_sauce");
        clickLoginButton();
    }

    @When("hago click en add to cart en el primer producto")
    public void hagoClickAddToCart() {
        SauceInventoryService.clickAddToCart();
    }


    @Then("verifico que en el icono carrito aparezca el numero uno")
    public void verificoIconoCarritoMuestraUno() {
        SauceInventoryService.verificoContadorCarrito();
    }

    @And("hago click en boton remove del producto agregado al carrito de compras")
    public void clickRemoveDelProductoAgregado() {
        SauceInventoryService.clickRemove();
    }

    @Then("verifico que el contador del carrito de compras no se ve")
    public void verificoContadorDelCarritoNoVisible() {
        SauceInventoryService.verificoContadorCarritoVacio();
    }
}
