package web.page;

import com.codeborne.selenide.Selenide;
import org.bit_cump.framework.utils.EnvironmentUtils;

public class InventoryPage extends MainPage {

    private static final String URL = EnvironmentUtils.URL + "inventory.html";

    public InventoryPage() {
        super(URL);
    }

    private final String INVENTORY_ITEM = "//div[@class='inventory_item']";

    public int getInventoryCount() {
        int count = Selenide.$$x(INVENTORY_ITEM).size();
        log.info("Inventory count is - {}", count);
        return count;
    }


}
