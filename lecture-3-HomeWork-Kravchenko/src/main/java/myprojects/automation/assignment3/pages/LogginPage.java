package myprojects.automation.assignment3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LogginPage {
    private EventFiringWebDriver driver;

    private static By emailInput = By.id("email");
    private static By passInput = By.id("passwd");
    private static By loginBtn = By.name("submitLogin");
    private static String Email = "webinar.test@gmail.com";
    private static String Password = "Xcg7299bnSmMuRLp9ITw";

    public static By getEmailInput() {
        return emailInput;
    }

    public static By getPassInput() {
        return passInput;
    }

    public static By getLoginBtn() {
        return loginBtn;
    }

    public static String getEmail() {
        return Email;
    }

    public static String getPassword() {
        return Password;
    }

}
