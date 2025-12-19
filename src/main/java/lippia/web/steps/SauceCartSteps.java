package lippia.web.steps;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.SauceCartService;

public class SauceCartSteps {
    @And("hago click en el boton checkout")
    public void clickCheckoutCarrito() {
        SauceCartService.clickCheckout();
    }

    @And("lleno el formulario con nombre (.*), apellido (.*) y codigo postal (.*) y hago click en boton continuar")
    public void llenoElFormularioDeCompra(String nombre, String apellido, String areaCode) {
        SauceCartService.FormularioCheckout(nombre, apellido, areaCode);
    }


    @And("verifico datos en la pagina de overview")
    public void verificoDatosEnLaPaginaDeOverview() {
        SauceCartService.verificarOverview();
    }


    @And("hago click en el boton finish")
    public void clickEnElBotonFinish() {
        SauceCartService.clickFinish();
    }

    @Then("verifico ver la página final de compra terminada")
    public void verificoPaginaCompraTerminada() {
        SauceCartService.verificarPaginaCompraTerminada();
    }
}

