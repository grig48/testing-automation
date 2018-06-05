package myprojects.automation.assignment2.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static myprojects.automation.assignment2.BaseScript.getDriver;

/**
 * Created by grig on 05.06.2018.
 */
public class OpenPage {

    //      Проверка открытия страницы из пункта меню
    public void openPageFromMenu(WebElement element, WebElement titlePage) {
        element.click();
        String titleText = titlePage.getText();
        System.out.println("Открыт раздел " + "\"" + titleText + "\"");
        getDriver().navigate().refresh();
        System.out.println("Все еще открыт раздел " + "\"" + titleText + "\"");
        System.out.println();
    }

    //      Вход в админпанель
    public void openAdminPanel(WebElement elementLogin, String valueLogin, WebElement elementPassword, String valuePassword, WebElement submitButton) {
    //      Вход в админпанель
    //      Ввести адрес E-mail(login)
        elementLogin.sendKeys(valueLogin);
    //      Ввести пароль
        elementPassword.sendKeys(valuePassword);
    //      Нажать кнопка Вход
        submitButton.submit();
    }
}
