package lippia.web.steps;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.SauceCartService;
import lippia.web.services.SauceInventoryService;

public class SauceCartSteps {
    @And("^hago click en el boton '(.*)'$")
    public void clickBotonCarrito(String boton) {
        SauceCartService.clickCartButtons(boton);
        }

    @And("lleno el formulario con nombre (.*), apellido (.*) y codigo postal (.*) y hago click en boton continuar")
    public void llenoElFormularioDeCompra(String nombre, String apellido, String areaCode) {
        SauceCartService.FormularioCheckout(nombre, apellido, areaCode);
    }

    @Then("verifico ver la página final de compra terminada")
    public void verificoPaginaCompraTerminada() {
        SauceCartService.verificarPaginaCompraTerminada();
    }

    @And("verifico datos en la pagina de overview")
    public void verificoDatosEnLaPaginaDeOverview() {
        SauceCartService.verificarOverview();
    }
}

