import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProcessorTest {

    @Test
    void testExtractAfterLastFour_NormalCase() {
        int[] input = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expected = {1, 7};
        assertArrayEquals(expected, ArrayProcessor.extractAfterLastFour(input));
    }

    @Test
    void testExtractAfterLastFour_SingleFour() {
        int[] input = {4, 1, 2, 3};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, ArrayProcessor.extractAfterLastFour(input));
    }

    @Test
    void testExtractAfterLastFour_NoFour() {
        int[] input = {1, 2, 3};
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ArrayProcessor.extractAfterLastFour(input);
        });
        assertEquals("Массив должен содержать хотя бы одну четверку", exception.getMessage());
    }

    @Test
    void testExtractAfterLastFour_EmptyArray() {
        int[] input = {};
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ArrayProcessor.extractAfterLastFour(input);
        });
        assertEquals("Массив пуст или равен null", exception.getMessage());
    }

    @Test
    void testContainsOnlyOneAndFour_TrueCase() {
        int[] input = {1, 4, 1, 4};
        assertTrue(ArrayProcessor.containsOnlyOneAndFour(input));
    }

    @Test
    void testContainsOnlyOneAndFour_NoOne() {
        int[] input = {4, 4, 4};
        assertFalse(ArrayProcessor.containsOnlyOneAndFour(input));
    }

    @Test
    void testContainsOnlyOneAndFour_NoFour() {
        int[] input = {1, 1, 1};
        assertFalse(ArrayProcessor.containsOnlyOneAndFour(input));
    }

    @Test
    void testContainsOnlyOneAndFour_ContainsOtherNumbers() {
        int[] input = {1, 4, 3};
        assertFalse(ArrayProcessor.containsOnlyOneAndFour(input));
    }

    @Test
    void testContainsOnlyOneAndFour_EmptyArray() {
        int[] input = {};
        assertFalse(ArrayProcessor.containsOnlyOneAndFour(input));
    }
}
