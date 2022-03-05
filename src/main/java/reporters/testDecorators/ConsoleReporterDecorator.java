package reporters.testDecorators;

import reporters.ConsoleReporter;
import utils.test_methods_definer.TestMethodItem;

import java.util.HashMap;
import java.util.List;

public class ConsoleReporterDecorator extends ConsoleReporter {

    private final String reportTitle;

    public ConsoleReporterDecorator(String reportTitle, HashMap<String, List<TestMethodItem>> tests) {
        super(tests);
        this.reportTitle = reportTitle;
    }

    @Override
    public void makeReport() {
        System.out.println("--------------" + reportTitle +" --------------");
        super.makeReport();
    }
}
