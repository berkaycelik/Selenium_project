package Utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestBase {
    private static WebDriver driver;
    public String currentUrl = ("https://www.gittigidiyor.com/");
    public Logger log = LogManager.getLogger(getClass().getName());

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TestBase.driver = driver;
    }
}
