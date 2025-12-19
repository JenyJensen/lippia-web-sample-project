package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import lippia.web.constants.SauceCartConstants;
import lippia.web.constants.SauceInventoryConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SauceCartService extends ActionManager {

    public static void clickCheckout(String nombreBoton) {
        if (nombreBoton.contains("checkout")){
        click(SauceCartConstants.CHECKOUT_BUTTON_CSS);
    }else if (nombreBoton.contains("finish")){
            click(SauceCartConstants.FINISH_BUTTON_CSS);
        }
    }

    public static void FormularioCheckout(String nombre, String apellido, String areaCode) {
        setInput(SauceCartConstants.NAME_INPUT_ID, nombre);
        setInput(SauceCartConstants.APELLIDO_INPUT_ID, apellido);
        setInput(SauceCartConstants.AREACODE_INPUT_ID, areaCode);
        click(SauceCartConstants.CONTINUE_BUTTON_ID);
    }

    public static void verificarPaginaCompraTerminada() {
        Assert.assertTrue(isPresent(SauceCartConstants.CHECKOUT_COMPLETE_ID), "No se ve cartel con texto Thank you for your order!");
    }

    public static void verificarOverview() {
        int cantidadBadge = Integer.parseInt(
                getText(SauceInventoryConstants.CONTADOR_CARRITO_CLASS)
        );
        Assert.assertEquals(cantidadBadge, getElements(SauceCartConstants.CART_ITEM_CLASS).size(), "No hay la misma cantidad de productos en el icono del cart badge que en el overview");
        Assert.assertEquals(getText(SauceCartConstants.TITLE_OVERVIEW_CSS), "Checkout: Overview", "No se ve el titulo de la pagina de Overview");
    }
}
