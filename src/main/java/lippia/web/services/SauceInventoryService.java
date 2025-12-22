package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import org.testng.Assert;
import lippia.web.constants.SauceInventoryConstants;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static java.lang.Integer.parseInt;
import static lippia.web.services.SauceLoginService.ingresoUsuYConPorParametros;

public class SauceInventoryService extends ActionManager {

    public static void verificoAppLogo() {
        Assert.assertTrue(isPresent(SauceInventoryConstants.APP_LOGO_CLASS), "No se ve el logo de la app");
    }
    public static void gettingInventoryPage() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
        ingresoUsuYConPorParametros("standard_user", "secret_sauce");
        SauceCartService.clickSaucedemoButton("login");
        SauceInventoryService.verificoAppLogo();
    }

    public static void verificoContadorCarrito(int numero) {
        Assert.assertTrue(isPresent(SauceInventoryConstants.CONTADOR_CARRITO_CLASS), "No se ven cambios en el ícono del carrito");
        String contadorCarrito = getText(SauceInventoryConstants.CONTADOR_CARRITO_CLASS);
        int actual = Integer.parseInt(contadorCarrito);
        Assert.assertEquals(numero, actual, "No se ve el numero esperado en el contador");
    }

    public static void clickRemove() {

        click(SauceInventoryConstants.REMOVE_BUTTON_XPATH);
    }

    public static void verificoContadorCarritoVacio() {
        Assert.assertFalse(isPresent(SauceInventoryConstants.CONTADOR_CARRITO_CLASS), "Se ve número 1 en el ícono del carrito");
    }

    private static final Map<String, Integer> TEXT_NUMBERS;

    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("el primer", 1);
        map.put("un", 1);
        map.put("dos", 2);
        map.put("tres", 3);
        map.put("cuatro", 4);
        map.put("cinco", 5);
        map.put("seis", 6);
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

    private static Integer parseQuantity(String value) {

        if (value.matches("\\d+.*")) {
            return parseInt(value.split(" ")[0]);
        }

        for (String key : TEXT_NUMBERS.keySet()) {
            if (value.startsWith(key)) {
                return TEXT_NUMBERS.get(key);
            }
        }

        return null;
    }

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

    public static void ingresarCarrito() {
        click(SauceInventoryConstants.CART_BUTTON_CLASS);
    }

}

