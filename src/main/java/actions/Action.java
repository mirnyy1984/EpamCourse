package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Action {

    protected WebDriver driver;
    public WebDriverWait wait;

    public Action(WebDriver driver) {
        this.driver = driver;
        this.wait = setWebDriverWait();
    }


    private WebDriverWait setWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(1000));
        return wait;
    }


    public void waitForPageLoaded() {
        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
    }
}
