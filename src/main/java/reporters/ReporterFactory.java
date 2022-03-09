package reporters;

import reporters.testDecorators.ConsoleReporterDecorator;

import java.util.Objects;

public class ReporterFactory {

    public TestResultReporter createReport(ReporterType type) {
        TestResultReporter reporter = null;

        switch (type) {
            case CONSOLE -> reporter = new ConsoleReporterDecorator();
            case EXTENT -> reporter = new SlackReporter();
            case SLACK -> reporter = new ExtentReporter();
        }
        return Objects.requireNonNull(reporter);
    }
}
