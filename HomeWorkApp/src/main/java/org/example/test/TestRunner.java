package org.example.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

    public static void start(Class<?> testClass) {
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        List<Method> testMethods = new ArrayList<>();

        // Проходимся по всем методам класса
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuiteMethod != null) {
                    throw new RuntimeException("Multiple @BeforeSuite methods are not allowed");
                }
                beforeSuiteMethod = method;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuiteMethod != null) {
                    throw new RuntimeException("Multiple @AfterSuite methods are not allowed");
                }
                afterSuiteMethod = method;
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }

        // Сортируем методы с аннотацией @Test по значению order
        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).order()));

        try {
            // Создаем экземпляр тестового класса
            Object testInstance = testClass.getDeclaredConstructor().newInstance();

            // Выполняем метод @BeforeSuite, если он есть
            if (beforeSuiteMethod != null) {
                beforeSuiteMethod.setAccessible(true);
                beforeSuiteMethod.invoke(testInstance);
            }

            // Выполняем все методы с аннотацией @Test
            for (Method testMethod : testMethods) {
                testMethod.setAccessible(true);
                testMethod.invoke(testInstance);
            }

            // Выполняем метод @AfterSuite, если он есть
            if (afterSuiteMethod != null) {
                afterSuiteMethod.setAccessible(true);
                afterSuiteMethod.invoke(testInstance);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while executing tests: " + e.getMessage(), e);
        }
    }
}

