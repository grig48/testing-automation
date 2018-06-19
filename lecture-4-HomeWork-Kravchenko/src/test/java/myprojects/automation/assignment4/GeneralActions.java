package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.ProductProperties;
import myprojects.automation.assignment4.pages.adminPanelPages.CreateNewProductPage;
import myprojects.automation.assignment4.pages.adminPanelPages.DashboardPage;
import myprojects.automation.assignment4.pages.adminPanelPages.LogginPage;
import myprojects.automation.assignment4.pages.adminPanelPages.ProductsPage;
import myprojects.automation.assignment4.pages.shopPages.NewProductPage;
import myprojects.automation.assignment4.pages.shopPages.ShopBasePage;
import myprojects.automation.assignment4.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


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
     * Logs in to Admin Panel.
     */
    public void login(String login, String password) {

        driver.get(Properties.getBaseAdminUrl());

        LogginPage logginPage = new LogginPage(driver);
        logginPage.fillEmailInput(login);
        logginPage.fillPassInput(password);
        logginPage.clickLoginBtn();
    }

    /**
     * Opens "товары" page
     */
    public void selectProductsItem() {

        DashboardPage dashboardPage = new DashboardPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPage.getCatalogTab()));
        //  Open submenu "Каталог"
        Actions actions = new Actions(driver);
        actions.moveToElement(dashboardPage.catalogTabElement()).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPage.getCategoriesSubTab()));
        //  Click on the submenu item "товары"
        dashboardPage.catalogTabElement().findElements(By.cssSelector("li")).get(0).click();
    }

    /**
     * Open "товары" page
     */
    public void clickNewProductBtn() {

        ProductsPage productsPage = new ProductsPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPage.getNewProductBtn()));
        productsPage.newProductBtnElement().click();
    }

    /**
     * Implement product creation scenario
     */
    public void createProduct() {

        CreateNewProductPage createNewProductPage = new CreateNewProductPage(driver);

        //  Checks the presence of a field for entering the name of the product
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateNewProductPage.getProductNameField()));

        //  Gets product properties
        String productName = ProductProperties.getProductName();
        String productQuantity = ProductProperties.getProductQuantity();
        String productPrice = ProductProperties.getProductPrice();

        //  Fills in the input fields of product properties
        createNewProductPage.productNameFieldElement().sendKeys(productName);
        createNewProductPage.quantityProductFieldElement().sendKeys(productQuantity);
        createNewProductPage.priceProductFieldElement().sendKeys(productPrice);

        //  Activates product
        wait.until(ExpectedConditions.elementToBeClickable(CreateNewProductPage.getActivBtn()));
        createNewProductPage.activBtnElement().click();

        //  Saves product
        wait.until(ExpectedConditions.elementToBeClickable(CreateNewProductPage.getSaveProductBtn()));
        createNewProductPage.saveProductBtnElement().click();
    }

    /**
     * Checking the product display.
     */
    public void productDisplay() {
        //  Opens shop page
        driver.get(Properties.getBaseUrl());

        ShopBasePage shopBasePage = new ShopBasePage(driver);

        //  Opens "Усі товари" page
        shopBasePage.allProductsElement().click();

        //  Gets new product properties
        String productName = ProductProperties.getProductName();
        String productQuantity = ProductProperties.getProductQuantity();
        String productPrice = ProductProperties.getProductPrice();

        //  Finds a new product by name on the page
        WebElement newProduct = driver.findElement(By.linkText(productName));
        //  Checks the name of the displayed product to match the name of the new product
        String newProductText = newProduct.getText();
        Assert.assertEquals(productName, newProductText, "This product is not on the page");

        //  Opens new product page
        newProduct.click();

        NewProductPage newProductPage = new NewProductPage(driver);

        //  Gets text from new product property
        String shopProductNameText = newProductPage.productNameOnPageElement().getText();
        String shopProductQtyText = newProductPage.productQtyOnPageElement().getText();
        String shopProductPriceText = newProductPage.productPriceOnPageElement().getText();

        //  Check product name to lowercase on the product page
        Assert.assertEquals(productName.toLowerCase(), shopProductNameText.toLowerCase(), "The product name does not match the expected");

        //  Check product quantity on the product page
        //
        //  Retrieve the numerical value of the product quantity without unnecessary symbols
        String shopProductQtyInt = shopProductQtyText.replaceAll("\\D+","");
        Assert.assertEquals(productQuantity, shopProductQtyInt, "the product quantity does not match the expected");

        //  Check product price on the product page
        //
        //  Retrieve the numerical value of the product price without unnecessary symbols
        String shopProductPriceInt = shopProductPriceText.replaceAll("[^-?,0-9]+", " ").replaceAll("\\s+", "");
        Assert.assertEquals(productPrice, shopProductPriceInt, "the product price does not match the expected");
        System.out.println("The product properties " + productName + " is displayed correctly on the page.");

    }

}
