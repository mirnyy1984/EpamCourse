package suites.reflection_tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import reporters.ReporterFactory;
import reporters.ReporterType;
import reporters.SlackReporter;
import suites.TestSuiteBase;
import testrail.TestRailWorker;
import testrail.TestTRunType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReflectionTestSuite extends TestSuiteBase {

    @BeforeSuite
    @Override
    public void beforeSuitePreconditions() {
        startRunTime = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date());
        runName = "Run_name: " + TestTRunType.REFLECTION + "_" + startRunTime;

        testRailWorker = new TestRailWorker(TestTRunType.REFLECTION, runName);

        reporter = (SlackReporter) new ReporterFactory().createReport(ReporterType.SLACK);
        reporter.setReportTitle(runName);
        reporter.setSuiteRunStartTime(startRunTime);
    }

    @AfterSuite
    @Override
    public void sendReport() {
        testRailWorker.closeWorker();
        reporter.makeReport();
    }
}
