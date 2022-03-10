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
        testRailWorker = new TestRailWorker(TestTRunType.API);
    }

    @AfterSuite
    @Override
    public void sendReport() {
        testRailWorker.closeWorker();
    }
}
