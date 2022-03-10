package reporters;

import reporters.testDecorators.ConsoleReporterDecorator;

import java.util.Objects;

public class ReporterFactory {

    public TestResultReporter createReport(ReporterType type) {
        TestResultReporter reporter = null;

        switch (type) {
            case CONSOLE -> reporter = new ConsoleReporterDecorator();
            case EXTENT -> reporter = new ExtentReporter();
            case SLACK -> reporter = new SlackReporter();
        }
        return Objects.requireNonNull(reporter);
    }
}
