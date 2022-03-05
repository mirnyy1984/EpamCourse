package utils;

import org.openqa.selenium.WebDriver;


public class WebDriverHandler {

    private WebDriverHandler() {
    }

    public static WebDriver getDriver() {
        return ChromeDriverInitializer.getInstance().getWebDriver();
    }
}
