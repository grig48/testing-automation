package myprojects.automation.assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class OrderPage {

    private EventFiringWebDriver driver;

    public OrderPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //  Guest name
    private static By guestName = By.xpath("//*[@id=\"customer-form\"]//div[2]//input");

    //  Guest surname
    private static By guestSurname = By.xpath("//*[@id=\"customer-form\"]//div[3]//input");

    //  Guest e-mail
    private static By guestEmail = By.xpath("//*[@id=\"customer-form\"]//div[4]//input");

    //  "ПРОДОВЖИТИ" first button
    private static By firstcontinueBtn = By.xpath("//*[@id=\"customer-form\"]/footer/button");

    //  Guest address
    private static By guestAdress = By.xpath("//*[@id=\"delivery-address\"]//div[5]//input");

    //  Guest index
    private static By guestIndex = By.xpath("//*[@id=\"delivery-address\"]//div[7]//input");

    //  Guest city of delivery
    private static By guestCity = By.xpath("//*[@id=\"delivery-address\"]//div[8]//input");

    //  "ПРОДОВЖИТИ" second button
    private static By secContinueBtn = By.xpath("//*[@id=\"delivery-address\"]//footer/button");

    //  "ПРОДОВЖИТИ" third button
    private static By thirdContinueBtn = By.xpath("//*[@id=\"js-delivery\"]/button");

    //  "Оплата чеком"
    private static By paymentCheck = By.xpath("//*[@id=\"payment-option-1\"]");

    //  "Я приймаю умови надання послуг"
    private static By conditions = By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]");

    //  "ЗАМОВЛЕННЯ ІЗ ЗОБОВ'ЯЗАННЯМ ОПЛАТИ" button
    private static By paymentOrderBtn = By.xpath("//*[@id=\"payment-confirmation\"]//button");


    public WebElement guestNameElement() {
        WebElement guestNameEl = driver.findElement(guestName);
        return guestNameEl;
    }

    public WebElement guestSurnameElement() {
        WebElement guestSurnameEl = driver.findElement(guestSurname);
        return guestSurnameEl;
    }

    public WebElement guestEmailElement() {
        WebElement guestEmailEl = driver.findElement(guestEmail);
        return guestEmailEl;
    }

    public WebElement firstcontinueBtnElement() {
        WebElement firstcontinueBtnEl = driver.findElement(firstcontinueBtn);
        return firstcontinueBtnEl;
    }

    public WebElement guestAdressElement() {
        WebElement guestAdressEl = driver.findElement(guestAdress);
        return guestAdressEl;
    }

    public WebElement guestIndexElement() {
        WebElement guestIndexEl = driver.findElement(guestIndex);
        return guestIndexEl;
    }

    public WebElement guestCityElement() {
        WebElement guestCityEl = driver.findElement(guestCity);
        return guestCityEl;
    }

    public WebElement secContinueBtnElement() {
        WebElement secContinueBtnEl = driver.findElement(secContinueBtn);
        return secContinueBtnEl;
    }

    public WebElement thirdContinueBtnElement() {
        WebElement thirdContinueBtnEl = driver.findElement(thirdContinueBtn);
        return thirdContinueBtnEl;
    }

    public WebElement paymentCheckElement() {
        WebElement paymentCheckEl = driver.findElement(paymentCheck);
        return paymentCheckEl;
    }

    public WebElement conditionsElement() {
        WebElement conditionsEl = driver.findElement(conditions );
        return conditionsEl;
    }

    public WebElement paymentOrderBtnElement() {
        WebElement paymentOrderBtnEl = driver.findElement(paymentOrderBtn);
        return paymentOrderBtnEl;
    }

}
