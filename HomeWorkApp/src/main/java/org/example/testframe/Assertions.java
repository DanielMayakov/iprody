package org.example.testframe;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Assertions {

    // a. Проверка нахождения подмассива
    public static <T> void contains(T[] current, T[] toContain) throws AssertResult {
        if (current == null || toContain == null) {
            throw new AssertResult("Arrays cannot be null");
        }
        if (toContain.length == 0) {
            return; // Пустой подмассив всегда содержится
        }

        boolean found = false;
        for (int i = 0; i <= current.length - toContain.length; i++) {
            if (Arrays.equals(Arrays.copyOfRange(current, i, i + toContain.length), toContain)) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new AssertResult("Array does not contain the specified subarray");
        }
    }

    // b. Рекурсивная проверка объектов
    public static <T> void equalRecursively(T expected, T actual) throws AssertResult {
        if (expected == null || actual == null) {
            if (expected != actual) {
                throw new AssertResult("Objects are not equal: one is null");
            }
            return;
        }

        Class<?> clazz = expected.getClass();
        if (!clazz.equals(actual.getClass())) {
            throw new AssertResult("Objects are not of the same type");
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object expectedValue = field.get(expected);
                Object actualValue = field.get(actual);

                if (field.getType().isPrimitive() || expectedValue instanceof String || expectedValue instanceof Number) {
                    if (!expectedValue.equals(actualValue)) {
                        throw new AssertResult("Field " + field.getName() + " does not match");
                    }
                } else {
                    equalRecursively(expectedValue, actualValue); // Рекурсивный вызов для вложенных объектов
                }
            } catch (IllegalAccessException e) {
                throw new AssertResult("Failed to access field " + field.getName(), e);
            }
        }
    }
}

