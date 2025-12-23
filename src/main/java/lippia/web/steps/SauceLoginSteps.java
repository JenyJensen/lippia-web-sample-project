package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.SauceLoginService;

public class SauceLoginSteps extends PageSteps {

    @Given("estoy en la página de login de saucedemo")
    public void login() {
        SauceLoginService.navegarWeb();
    }

    @When("^ingreso el usuario (.*) y la contrasenia (.*)$")
    public void ingresoUsuYConPorParametros(String usuario, String contrasenia) {
        SauceLoginService.ingresoUsuYConPorParametros(usuario, contrasenia);}

    @Then("verifico ver (.*)")
    public void verificoVerResultado(String resultado) {
        SauceLoginService.verificoResultado(resultado);
    }
}

