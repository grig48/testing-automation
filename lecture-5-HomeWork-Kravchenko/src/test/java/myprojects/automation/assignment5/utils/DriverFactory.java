package myprojects.automation.assignment5.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    /**
     *
     * @param browser Driver type to use in tests.
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver initDriver(String browser) {
//            switch (browser) {
//            case "firefox":
//                System.setProperty(
//                        "webdriver.gecko.driver",
//                        new File(DriverFactory.class.getResource("/geckodriver.exe").getFile()).getPath());
//                return new FirefoxDriver();
//            case "ie":
//            case "internet explorer":
//                System.setProperty(
//                        "webdriver.ie.driver",
//                        new File(DriverFactory.class.getResource("/IEDriverServer.exe").getFile()).getPath());
//                InternetExplorerOptions ieOptions = new InternetExplorerOptions()
//                        .destructivelyEnsureCleanSession();
//                ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
//                return new InternetExplorerDriver(ieOptions);
//            case "headless-chrome":
//                System.setProperty(
//                        "webdriver.chrome.driver",
//                        new File(DriverFactory.class.getResource("/chromedriver.exe").getFile()).getPath());
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("headless");
//                options.addArguments("window-size=800x600");
//                return new ChromeDriver();
//            case "remote-chrome":
//                ChromeOptions optionsRemote = new ChromeOptions();
//                try {
//                    return new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), optionsRemote);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            case "mobile":
//                System.setProperty(
//                        "webdriver.chrome.driver",
//                        new File(DriverFactory.class.getResource("/chromedriver.exe").getFile()).getPath());
//                Map<String, String> mobileEmulation = new HashMap<>();
//                mobileEmulation.put("deviceName", "iPhone 6");
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//                return new ChromeDriver(chromeOptions);
//            case "chrome":
//            default:
//                System.setProperty(
//                        "webdriver.chrome.driver",
//                        new File(DriverFactory.class.getResource("/chromedriver.exe").getFile()).getPath());
//                return new ChromeDriver();

        switch (browser) {
            case "firefox":
                System.setProperty(
                        "webdriver.gecko.driver",
                        getResource("/geckodriver.exe"));
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
                System.setProperty(
                        "webdriver.ie.driver",
                        getResource("/IEDriverServer.exe"));
                return new InternetExplorerDriver();
            case "chrome":
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        getResource("/chromedriver.exe"));
                return new ChromeDriver();

        }
    }

    /**
     * @param resourceName The name of the resource
     * @return Path to resource
     */
    private static String getResource(String resourceName) {
        try {
            return Paths.get(DriverFactory.class.getResource(resourceName).toURI()).toFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourceName;
    }


    /**
     *
     * @param browser Remote driver type to use in tests.
     * @param gridUrl URL to Grid.
     * @return New instance of {@link RemoteWebDriver} object.
     */
//    public static WebDriver initDriver(String browser, String gridUrl) {
//        // TODO prepare capabilities for required browser and return RemoteWebDriver instance
//        throw new UnsupportedOperationException();
//    }
}
