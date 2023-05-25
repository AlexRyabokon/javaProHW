import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class TestRunner {

    public static void start(Class<?> testClass) throws Exception {
        Object instance = testClass.getDeclaredConstructor().newInstance();
        int beforeSuiteCount = 0;
        int afterSuiteCount = 0;

        for (java.lang.reflect.Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteCount++;
                if (beforeSuiteCount > 1) {
                    throw new RuntimeException("There can be only one method with @BeforeSuite annotation");
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteCount++;
                if (afterSuiteCount > 1) {
                    throw new RuntimeException("There can be only one method with @AfterSuite annotation");
                }
            }
        }


        java.lang.reflect.Method beforeSuiteMethod = null;
        java.lang.reflect.Method afterSuiteMethod = null;

        for (java.lang.reflect.Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteMethod = method;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteMethod = method;
            }
        }

        if (beforeSuiteMethod != null) {
            beforeSuiteMethod.invoke(instance);
        }

        java.util.List<java.lang.reflect.Method> testMethods = new java.util.ArrayList<>();

        for (java.lang.reflect.Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }

        testMethods.sort(java.util.Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));

        for (java.lang.reflect.Method method : testMethods) {
            method.invoke(instance);
        }

        if (afterSuiteMethod != null) {
            afterSuiteMethod.invoke(instance);
        }
    }
}
