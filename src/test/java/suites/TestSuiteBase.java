package suites;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import testrail.TestRailWorker;

public abstract class TestSuiteBase {

    protected TestRailWorker testRailWorker;

    @BeforeSuite
    public abstract void beforeSuitePreconditions();

    @AfterSuite
    public abstract void sendReport();
}
