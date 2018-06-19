package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.pages.adminPanelPages.LoginDataProvider;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

    //  Creates new product on website
    @Test(dataProvider = "log-in", dataProviderClass = LoginDataProvider.class)
    public void createNewProduct(String login, String password) {
        // Implement test for product creation
        actions.login(login, password);
        actions.selectProductsItem();
        actions.clickNewProductBtn();
        actions.createProduct();

    }
    // Implements logic to check product visibility on website
    @Test(dependsOnMethods="createNewProduct")
    public void checkProductDisplay() {
        actions.productDisplay();
    }




}
