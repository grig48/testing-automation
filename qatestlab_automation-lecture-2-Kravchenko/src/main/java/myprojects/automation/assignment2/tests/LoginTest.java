package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
// Открыть админпанель
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
// Ввести адрес E-mail
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
// Ввести пароль
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
// Нажать кнопка Вход
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.submit();
// Выход из админпанели
        WebElement avatarSmall = driver.findElement(By.id("header_employee_box"));
        avatarSmall.click();
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();




    }
}
