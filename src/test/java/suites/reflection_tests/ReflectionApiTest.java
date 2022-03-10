package suites.reflection_tests;

import org.testng.annotations.Test;
import reporters.ReporterFactory;
import reporters.ReporterType;
import reporters.testDecorators.ConsoleReporterDecorator;
import suites.api_tests.UserAPITests;
import suites.ui_tests.home_page_ui_test_suite.HomePageUiTests;
import reporters.ConsoleReporter;
import utils.test_methods_definer.TestMethodItem;
import utils.test_methods_definer.TestMethodsDefiner;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReflectionApiTest extends ReflectionTest{

    @Test
    public void test_3_verifyAnnotations() {

        Class<UserAPITests> apiTestClazz = UserAPITests.class;
        Method[] apiTestsDeclaredMethods = apiTestClazz.getDeclaredMethods();

        Class<HomePageUiTests> uiTestClazz = HomePageUiTests.class;
        Method[] uiTestsDeclaredMethods = uiTestClazz.getDeclaredMethods();

        TestMethodsDefiner testMethodsDefiner = new TestMethodsDefiner();
        HashMap<String, List<TestMethodItem>> testMethods = testMethodsDefiner.defineTestMethods(Arrays.asList(apiTestsDeclaredMethods, uiTestsDeclaredMethods));

        ReporterFactory reporterFactory = new ReporterFactory();
        ConsoleReporterDecorator reporter = (ConsoleReporterDecorator) reporterFactory.createReport(ReporterType.CONSOLE);
        reporter.setTests(testMethods);
        reporter.setReportTitle("This is Console reporter !");
        reporter.makeReport();
    }
}
