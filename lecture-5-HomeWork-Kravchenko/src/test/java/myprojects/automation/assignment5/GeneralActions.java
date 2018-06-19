package myprojects.automation.assignment5;


import myprojects.automation.assignment5.pages.*;
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

    //  Product name in the Cart
    public static String shopProductNameText;
    //  Product quantity in the shop
    public static String shopProductQtyInt;
    //  Product quantity in the Cart
    public static String cartProductQtyText;
        //  product price in the Cart
    public static String shopProductPriceInt;
    //  Product page URL
    public static String shopProductURL;
    //  Product quantity in the stock
    public static String productInStockText;

    //  Gets product quantity in stock
    public String getProductInStockText() {
        return productInStockText;
    }
        //  Gets product page URL
    public String getShopProductURL() {
        return shopProductURL;
    }

    //  Gets product quantity in the Cart
    public String getCartProductQtyText() {
        return cartProductQtyText;
    }

    public void openRandomProduct() {
        // Implements logic to open random product before purchase
        ShopBasePage shopBasePage = new ShopBasePage(driver);

        //  Opens "Усі товари" page
        shopBasePage.allProductsElement().click();

        //  Opens first product on the page
        AllProductsPage allProductsPage = new AllProductsPage(driver);
        allProductsPage.firstProductElement().click();

//        throw new UnsupportedOperationException();
    }

    /**
     * add product to Cart and validate product information in the Cart
     */
    public void productToCart() {

        //  Gets text from open product property
        //
        ProductPage productPage= new ProductPage(driver);

        //  Gets the product name on the page
        shopProductNameText = productPage.productNameOnPageElement().getText();
        //  Gets the product quantity on the page
        String shopProductQtyText = productPage.productQtyOnPageElement().getAttribute("value");
        //  Gets the product price on the page
        String shopProductPriceText = productPage.productPriceOnPageElement().getText();

        //  Gets the quantity of products in stock
        productPage.productDetailsBtnElement().click();
        productInStockText = productPage.productInStockElement().getAttribute("innerHTML");

        //  Gets current URL
        shopProductURL = driver.getCurrentUrl();

        //  Adds the product to the Cart
        productPage.addToCartElement().click();
        //  Place an order
        wait.until(ExpectedConditions.elementToBeClickable(productPage.placeOrderElement()));
        productPage.placeOrderElement().click();

        //  Gets the text of the product properties in the Cart
        Cart cart =new Cart(driver);
        String cartProductNameText = cart.productNameCartElement().getText();
        cartProductQtyText = cart.productQtyCartElement().getAttribute("value");
        String cartProductPriceText = cart.productPriceCartElement().getText();
        //  Checks the match of the product name to lowercase in the Cart and on the product page
        Assert.assertEquals(cartProductNameText.toLowerCase(), shopProductNameText.toLowerCase(), "The product name does not match the expected");
        //
        //  Checks the match of the product quantity in the Cart and on the product page
        //  Retrieve the numerical value of the product quantity without unnecessary symbols
        String cartProductQtyInt = cartProductQtyText.replaceAll("\\D+","").replaceAll("\\s+", "");
        shopProductQtyInt = shopProductQtyText.replaceAll("\\D+","").replaceAll("\\s+", "");
        Assert.assertEquals(cartProductQtyInt, shopProductQtyInt, "the product quantity does not match the expected");

        //  Checks the match of the product price in the Cart and on the product page
        //
        //  Retrieve the numerical value of the product price without unnecessary symbols
        String cartProductPriceInt = cartProductPriceText.replaceAll("[^-?,0-9]+", " ").replaceAll("\\s+", "");
        shopProductPriceInt = shopProductPriceText.replaceAll("[^-?,0-9]+", " ").replaceAll("\\s+", "");
        Assert.assertEquals(cartProductPriceInt, shopProductPriceInt, "the product price does not match the expected");
        System.out.println("The product properties " + shopProductNameText + " match on the page and in the Cart.");

    }

    /**
     * Fills in the order form.
     */
    public void fillOrder(String name, String surname, String email, String adress, String index, String city) {

        OrderPage orderPage = new OrderPage(driver);

        wait.until(ExpectedConditions.visibilityOf(orderPage.guestNameElement()));
        orderPage.guestNameElement().sendKeys(name);
        orderPage.guestSurnameElement().sendKeys(surname);
        orderPage.guestEmailElement().sendKeys(email);
        orderPage.firstcontinueBtnElement().click();

        wait.until(ExpectedConditions.visibilityOf(orderPage.guestAdressElement()));
        orderPage.guestAdressElement().sendKeys(adress);
        orderPage.guestIndexElement().sendKeys(index);
        orderPage.guestCityElement().sendKeys(city);
        orderPage.secContinueBtnElement().click();

        wait.until(ExpectedConditions.elementToBeClickable(orderPage.thirdContinueBtnElement()));
        orderPage.thirdContinueBtnElement().click();

        orderPage.paymentCheckElement().click();
        orderPage.conditionsElement().click();
        wait.until(ExpectedConditions.elementToBeClickable(orderPage.paymentOrderBtnElement()));
        orderPage.paymentOrderBtnElement().click();

    }

    /**
     * Checks the match of the product properties in the confirmed order and on the product page
     */
    public void confirmOrderCheck() {

        OrderConfirmation orderConfirmation = new OrderConfirmation(driver);

        //  Check confirmed order
        String orderProdConfirmText = orderConfirmation.orderConfirmElement().getText().toLowerCase();
        orderProdConfirmText = orderProdConfirmText.replaceAll("([^а-яґєії`´ʼ’ʼ’]+)", " ").replaceAll("\\s+", "");
        Assert.assertEquals(orderProdConfirmText, "вашезамовленняпідтверджено");

        //  Check confirmed product name
        String orderProductNameText = orderConfirmation.productNameConfirmElement().getText();
        String orderProductQtyText = orderConfirmation.productQtyConfirmElement().getText();
        String orderProductPriceText = orderConfirmation.productPriceConfirmElement().getText();

        //  Check confirmed product quantity
        String orderProductQtyInt = orderProductQtyText.replaceAll("[^-?,0-9]+", " ").replaceAll("\\s+", "");
        Assert.assertEquals(orderProductQtyInt, shopProductQtyInt, "the product quantity does not match the expected");

        //  Check confirmed product price
        String orderProductPriceInt = orderProductPriceText.replaceAll("[^-?,0-9]+", " ").replaceAll("\\s+", "");
        Assert.assertEquals(orderProductPriceInt, shopProductPriceInt, "the product price does not match the expected");
        System.out.println("The product properties " + shopProductNameText + " match on the page and in the order.");

    }

}
