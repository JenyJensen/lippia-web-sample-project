package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import junit.framework.Assert;
import lippia.web.constants.SauceInventoryConstants;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SauceInventoryService extends ActionManager {
    public static void verificoAppLogo() {
        junit.framework.Assert.assertTrue("No se ve el logo de la app", isPresent(SauceInventoryConstants.APP_LOGO_CLASS));
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

    private static final Map<String, Integer> TEXT_NUMBERS;
    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("un", 1);
        map.put("dos", 2);
        map.put("tres", 3);
        map.put("cuatro", 4);
        map.put("cinco", 5);
        TEXT_NUMBERS = Collections.unmodifiableMap(map);
    }

    public static void agregoProductosAlCarrito(String producto) {

        String value = producto.toLowerCase().trim();

        Integer quantity = parseQuantity(value);

        if (quantity != null) {
            addFirstNProducts(quantity);
        } else {
            addProductByName(producto);
        }
    }

    // -------------------------------
    // Detecta cantidad (número o texto)
    // -------------------------------
    private static Integer parseQuantity(String value) {

        // "2 productos"
        if (value.matches("\\d+.*")) {
            return Integer.parseInt(value.split(" ")[0]);
        }

        // "dos productos"
        for (String key : TEXT_NUMBERS.keySet()) {
            if (value.startsWith(key)) {
                return TEXT_NUMBERS.get(key);
            }
        }

        return null;
    }

    // -------------------------------
    // Agrega N primeros productos
    // -------------------------------
    private static void addFirstNProducts(int quantity) {

        List<WebElement> buttons =
                WebActionManager.getElements(SauceInventoryConstants.ADD_TO_CART_XPATH);

        if (buttons.size() < quantity) {
            throw new RuntimeException("No hay suficientes productos");
        }

        for (int i = 0; i < quantity; i++) {
            buttons.get(i).click();
        }
    }

    // -------------------------------
    // Agrega un producto por nombre
    // -------------------------------
    public static void addProductByName(String productName) {

        List<WebElement> names =
                WebActionManager.getElements(SauceInventoryConstants.PRODUCT_NAME_CSS);

        List<WebElement> buttons =
                WebActionManager.getElements(SauceInventoryConstants.ADD_TO_CART_XPATH);

        for (int i = 0; i < names.size(); i++) {

            String name = names.get(i).getText().trim();

            if (name.equalsIgnoreCase(productName.trim())) {
                buttons.get(i).click();
                return;
            }
        }

        throw new RuntimeException(
                "No se encontró el producto: " + productName);
    }

}

