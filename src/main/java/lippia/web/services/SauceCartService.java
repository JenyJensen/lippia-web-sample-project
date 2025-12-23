package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.SauceCartConstants;
import lippia.web.constants.SauceInventoryConstants;
import lippia.web.constants.SauceLoginConstants;
import org.testng.Assert;

public class SauceCartService extends ActionManager {

    public static void clickSaucedemoButton(String nombreBoton) {
        if (nombreBoton.contains("checkout")) {
            click(SauceCartConstants.CHECKOUT_BUTTON_CSS);
        } else if (nombreBoton.contains("finish")) {
            click(SauceCartConstants.FINISH_BUTTON_CSS);
        } else if (nombreBoton.contains("login")) {
            click(SauceLoginConstants.LOGIN_BUTTON_ID);
        }
    }

    public static void FormularioCheckout(String nombre, String apellido, String areaCode) {
        setInput(SauceCartConstants.NAME_INPUT_ID, nombre);
        setInput(SauceCartConstants.APELLIDO_INPUT_ID, apellido);
        setInput(SauceCartConstants.AREACODE_INPUT_ID, areaCode);
        click(SauceCartConstants.CONTINUE_BUTTON_ID);
    }

    public static void verificarOverview() {
        int cantidadBadge = Integer.parseInt(
                getText(SauceInventoryConstants.CONTADOR_CARRITO_CLASS)
        );
        Assert.assertEquals(cantidadBadge, getElements(SauceCartConstants.CART_ITEM_CLASS).size(), "No hay la misma cantidad de productos en el icono del cart badge que en el overview");
        Assert.assertEquals(getText(SauceCartConstants.TITLE_OVERVIEW_CSS), "Checkout: Overview", "No se ve el titulo de la pagina de Overview");
    }
}
