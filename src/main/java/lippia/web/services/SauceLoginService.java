package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.SauceLoginConstants;
import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class SauceLoginService extends ActionManager {
    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void ingresoUsuYConPorParametros(String usuario, String contrasenia) {
        setInput(SauceLoginConstants.USER_ID, usuario);
        setInput(SauceLoginConstants.PASSWORD_ID, contrasenia);
    }

    public static void clickLoginButton() {
        click(SauceLoginConstants.LOGIN_BUTTON_ID);
    }

    public static void verificoMsjUsBloq() {
        junit.framework.Assert.assertTrue("No se ve mensaje de error de usuario bloqueado", getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Sorry, this user has been locked out."));
    }

    public static void verificoMsjUsInexistInval() {
        junit.framework.Assert.assertTrue("No se ve mensaje de error de usuario inexistente", getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Username and password do not match any user in this service"));

    }

    public static void verificoMsjUsRequerido() {
        junit.framework.Assert.assertTrue("No se ve mensaje de error de usuario requerido", getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Username is required"));
    }

    public static void verificoMsjPasRequerido() {
        junit.framework.Assert.assertTrue("No se ve mensaje de error", getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Password is required"));

    }
}

