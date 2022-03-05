package reporters;

import reporters.testDecorators.ConsoleReporterDecorator;
import utils.test_methods_definer.TestMethodItem;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ReporterFactory {

    public TestResultReporter createReport(String reportTitle, ReporterType type, HashMap<String, List<TestMethodItem>> tests) {
        TestResultReporter reporter = null;

        switch (type) {
            case CONSOLE -> reporter = new ConsoleReporterDecorator(reportTitle, tests);
            case EXTENT -> reporter = new SlackReporter();
            case SLACK -> reporter = new ExtentReporter();
        }
        return Objects.requireNonNull(reporter);
    }
}
