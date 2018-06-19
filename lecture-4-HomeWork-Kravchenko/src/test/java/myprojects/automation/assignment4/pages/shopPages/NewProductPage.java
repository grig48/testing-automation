package myprojects.automation.assignment4.pages.shopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class NewProductPage {

    private EventFiringWebDriver driver;

    public NewProductPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //   название продукта
    private static By productNameOnPage = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/h1");
    //  количество продукта
    private static By productQtyOnPage = By.xpath("//*[@id=\"product-details\"]/div[1]/span");
    //  цена продукта
    private static By productPriceOnPage = By.xpath("//div[@class=\"product-prices\"]//span");


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
}
