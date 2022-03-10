package suites.ui_tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.base.BasePage;
import pages.base.HomePage;
import reporters.TestResult;
import reporters.utils.TestResultStatusDefiner;
import testrail.TestTRunType;
import utils.WebDriverHandler;


public class UiTest extends UiTestSuite {

    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;


    @BeforeClass()
    public void initObjects() {
        initPages();
    }


    @BeforeMethod
    public void prepareTest() {
        basePage.openHomePage(projectEnvLabel);
    }


    @AfterMethod
    public void finishMethod(ITestResult result) {
        testRailWorker.setResult(result);

        TestResult testResult = new TestResult()
                .setRunId(runName)
                .setTestType(TestTRunType.UI.name())
                .setTestName(result.getMethod().getMethodName())
                .setTestResultStatus(TestResultStatusDefiner.defineStatus(result.getStatus()));

        if (!result.isSuccess()) {
            testResult.setCauseOfFailure(result.getThrowable().toString());
        }

        reporter.addTestResult(testResult);
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
