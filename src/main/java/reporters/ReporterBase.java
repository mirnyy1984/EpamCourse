package reporters;

import java.util.ArrayList;

public class ReporterBase implements TestResultReporter {

    private String reportTitle;
    private String suiteRunStartTime;
    private String suiteRunEndTime;
    private String causeOfFailure;
    private int testTotalCount;
    private int passedTestCount;
    private int failedTestCount;
    private ArrayList<TestResult> testResults = new ArrayList<>();

    public String getSuiteRunStartTime() {
        return suiteRunStartTime;
    }

    public void setSuiteRunStartTime(String suiteRunStartTime) {
        this.suiteRunStartTime = suiteRunStartTime;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void addTestResult(TestResult testResult) {
        testResults.add(testResult);
    }


    public ArrayList<TestResult> getTestResults() {
        return testResults;
    }


    @Override
    public void makeReport() {

    }
}
