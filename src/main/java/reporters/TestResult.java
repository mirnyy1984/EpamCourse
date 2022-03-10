package reporters;

import reporters.utils.TestResultStatusType;

public class TestResult {
    private String runId;
    private String testType;
    private String testName;
    private String causeOfFailure;
    private TestResultStatusType testResultStatus;


    public TestResult setRunId(String runId) {
        this.runId = runId;
        return this;
    }


    public TestResult setTestType(String testType) {
        this.testType = testType;
        return this;
    }


    public TestResult setTestName(String testName) {
        this.testName = testName;
        return this;
    }


    public TestResult setTestResultStatus(TestResultStatusType testResultStatus) {
        this.testResultStatus = testResultStatus;
        return this;
    }


    public TestResult setCauseOfFailure(String causeOfFailure) {
        this.causeOfFailure = causeOfFailure;
        return this;
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


    public String getCauseOfFailure() {
        return causeOfFailure;
    }
}
