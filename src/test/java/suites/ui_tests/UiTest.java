package suites.ui_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.base.BasePage;
import pages.base.HomePage;
import utils.WebDriverHandler;


public class UiTest extends UiTestSuite {

    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;


    @BeforeClass()
    public void initObjects() {
        initPages();
    }


    @BeforeMethod()
    public void prepareTest() {
        basePage.openHomePage(projectEnvLabel);
    }


    @BeforeTest()
    public void setBasePage() {
        driver = WebDriverHandler.getDriver();
        basePage = new BasePage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    protected void initPages() {
        initHomePage();
    }


    protected void initHomePage() {
        homePage = basePage.getInstance(HomePage.class);
    }
}
