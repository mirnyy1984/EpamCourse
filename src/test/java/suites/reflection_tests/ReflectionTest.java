package suites.reflection_tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ReflectionTest extends ReflectionTestSuite {

    @AfterMethod
    public void finishMethod(ITestResult result) {
        testRailWorker.setResult(result);
    }
}
