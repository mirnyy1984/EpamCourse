package reporters;

import java.util.ArrayList;

public class ReporterBase implements TestResultReporter {

    private String reportTitle;
    private String suiteRunStartTime;
    private String suiteRunEndTime;
    private int testTotalCount;
    private int passedTestCount;
    private int failedTestCount;
    private ArrayList<TestResult> testResults = new ArrayList<>();


    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public ArrayList<TestResult> getTestResults() {
        return testResults;
    }

    public void addTestResult(TestResult testResult) {
        testResults.add(testResult);
    }

    @Override
    public void makeReport() {

    }
}
