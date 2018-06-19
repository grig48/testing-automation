package myprojects.automation.assignment4.pages.adminPanelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DashboardPage {
    private EventFiringWebDriver driver;

    public DashboardPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //      The menu item "Каталог"
    private static By catalogTab = By.id("subtab-AdminCatalog");
    //      The submenu item "категории"
    private static By categoriesSubTab = By.id("subtab-AdminCategories");


    public static By getCatalogTab() {
        return catalogTab;
    }

    public static By getCategoriesSubTab() {
        return categoriesSubTab;
    }

    public WebElement catalogTabElement() {
        WebElement catalogTabEl = driver.findElement(catalogTab);
        return catalogTabEl;
    }

}
