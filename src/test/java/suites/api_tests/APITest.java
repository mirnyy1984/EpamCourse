package suites.api_tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import suites.TestSuiteBase;

public class APITest extends APITestSuite {

    @AfterMethod
    public void finishMethod(ITestResult result) {
        testRailWorker.setResult(result);
    }
}
