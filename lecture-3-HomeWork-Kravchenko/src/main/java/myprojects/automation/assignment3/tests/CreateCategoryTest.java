package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        EventFiringWebDriver driver = getConfiguredDriver();

//          Open the admin_panel
        GeneralActions generalActions = new GeneralActions(driver);
        generalActions.login();

//          Open the page "Категории"
        generalActions.selectCategoriesItem();

//          Add the category
        generalActions.createCategory();

//          Close the admin_panel
        generalActions.closeAdminPanel();

//          Close driver
        quiteDriver(driver);

    }
}
