package reporters;

import reporters.utils.TestResultStatusType;

public class TestResult {
    private String runId;
    private String testType;
    private String testName;
    private TestResultStatusType testResultStatus;

    public TestResult(String runId, String testType, String testName, TestResultStatusType testStatus) {
        this.runId = runId;
        this.testType = testType;
        this.testName = testName;
        this.testResultStatus = testStatus;
    }

    public String getRunId() {
        return runId;
    }

    public String getTestType() {
        return testType;
    }

    public String getTestName() {
        return testName;
    }

    public TestResultStatusType getTestResultStatus() {
        return testResultStatus;
    }
}
