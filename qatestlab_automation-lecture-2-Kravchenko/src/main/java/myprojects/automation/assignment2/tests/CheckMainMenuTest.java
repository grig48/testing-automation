package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class CheckMainMenuTest extends BaseScript{

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
//  Открыть раздел "Заказы"
        WebElement orders = driver.findElement(By.id("subtab-AdminParentOrders"));
        orders.click();
//  Проверить открытие раздела "Заказы"
        String sameText = driver.findElement(By.linkText("Заказы")).getText();
        System.out.println("Открыт раздел " + "\"" + sameText + "\"");
//  Обновить страницу и снова проверить открытие раздела "Заказы"
        driver.navigate().refresh();
        sameText = driver.findElement(By.linkText("Заказы")).getText();
        System.out.println("Все еще открыт раздел " + "\"" + sameText + "\"" );
        System.out.println();
//  Проверить открытие раздела "Каталог"
//  Проверить открытие раздела "Клиенты"
//  Проверить открытие раздела "Служба поддержки"
//  Проверить открытие раздела "Статистика"
//
//
//
//
//
//
//
//
//
//Boolean check = Assert.assertTrue("Пример текста" == "Пример текста");
    }

}
//xpath=//form[@name='second_form']/input[contains(@name,'sample_name');
