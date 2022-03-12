import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.TestNG;

import java.util.List;

public class AAA {
    public static void main(String[] args) {

        String mainSuite = "src/test/java/suites/main_suite.xml";
        //String mainSuite = "src/test/java/suites/ui_tests/home_page_ui_test_suite/home_page_ui_test_suite.xml";
        ReportPortalTestNGListener listener = new ReportPortalTestNGListener();
        TestNG runner = new TestNG();
        runner.setTestSuites(List.of(mainSuite));
        runner.addListener(listener);
        runner.run();
    }
}
