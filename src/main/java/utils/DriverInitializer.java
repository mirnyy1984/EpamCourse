package utils;

import org.openqa.selenium.WebDriver;

public interface DriverInitializer {

    WebDriverConfig config = new WebDriverConfig();

    WebDriver getWebDriver();
}
