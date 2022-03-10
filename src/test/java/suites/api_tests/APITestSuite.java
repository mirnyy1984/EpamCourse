package suites.api_tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import suites.TestSuiteBase;
import testrail.TestRailWorker;
import testrail.TestTRunType;


public class APITestSuite extends TestSuiteBase {

    @BeforeSuite
    @Override
    public void beforeSuitePreconditions() {
        String runName = "Run_name: " + TestTRunType.API + "_" + startRunTime;
        testRailWorker = new TestRailWorker(TestTRunType.API, runName);
    }

    @AfterSuite
    @Override
    public void sendReport() {
        testRailWorker.closeWorker();
    }
}
