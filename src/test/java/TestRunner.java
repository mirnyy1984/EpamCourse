import org.testng.TestNG;

import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        String mainSuite = "src/test/java/suites/main_suite.xml";

        TestNG runner = new TestNG();
        runner.setTestSuites(List.of(mainSuite));
        runner.run();
    }
}
