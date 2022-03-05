package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverInitializer implements DriverInitializer {

    private static volatile ChromeDriverInitializer INSTANCE;
    private ChromeOptions options = new ChromeOptions();
    private WebDriver driver;


    private ChromeDriverInitializer() {
        WebDriverManager.chromedriver().setup();

        driver = setLocalWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait());
        driver.manage().timeouts().pageLoadTimeout(config.getPageLoadTimeout());
        driver.manage().timeouts().scriptTimeout(config.getScriptTimeout());
    }


    public static ChromeDriverInitializer getInstance() {
        if (INSTANCE == null) {
            synchronized (ChromeDriverInitializer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ChromeDriverInitializer();
                }
            }
        }
        return INSTANCE;
    }


    private WebDriver setLocalWebDriver() {
        return new ChromeDriver(options);
    }


    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
