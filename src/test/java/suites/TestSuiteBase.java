package suites;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import reporters.ReporterBase;
import testrail.TestRailWorker;
import testrail.TestTRunType;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestSuiteBase {

    protected TestRailWorker testRailWorker;
    protected ReporterBase reporter;
    protected String startRunTime = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date());

    @BeforeSuite
    public abstract void beforeSuitePreconditions();

    @AfterSuite
    public abstract void sendReport();
}
