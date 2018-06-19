package myprojects.automation.assignment5.tests;

import myprojects.automation.assignment5.BaseTest;
import myprojects.automation.assignment5.model.GuestDataProvider;
import myprojects.automation.assignment5.pages.Cart;
import myprojects.automation.assignment5.pages.ProductPage;
import myprojects.automation.assignment5.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void checkSiteVersion() {
        // TODO open main page and validate website version
        //  Opens main page
//        driver.get(Properties.getBaseUrl());

    }

    @Test(dataProvider = "Guest", dataProviderClass = GuestDataProvider.class)
    public void createNewOrder(String name, String surname, String email, String adress, String index, String city) {
        // TODO implement order creation test
        driver.get(Properties.getBaseUrl());

        // open random product

        actions.openRandomProduct();

        // add product to Cart and validate product information in the Cart

        actions.productToCart();

        // proceed to order creation, fill required information

        Cart cart = new Cart(driver);
        cart.placeOrderCartElement().click();
        actions.fillOrder(name, surname, email, adress, index, city);

        // place new order and validate order summary

        actions.confirmOrderCheck();

        // check updated In Stock value

        driver.navigate().to(actions.getShopProductURL());

        ProductPage productPage= new ProductPage(driver);
        productPage.productDetailsBtnElement().click();

        String beforeProductInStockInt = actions.getProductInStockText().replaceAll("\\D+","").replaceAll("\\s+", "");
        //  Gets the quantity of products in stock
        String afterProductInStockText = actions.productInStockText = productPage.productInStockElement().getAttribute("innerHTML");
        String afterProductInStockInt = afterProductInStockText.replaceAll("\\D+","").replaceAll("\\s+", "");

        String inCartProductQtyText = actions.getCartProductQtyText().replaceAll("\\D+","").replaceAll("\\s+", "");

        int beforeStock = Integer.parseInt(beforeProductInStockInt);
        int afterStock = Integer.parseInt(afterProductInStockInt);
        int inCart = Integer.parseInt(inCartProductQtyText);

        beforeStock = beforeStock - inCart;

        Assert.assertEquals(beforeStock, afterStock, "The quantity of the products in the stock not decreased by the quantity of the products in the Cart");
    }

}
