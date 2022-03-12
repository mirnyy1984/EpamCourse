package reporters;

import Slack.SlackMessageBuilder;
import Slack.SlackMessenger;
import reporters.utils.TestResultStatusType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SlackReporter extends ReporterBase {

    private String passedTestResultColor = "#58D68D";
    private String failedTestResultColor = "#CD5C5C";

    @Override
    public void makeReport() {
        ArrayList<TestResult> testResults = getTestResults();

        List<TestResult> failedTests = testResults.stream().filter(result -> result.getTestResultStatus().equals(TestResultStatusType.BLOCKED)
                || result.getTestResultStatus().equals(TestResultStatusType.FAILED)).toList();

        int testTotalCount = testResults.size();
        int failedTestCount = failedTests.size();
        int passedTestCount = testResults.size() - failedTestCount;
        String messageAttachmentColor = failedTestCount == 0 ? passedTestResultColor : failedTestResultColor;
        //TestResultStatusType finalResultType = failedTests.size() > 0 ? finalResultType = TestResultStatusType.FAILED : TestResultStatusType.PASSED;

        SlackMessageBuilder messageBuilder = new SlackMessageBuilder(messageAttachmentColor);

        messageBuilder
                .addHeader(getReportTitle())
                .addDivider()
                .addText("Start execute time: " + getSuiteRunStartTime())
                .addText("End execute time: " + new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date()))
                .addText("Total test count: " + testTotalCount)
                .addText("Passed test count: " + passedTestCount)
                .addText("Failed test count: " + failedTestCount)
                .addDivider()
                .addText(" ------- Failed tests ------- ");


        for (TestResult result : failedTests) {
            messageBuilder
                    .addText("Test type: " + result.getTestType())
                    .addText("Test name: " + result.getTestName())
                    .addText("Cause of failure: " + result.getCauseOfFailure())
                    .addDivider();
        }

        SlackMessenger.sendMessage(messageBuilder.buildMessage());
    }
}

