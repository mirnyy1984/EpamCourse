package reporters.testDecorators;

import reporters.ConsoleReporter;

public class ConsoleReporterDecorator extends ConsoleReporter {

    private String reportTitle;

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    @Override
    public void makeReport() {
        System.out.println("--------------" + reportTitle + " --------------");
        super.makeReport();
    }
}
