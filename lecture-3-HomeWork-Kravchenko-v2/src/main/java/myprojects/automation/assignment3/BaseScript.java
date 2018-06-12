package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.EventHandler;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     * @return New instance of {@link WebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            // TODO prepare required WebDriver instance according to browser type
//            case "firefox":
//                System.setProperty(
//                        "webdriver.gecko.driver",
//                        new File(BaseScript.class.getResource("/src/main/resources/geckodriver.exe").getFile()).getPath());
//                return new FirefoxDriver();
//            case "internet explorer":
//                System.setProperty(
//                        "webdriver.ie.driver",
//                        new File(BaseScript.class.getResource("/src/main/resources/IEDriverServer.exe").getFile()).getPath());
//                return new InternetExplorerDriver();
            default:
                String driverPath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
                if (driverPath == null)
                    throw new UnsupportedOperationException("Method doesn't return WebDriver instance");
                System.setProperty("webdriver.chrome.driver", driverPath);
                return new ChromeDriver();
        }
    }

    /**
     * Creates {@link WebDriver} instance with timeout and browser window configurations.
     *
     * @return New instance of {@link EventFiringWebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static EventFiringWebDriver getConfiguredDriver() {
//        Create a simple Webdriver object:
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Create an EventFiringWebDriver object and pass it the created driver object:
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
//        Register EventHandler:
        eventDriver.register(new EventHandler());
        return eventDriver;
    }

//        Close the driver instance
    public static void quiteDriver(WebDriver driver) {
        driver.quit();
    }
}
