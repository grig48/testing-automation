package myprojects.automation.assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class ProductPage {

    private EventFiringWebDriver driver;

    public ProductPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //  "Деталі товару" button
    private static By productDetailsBtn = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[2]/div[3]//li[2]/a");
    //  The quantity of products in stock
    private static By productInStock = By.xpath("//*[@id=\"product-details\"]/div[3]/span");
    //  Product name
    private static By productNameOnPage = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/h1");
    //  Quantity product
    private static By productQtyOnPage = By.xpath("//*[@id=\"quantity_wanted\"]");
    //  Price product
    private static By productPriceOnPage = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]//span");
    //  "У кошик" button
    private static By addToCart = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]//div[2]/button");
    //  "Оформити замовлення" button
    private static By placeOrder = By.xpath("//*[@id=\"blockcart-modal\"]//a");

    public WebElement productDetailsBtnElement() {
        WebElement productDetailsBtnEl = driver.findElement(productDetailsBtn);
        return productDetailsBtnEl;
    }

    public WebElement productInStockElement() {
        WebElement productInStockEl = driver.findElement(productInStock);
        return productInStockEl;
    }
    public WebElement productNameOnPageElement() {
        WebElement productNameOnPageEl = driver.findElement(productNameOnPage);
        return productNameOnPageEl;
    }

    public WebElement productQtyOnPageElement() {
        WebElement productQtyOnPageEl = driver.findElement(productQtyOnPage);
        return productQtyOnPageEl;
    }

    public WebElement productPriceOnPageElement() {
        WebElement productPriceOnPageEl = driver.findElement(productPriceOnPage);
        return productPriceOnPageEl;
    }

    public WebElement addToCartElement() {
        WebElement addToCartEl = driver.findElement(addToCart);
        return addToCartEl;
    }

    public WebElement placeOrderElement() {
        WebElement placeOrderEl = driver.findElement(placeOrder);
        return placeOrderEl;
    }
}
