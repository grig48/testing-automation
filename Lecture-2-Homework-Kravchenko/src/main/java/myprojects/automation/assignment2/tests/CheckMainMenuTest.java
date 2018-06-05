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
public class CheckMainMenuTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String urlAdminPanel = Properties.getBaseAdminUrl();
        driver.get(urlAdminPanel);

        OpenPage openPage = new OpenPage();

//          Карта элементов
//          Вход в админпанель
        WebElement login = driver.findElement(By.xpath("//input[contains(@id,'email')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@id,'passwd')]"));
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        String valueLogin = "webinar.test@gmail.com";
        String valuePassword = "Xcg7299bnSmMuRLp9ITw";
//          Тесты
//          Открыть админпанель
        openPage.openAdminPanel(login, valueLogin, password, valuePassword, submitButton);
//          Пункты меню
//          Проверка раздела "Заказы"
        WebElement orders = driver.findElement(By.id("subtab-AdminParentOrders"));
        WebElement titleOrders = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Заказы')]"));
        openPage.openPageFromMenu(orders, titleOrders);
//          Проверка раздела "Каталог"
        WebElement catalog = driver.findElement(By.id("subtab-AdminCatalog"));
        WebElement titleCatalog = driver.findElement(By.xpath("//div[contains(@class,'header-toolbar')]/h2[contains(text(),'товары')]"));
        openPage.openPageFromMenu(catalog, titleCatalog);
//          Проверка раздела "Клиенты"
        WebElement customer = driver.findElement(By.id("subtab-AdminParentCustomer"));
        WebElement titleCustomer = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Управление клиентами')]"));
        openPage.openPageFromMenu(customer, titleCustomer);
//          Проверка раздела "Служба поддержки"
        WebElement customerThreads = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
        WebElement titleCustomerThreads = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Customer Service')]"));
        openPage.openPageFromMenu(customerThreads, titleCustomerThreads);
//          Проверка раздела "Статистика"
        WebElement stats = driver.findElement(By.id("subtab-AdminStats"));
        WebElement titleStats = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Статистика')]"));
        openPage.openPageFromMenu(stats, titleStats);
//          Проверка раздела "Modules"
        WebElement modules = driver.findElement(By.id("subtab-AdminParentModulesSf"));
        WebElement titleModules = driver.findElement(By.xpath("//div[contains(@class,'header-toolbar')]/h2[contains(text(),'Выбор модуля')]"));
        openPage.openPageFromMenu(modules, titleModules);
//          Проверка раздела "Design"
        WebElement themes = driver.findElement(By.id("subtab-AdminParentThemes"));
        WebElement titleThemes = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Шаблоны > Шаблон')]"));
        openPage.openPageFromMenu(themes, titleThemes);
//          Проверка раздела "Доставка"
        WebElement shipping = driver.findElement(By.id("subtab-AdminParentShipping"));
        WebElement titleShipping = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Перевозчики')]"));
        openPage.openPageFromMenu(shipping, titleShipping);
//          Проверка раздела "Способ оплаты"
        WebElement payment = driver.findElement(By.id("subtab-AdminParentPayment"));
        WebElement titlePayment = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Payment Methods')]"));
        openPage.openPageFromMenu(payment, titlePayment);
//          Проверка раздела "International"
        WebElement international = driver.findElement(By.id("subtab-AdminInternational"));
        WebElement titleInternational = driver.findElement(By.xpath("//div[contains(@class,'page-head with-tabs')]/h2[contains(text(),'Локализация')]"));
        openPage.openPageFromMenu(international, titleInternational);
//          Проверка раздела "Shop Parameters"
        WebElement shopParameters = driver.findElement(By.id("subtab-ShopParameters"));
        WebElement titleShopParameters = driver.findElement(By.xpath("//div[contains(@class,'page-head with-tabs')]/h2[contains(text(),'General')]"));
        openPage.openPageFromMenu(shopParameters, titleShopParameters);
//          Проверка раздела "Конфигурация"
        WebElement advancedParameters = driver.findElement(By.id("subtab-AdminAdvancedParameters"));
        WebElement titleAdvancedParameters = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Information')]"));
        openPage.openPageFromMenu(advancedParameters, titleAdvancedParameters);
//          Проверка раздела "Dashboard"
        WebElement dashboard = driver.findElement(By.id("tab-AdminDashboard"));
        WebElement titleDashboard = driver.findElement(By.xpath("//div[contains(@class,'page-head')]/h2[contains(text(),'Пульт')]"));
        openPage.openPageFromMenu(dashboard, titleDashboard);
    }
}
