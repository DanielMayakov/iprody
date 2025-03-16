import java.util.Arrays;

public class ArrayProcessor {

    public static int[] extractAfterLastFour(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Массив пуст или равен null");
        }

        int lastIndexOfFour = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastIndexOfFour = i;
            }
        }

        if (lastIndexOfFour == -1) {
            throw new RuntimeException("Массив должен содержать хотя бы одну четверку");
        }

        return Arrays.copyOfRange(array, lastIndexOfFour + 1, array.length);
    }

    public static boolean containsOnlyOneAndFour(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        boolean hasOne = false;
        boolean hasFour = false;

        for (int num : array) {
            if (num != 1 && num != 4) {
                return false;
            }
            if (num == 1) {
                hasOne = true;
            }
            if (num == 4) {
                hasFour = true;
            }
        }

        return hasOne && hasFour;
    }
}
