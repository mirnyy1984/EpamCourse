package suites.ui_tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import suites.TestSuiteBase;
import testrail.TestRailWorker;
import testrail.TestTRunType;


public class UiTestSuite extends TestSuiteBase{

    protected String projectEnvLabel;
    protected String browser;

    @BeforeSuite
    @Override
    public void beforeSuitePreconditions() {
        String runName = "Run_name: " + TestTRunType.UI + "_" + startRunTime;
        testRailWorker = new TestRailWorker(TestTRunType.UI, runName);
        projectEnvLabel = "PROD";
        browser = "CHROME";
    }


    @AfterSuite
    @Override
    public void sendReport() {
        testRailWorker.closeWorker();
    }
}
