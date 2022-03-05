package pages.base;

import actions.Action;
import constants.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    protected WebDriver driver;
    protected Action action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
    }


    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public HomePage openHomePage(String projectEnv) {
        driver.get(BaseUrl.getBaseUrl(projectEnv));
        action.waitForPageLoaded();
        return getInstance(HomePage.class);
    }
}
