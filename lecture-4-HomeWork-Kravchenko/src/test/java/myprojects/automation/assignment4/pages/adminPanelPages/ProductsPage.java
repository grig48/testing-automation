package myprojects.automation.assignment4.pages.adminPanelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class ProductsPage {

    private EventFiringWebDriver driver;

    public ProductsPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //      "новый товар" button
    private static By newProductBtn = By.id("page-header-desc-configuration-add");


    public static By getNewProductBtn() {
        return newProductBtn;
    }

    public WebElement newProductBtnElement() {
        WebElement newProdBtnEl = driver.findElement(newProductBtn);
        return newProdBtnEl;
    }

}

