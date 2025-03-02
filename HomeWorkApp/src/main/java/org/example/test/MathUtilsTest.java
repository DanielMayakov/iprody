package org.example.test;

public class MathUtilsTest {

    @BeforeSuite
    public void setUp() {
        System.out.println("Setting up tests...");
    }

    @Test(order = 1)
    public void shouldSumTwoGivenPositiveValues() {
        if (MathUtils.add(10, 11) == 21) {
            System.out.println("shouldSumTwoGivenPositiveValues passed");
        } else {
            System.out.println("shouldSumTwoGivenPositiveValues failed");
        }
    }

    @Test(order = 2)
    public void shouldSubtractTwoGivenPositiveValues() {
        if (MathUtils.subtract(15, 5) == 10) {
            System.out.println("shouldSubtractTwoGivenPositiveValues passed");
        } else {
            System.out.println("shouldSubtractTwoGivenPositiveValues failed");
        }
    }

    @Test(order = 3)
    public void shouldFailForIncorrectSubtraction() {
        if (MathUtils.subtract(10, 5) == 6) { // Преднамеренная ошибка
            System.out.println("shouldFailForIncorrectSubtraction passed");
        } else {
            System.out.println("shouldFailForIncorrectSubtraction failed");
        }
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("Tearing down tests...");
    }
}

