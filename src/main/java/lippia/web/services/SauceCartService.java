package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import junit.framework.Assert;
import lippia.web.constants.SauceCartConstants;
import lippia.web.constants.SauceInventoryConstants;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SauceCartService extends ActionManager {

    public static void clickCartButtons(String boton) {
        switch (boton) {
            case "checkout":
                click(SauceCartConstants.CHECKOUT_BUTTON_CSS);
                break;
            case "finish":
                click(SauceCartConstants.FINISH_BUTTON_CSS);
                break;
        }
    }

    public static void FormularioCheckout(String nombre, String apellido, String areaCode) {
        setInput(SauceCartConstants.NAME_INPUT_XPATH, nombre);
        setInput(SauceCartConstants.APELLIDO_INPUT_XPATH, apellido);
        setInput(SauceCartConstants.AREACODE_INPUT_XPATH, areaCode);
        click(SauceCartConstants.CONTINUE_BUTTON_XPATH);
    }

    public static void verificarPaginaCompraTerminada() {

    }

    public static void verificoAddProdByQuantity(int quantity) {
        List<WebElement> cart_items =
                WebActionManager.getElements(SauceCartConstants.CART_ITEM_CLASS);
        Assert.assertEquals("No hay la misma cantidad de productos en el carrito que los agregados",cart_items.size(),quantity);
    }
}
