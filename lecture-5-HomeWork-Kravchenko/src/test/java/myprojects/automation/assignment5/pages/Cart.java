package myprojects.automation.assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Cart {

    private EventFiringWebDriver driver;

    public Cart(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //  Product name
    private static By productNameCart = By.xpath("//*[@id=\"main\"]//div[1]/div[1]/div[2]//div[2]/div[1]/a");
    //  Quantity product
    private static By productQtyCart = By.xpath("//*[@id=\"main\"]//input");
    //  Price product
    private static By productPriceCart = By.xpath("//*[@id=\"main\"]//div[2]/div[2]/span");
    //  Quantity of items in the cart
    private static By qtyItemsCart = By.xpath("//*[@id=\"cart-subtotal-products\"]/span[1]");
    //  "ОФОРМИТИ ЗАМОВЛЕННЯ" button
    private static By placeOrderCart = By.xpath("//*[@id=\"main\"]//div[2]/div/div[2]//a");

    public WebElement productNameCartElement() {
        WebElement productNameCartEl = driver.findElement(productNameCart);
        return productNameCartEl;
    }

    public WebElement productQtyCartElement() {
        WebElement productQtyCartEl = driver.findElement(productQtyCart);
        return productQtyCartEl;
    }

    public WebElement productPriceCartElement() {
        WebElement productPriceCartEl = driver.findElement(productPriceCart);
        return productPriceCartEl;
    }

    public WebElement qtyItemsCartElement() {
        WebElement qtyItemsCartEl = driver.findElement(qtyItemsCart);
        return qtyItemsCartEl;
    }

    public WebElement placeOrderCartElement() {
        WebElement placeOrderCartEl = driver.findElement(placeOrderCart);
        return placeOrderCartEl;
    }

}
