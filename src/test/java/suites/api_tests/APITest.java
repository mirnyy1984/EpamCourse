package suites.api_tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import reporters.TestResult;
import reporters.utils.TestResultStatusDefiner;
import testrail.TestTRunType;


public class APITest extends APITestSuite {

    @AfterMethod
    public void finishMethod(ITestResult result) {
        testRailWorker.setResult(result);
        reporter.addTestResult(new TestResult(runName,
                TestTRunType.API.name(),
                result.getMethod().getMethodName(),
                TestResultStatusDefiner.defineStatus(result.getStatus())));
    }
}
