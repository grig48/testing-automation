package myprojects.automation.assignment4.pages.adminPanelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class CreateNewProductPage {

    private EventFiringWebDriver driver;

    public CreateNewProductPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //      "Укажите название товара" field for entering product name
    private static By productNameField = By.id("form_step1_name_1");
    //      "Количество" field for entering quantity of product
    private static By quantityProductField = By.id("form_step1_qty_0_shortcut");
    //      "Цена" field for entering price of product
    private static By priceProductField = By.id("form_step1_price_ttc_shortcut");
    //      "Не в сети" button
    private static By activBtn = By.xpath("//*[@id=\"form\"]/div[4]/div[1]/div");
    //      "Сохранить" button
    private static By saveProductBtn = By.id("submit");


    public static By getProductNameField() {
        return productNameField;
    }

    public static By getActivBtn() {
        return activBtn;
    }

    public static By getSaveProductBtn() {
        return saveProductBtn;
    }

    public WebElement productNameFieldElement() {
        WebElement   productNameFieldEl = driver.findElement(productNameField);
        return  productNameFieldEl;
    }

    public WebElement quantityProductFieldElement() {
        WebElement quantityProductFieldEl = driver.findElement(quantityProductField);
        return quantityProductFieldEl;
    }

    public WebElement priceProductFieldElement() {
        WebElement priceProductFieldEl = driver.findElement(priceProductField);
        return priceProductFieldEl;
    }

    public WebElement activBtnElement() {
        WebElement activBtnEl = driver.findElement(activBtn);
        return activBtnEl;
    }

    public WebElement saveProductBtnElement() {
        WebElement saveProductBtnEl = driver.findElement(saveProductBtn);
        return saveProductBtnEl;
    }

}




