package utils.test_methods_definer;

import annotations.TestType;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestMethodsDefiner {

    public HashMap<String, List<TestMethodItem>> defineTestMethods(List<Method[]> methodCollection) {
        HashMap<String, List<TestMethodItem>> tests = new HashMap<>();

        String methodName;
        String methodModifier;
        String methodType;
        String methodDescription;

        for (Method[] methods : methodCollection) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(TestType.class)) {
                    TestType annotation = method.getAnnotation(TestType.class);

                    switch (annotation.testType()) {
                        case "ui", "api" -> {
                            methodName = method.getName();
                            methodModifier = Modifier.toString(method.getModifiers());
                            methodType = method.getAnnotation(TestType.class).testType();
                            methodDescription = method.getAnnotation(TestType.class).testDescription();

                            if (!tests.containsKey(annotation.testType())) {
                                TestMethodItem uiItem = new TestMethodItem(methodName, methodModifier, methodType, methodDescription);
                                ArrayList<TestMethodItem> uiItems = new ArrayList<>(List.of(uiItem));
                                tests.put(annotation.testType(), uiItems);
                            } else {
                                List<TestMethodItem> testMethodItems = tests.get(annotation.testType());
                                testMethodItems.add(new TestMethodItem(methodName, methodModifier, methodType, methodDescription));
                                tests.replace(annotation.testType(), testMethodItems);
                            }
                        }
                    }
                }
            }
        }
        return tests;
    }
}
