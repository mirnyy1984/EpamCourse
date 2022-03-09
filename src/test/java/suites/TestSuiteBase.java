package suites;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import reporters.ReporterBase;
import testrail.TestRailWorker;

public abstract class TestSuiteBase {

    protected TestRailWorker testRailWorker;
    protected ReporterBase reporter;

    @BeforeSuite
    public abstract void beforeSuitePreconditions();

    @AfterSuite
    public abstract void sendReport();
}
