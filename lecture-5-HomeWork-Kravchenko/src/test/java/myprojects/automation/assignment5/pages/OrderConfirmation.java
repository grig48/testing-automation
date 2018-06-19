package myprojects.automation.assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class OrderConfirmation {

    private EventFiringWebDriver driver;

    public OrderConfirmation(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //  "ВАШЕ ЗАМОВЛЕННЯ ПІДТВЕРДЖЕНО"
    private static By orderConfirm = By.xpath("//*[@id=\"content-hook_order_confirmation\"]//h3");
    //  Product name
    private static By productNameConfirm = By.xpath("//*[@id=\"order-items\"]//div[2]/span");
    //  Quantity product
    private static By productQtyConfirm = By.xpath("//*[@id=\"order-items\"]//div[3]//div[2]");
    //  Price product
    private static By productPriceConfirm = By.xpath("//*[@id=\"order-items\"]//div[3]/div/div[1]");

    public WebElement orderConfirmElement() {
        WebElement orderConfirmEl = driver.findElement(orderConfirm);
        return orderConfirmEl;
    }

    public WebElement productNameConfirmElement() {
        WebElement productNameConfirmEl = driver.findElement(productNameConfirm);
        return productNameConfirmEl;
    }

    public WebElement productQtyConfirmElement() {
        WebElement productQtyConfirmEl = driver.findElement(productQtyConfirm);
        return productQtyConfirmEl;
    }

    public WebElement productPriceConfirmElement() {
        WebElement productPriceConfirmEl = driver.findElement(productPriceConfirm);
        return productPriceConfirmEl;
    }

}
