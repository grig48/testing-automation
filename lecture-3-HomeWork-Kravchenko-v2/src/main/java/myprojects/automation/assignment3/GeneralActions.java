package myprojects.automation.assignment3;

import myprojects.automation.assignment3.pages.AddCategoryPage;
import myprojects.automation.assignment3.pages.CategoriesAdminPage;
import myprojects.automation.assignment3.pages.DashboardPage;
import myprojects.automation.assignment3.pages.LogginPage;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(EventFiringWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel
     */
    public void login() {
        // Implement logging in to Admin Panel
        open();
        fillEmailInput();
        fillPassInput();
        clickLoginBtn();

//        throw new UnsupportedOperationException();

    }

    /**
     * Close the admin_panel
     */
    public void closeAdminPanel() {
        clickOnUserIcon();
        clickOnExitBtn();
    }

    /**
     * Adds new category in Admin Panel.
     */
    public void createCategory() {
//          Implement logic for new category creation
//          Open "Add category" page
        clickOnAddCategory();
        fillCategoryName();
        clickSaveCategoryBtn();
//          Check for successful category creation
        outputMessageAddCategory();
//          Sort the categories by name in ascending order in the table
        clickSortUpNameCategory();
//          Check for a category in the table
        presentCategoryInTable();
//          Sort the categories by name in descending order in the table
        clickSortDownNameCategory();
//          Check for a category in the table
        presentCategoryInTable();

//        throw new UnsupportedOperationException();

    }


    public void open() {
        driver.get(Properties.getBaseAdminUrl()); }

    public void fillEmailInput() {
        driver.findElement(LogginPage.getEmailInput()).sendKeys(LogginPage.getEmail());
    }

    public void fillPassInput() {
        driver.findElement(LogginPage.getPassInput()).sendKeys(LogginPage.getPassword());
    }

    public void clickLoginBtn() {
        driver.findElement(LogginPage.getLoginBtn()).click();
    }

    /**
     * Opens the user menu
     */
    public void clickOnUserIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPage.getUserIcon()));
        driver.findElement(DashboardPage.getUserIcon()).click();
    }

    /**
     * Closes the admin_panel
     */
    public void clickOnExitBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPage.getExitBtn()));
        driver.findElement(DashboardPage.getExitBtn()).click();
    }

    /**
     * Opens "категории" page
     */
    public void selectCategoriesItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPage.getCatalogTab()));

        WebElement catalogTabElement = driver.findElement(DashboardPage.getCatalogTab());
//          Open submenu "Каталог"
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogTabElement).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPage.getCategoriesSubTab()));
//          Click on the submenu item "категории"
        catalogTabElement.findElements(By.cssSelector("li")).get(1).click();
    }
    /**
     * Open "Add category" page
     */
    public void clickOnAddCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CategoriesAdminPage.getAddCategoryBtn()));
        driver.findElement(CategoriesAdminPage.getAddCategoryBtn()).click();
    }

    /**
     * Fills in the category name field
     */
    public void fillCategoryName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddCategoryPage.getCategoryNameField()));
        driver.findElement(AddCategoryPage.getCategoryNameField()).sendKeys(AddCategoryPage.getCategoryName());
    }

    /**
     * Saves the created category
     */
    public void clickSaveCategoryBtn() {
        driver.findElement(AddCategoryPage.getSaveCategoryBtn()).click();
    }

    /**
     * Checks the fact of creating a new category
     */
    public void outputMessageAddCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddCategoryPage.getMessageAddCategory()));
        if (driver.findElement(AddCategoryPage.getMessageAddCategory()).isDisplayed()) {
            System.out.println();
            System.out.println("Category " + AddCategoryPage.getCategoryName() + " created successfully");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Category " + AddCategoryPage.getCategoryName() + " not created");
            System.out.println();
        }
    }

    /**
     * Sorts categories by name in ascending order in table
     */
    public void clickSortUpNameCategory() {
        driver.findElement(AddCategoryPage.getSortUpNameCategory()).click();
    }

    /**
     * Sorts the categories by name in descending order in the table
     */
    public void clickSortDownNameCategory() {
        driver.findElement(AddCategoryPage.getSortDownNameCategory()).click();
    }

    /**
     * Checks the presence of the created category in the table
     */
    public void presentCategoryInTable() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddCategoryPage.getCategoryInTable()));
        if (driver.findElement(AddCategoryPage.getCategoryInTable()).isDisplayed()) {
            System.out.println();
            System.out.println("Category " + AddCategoryPage.getCategoryName() + " present in table");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Category " + AddCategoryPage.getCategoryName() + " not present in table");
            System.out.println();
        }
    }
    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded

        // wait.until(...);
        // ...
    }

}
