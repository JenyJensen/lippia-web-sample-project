package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
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

    public static void verificoMsjUsBloq() {
        Assert.assertTrue(getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Sorry, this user has been locked out."),"No se ve mensaje de error de usuario bloqueado");
    }

    public static void verificoMsjUsInexistInval() {
        Assert.assertTrue(getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Username and password do not match any user in this service"),"No se ve mensaje de error de usuario inexistente");
    }

    public static void verificoMsjUsRequerido() {
        Assert.assertTrue(getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Username is required"),"No se ve mensaje de error de usuario requerido");
    }

    public static void verificoMsjPasRequerido() {
        Assert.assertTrue(getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Password is required"),"No se ve mensaje de password requerido");
    }
}

