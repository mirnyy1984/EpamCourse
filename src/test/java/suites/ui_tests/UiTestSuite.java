package suites.ui_tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class UiTestSuite {

    protected String projectEnvLabel;
    protected String browser;


    @BeforeSuite()
    public void setTestSuiteLabels() {
        projectEnvLabel = "PROD";
        browser = "CHROME";
    }


    @AfterSuite()
    public void sendReport() {
        // TODO: if it will be needed
        // TODO: make an archive of folder with test results and send an email with attached archive
    }
}
