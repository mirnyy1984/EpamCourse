package suites.reflection_tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import reporters.TestResult;
import reporters.utils.TestResultStatusDefiner;
import testrail.TestTRunType;

public class ReflectionTest extends ReflectionTestSuite {

    @AfterMethod
    public void finishMethod(ITestResult result) {

        testRailWorker.setResult(result);

        TestResult testResult = new TestResult()
                .setRunId(runName)
                .setTestType(TestTRunType.REFLECTION.name())
                .setTestName(result.getMethod().getMethodName())
                .setTestResultStatus(TestResultStatusDefiner.defineStatus(result.getStatus()));

        if (!result.isSuccess()) {
            testResult.setCauseOfFailure(result.getThrowable().toString());
        }

        reporter.addTestResult(testResult);
    }
}
