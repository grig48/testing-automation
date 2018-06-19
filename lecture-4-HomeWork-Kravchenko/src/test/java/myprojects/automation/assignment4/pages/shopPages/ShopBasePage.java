package myprojects.automation.assignment4.pages.shopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class ShopBasePage {

    private EventFiringWebDriver driver;

    public ShopBasePage(EventFiringWebDriver driver) {
        this.driver = driver;
    }


    //      "Усі товари" link
    private static By allProducts = By.xpath("//*[@id=\"content\"]/section/a");


    public static By getAllProducts() {
        return allProducts;
    }

    public WebElement allProductsElement() {
        WebElement allProductsEl = driver.findElement(allProducts);
        return allProductsEl;
    }

}
