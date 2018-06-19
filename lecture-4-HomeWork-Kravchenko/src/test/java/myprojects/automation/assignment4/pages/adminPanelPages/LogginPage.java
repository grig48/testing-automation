package myprojects.automation.assignment4.pages.adminPanelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class LogginPage {
    private EventFiringWebDriver driver;

    public LogginPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }
    private static By emailInput = By.id("email");
    private static By passInput = By.id("passwd");
    private static By loginBtn = By.name("submitLogin");


    public void fillEmailInput(String login) {
//        driver.get(Properties.getBaseAdminUrl());
        driver.findElement(emailInput).sendKeys(login);
    }

    public void fillPassInput(String password) {
        driver.findElement(passInput).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

}
