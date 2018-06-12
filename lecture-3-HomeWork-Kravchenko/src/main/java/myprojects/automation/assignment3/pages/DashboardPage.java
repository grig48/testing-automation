package myprojects.automation.assignment3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DashboardPage {
    private EventFiringWebDriver driver;

    //      The avatar of the user
    private static By userIcon = By.id("employee_infos");
    //      "Выход" button
    private static By exitBtn = By.id("header_logout");
    //      The menu item "Каталог"
    private static By catalogTab = By.id("subtab-AdminCatalog");
    //      The submenu item "категории"
    private static By categoriesSubTab = By.id("subtab-AdminCategories");

    public static By getUserIcon() {
        return userIcon;
    }

    public static By getExitBtn() {
        return exitBtn;
    }

    public static By getCatalogTab() {
        return catalogTab;
    }

    public static By getCategoriesSubTab() {
        return categoriesSubTab;
    }

}
