package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import junit.framework.Assert;
import lippia.web.constants.SauceLoginConstants;
import lippia.web.constants.SauceInventoryConstants;

public class SauceInventoryService extends ActionManager {
    public static void verificoMensajeError() {
        Assert.assertTrue("No se ve mensaje de error", getText(SauceLoginConstants.ERROR_MSJ_CSS).contains("Epic sadface: Sorry, this user has been locked out."));
    }

    public static void clickAddToCart() {
        click(SauceInventoryConstants.FIRST_ADD_TO_CART_XPATH);
    }

    public static void verificoContadorCarrito() {
        Assert.assertTrue("No se ven cambios en el ícono del carrito", isPresent(SauceInventoryConstants.CONTADOR_CARRITO_CLASS));

    }

    public static void clickRemove() {
        click(SauceInventoryConstants.REMOVE_BUTTON_XPATH);
    }

    public static void verificoContadorCarritoVacio() {
        Assert.assertFalse("Se ve número 1 en el ícono del carrito", isPresent(SauceInventoryConstants.CONTADOR_CARRITO_CLASS));
    }
}
