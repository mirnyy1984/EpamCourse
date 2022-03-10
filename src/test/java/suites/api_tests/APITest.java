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

        TestResult testResult = new TestResult()
                .setRunId(runName)
                .setTestType(TestTRunType.API.name())
                .setTestName(result.getMethod().getMethodName())
                .setTestResultStatus(TestResultStatusDefiner.defineStatus(result.getStatus()));

        if (!result.isSuccess()) {
            testResult.setCauseOfFailure(result.getThrowable().toString());
        }

        reporter.addTestResult(testResult);
    }
}
