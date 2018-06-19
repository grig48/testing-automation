package myprojects.automation.assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class AllProductsPage {

    private EventFiringWebDriver driver;

    public AllProductsPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }


    //      "Усі товари" link
    private static By firstProduct = By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a");


    public static By getfirstProduct() {
        return firstProduct;
    }

    public WebElement firstProductElement() {
        WebElement firstProductEl = driver.findElement(firstProduct);
        return firstProductEl;
    }
}
