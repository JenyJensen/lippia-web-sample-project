package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import junit.framework.Assert;
import lippia.web.constants.SauceConstants;
import lippia.web.constants.SauceInventoryConstants;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class SauceLoginService extends ActionManager {
    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void ingresoUsuYConPorParametros(String usuario, String contrasenia) {
        setInput(SauceConstants.USER_ID, usuario);
        setInput(SauceConstants.PASSWORD_ID, contrasenia);
    }

    public static void clickLoginButton() {
        click(SauceConstants.LOGIN_BUTTON_ID);
    }

    public static void verificoAppLogo() {
        Assert.assertTrue("No se ve el logo de la app", isPresent(SauceInventoryConstants.APP_LOGO_CLASS));
    }
}

