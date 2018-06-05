package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.OpenPage;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
/**
 * Created by Grigorij Kravchenko on 05.06.2018.
 * Homework to lecture_2
 */
public class LoginTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String urlAdminPanel = Properties.getBaseAdminUrl();
        driver.get(urlAdminPanel);

        OpenPage openPage = new OpenPage();

        WebElement login = driver.findElement(By.xpath("//input[contains(@id,'email')]"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        String valueLogin = "webinar.test@gmail.com";
        String valuePassword = "Xcg7299bnSmMuRLp9ITw";
//        Тест log_in и log_out
//        Открыть админпанель
        openPage.openAdminPanel(login, valueLogin, password, valuePassword, submitButton);
//         Выход из админпанели
        WebElement avatarSmall = driver.findElement(By.id("header_employee_box"));
        avatarSmall.click();
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
    }
}
