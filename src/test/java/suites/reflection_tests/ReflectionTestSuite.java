package suites.reflection_tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import suites.TestSuiteBase;
import testrail.TestRailWorker;
import testrail.TestTRunType;

public class ReflectionTestSuite extends TestSuiteBase {

    @BeforeSuite
    @Override
    public void beforeSuitePreconditions() {
        testRailWorker = new TestRailWorker(TestTRunType.REFLECTION);
    }

    @AfterSuite
    @Override
    public void sendReport() {
        testRailWorker.closeWorker();
    }
}
