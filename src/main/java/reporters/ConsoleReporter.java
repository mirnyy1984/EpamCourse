package reporters;

import utils.test_methods_definer.TestMethodItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ConsoleReporter implements TestResultReporter {

    private HashMap<String, List<TestMethodItem>> tests = new HashMap<>();

    public void setTests(HashMap<String, List<TestMethodItem>> tests) {
       this.tests = tests;
    }


    @Override
    public void makeReport() {
        Set<String> keys = tests.keySet();

        List<TestMethodItem> ui = new ArrayList<>();
        List<TestMethodItem> api = new ArrayList<>();

        for (String key : keys) {
            List<TestMethodItem> testMethodItems = tests.get(key);
            for (TestMethodItem item : testMethodItems) {
                switch (item.getTestType()) {
                    case "ui" -> ui.add(item);
                    case "api" -> api.add(item);
                }
            }
        }

        System.out.println(" ---- Reflection api home task result ----" + "\n");
        System.out.println("test count total: " + (ui.size() + api.size()) + "\n");

        System.out.println("----- ui tests ----");
        ui.forEach(System.out::println);

        System.out.println();
        System.out.println("----- api tests ----");
        api.forEach(System.out::println);
    }
}
