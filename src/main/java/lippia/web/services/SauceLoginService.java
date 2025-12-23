package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.SauceCartConstants;
import lippia.web.constants.SauceInventoryConstants;
import lippia.web.constants.SauceLoginConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class SauceLoginService extends ActionManager {
    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void ingresoUsuYConPorParametros(String usuario, String contrasenia) {
        setInput(SauceLoginConstants.USER_ID, usuario);
        setInput(SauceLoginConstants.PASSWORD_ID, contrasenia);
    }

    public static void verificoResultado(String resultado) {
        switch (resultado) {
            case "el logo de la app en el inventory":
                Assert.assertTrue(isPresent(SauceInventoryConstants.APP_LOGO_CLASS), "No se ve el logo de la app");
                break;
            case "verifico ver mensaje de error específico Epic sadface: Sorry, this user has been locked out.":
                Assert.assertTrue(getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Sorry, this user has been locked out."), "No se ve mensaje de error de usuario bloqueado");
                break;
            case "verifico ver mensaje de error Epic sadface: Username and password do not match any user in this service":
                Assert.assertTrue(getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Username and password do not match any user in this service"), "No se ve mensaje de error de usuario inexistente");
                break;
            case "verifico ver mensaje de error Epic sadface: Username is required":
                Assert.assertTrue(getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Username is required"), "No se ve mensaje de error de usuario requerido");
                break;
            case "verifico ver mensaje de error Epic sadface: Password is required":
                Assert.assertTrue(getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Password is required"), "No se ve mensaje de password requerido");
                break;
            case "verifico ver la página final de compra terminada":
                Assert.assertTrue(isPresent(SauceCartConstants.CHECKOUT_COMPLETE_ID), "No se ve cartel con texto Thank you for your order!");
                break;
        }
    }
}

