package lippia.web.steps;

import com.crowdar.core.PageSteps;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.SauceInventoryService;
import lippia.web.services.SauceLoginService;


public class SauceLoginSteps extends PageSteps {

    @Given("estoy en la página de login de saucedemo")
    public void login() {
        SauceLoginService.navegarWeb();
    }

    @When("^ingreso el usuario (.*) y la contrasenia (.*)$")
    public void ingresoUsuYConPorParametros(String usuario, String contrasenia) {
        SauceLoginService.ingresoUsuYConPorParametros(usuario, contrasenia);
    }

    @And("hago click en el botón login")
    public void clickEnElBotonLogin() {
        SauceLoginService.clickLoginButton();
    }

    @Then("verifico ver el logo de la app en el homepage")
    public void verificoVerLogo(){
        SauceLoginService.verificoAppLogo();
    }
    @Then("verifico ver mensaje de error específico Epic sadface: Sorry, this user has been locked out.")
    public void verificoVerMensajeError(){
        SauceInventoryService.verificoMensajeError();
    }

}

