package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {
    @Test
    void testExtractElementsAfterLastFour() {
        int[] input1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expected1 = {1, 7};
        assertArrayEquals(expected1, ArrayUtils.extractElementsAfterLastFour(input1));

        int[] input2 = {4, 4, 4, 4, 4};
        int[] expected2 = {};
        assertArrayEquals(expected2, ArrayUtils.extractElementsAfterLastFour(input2));

        int[] input3 = {1, 2, 3};
        assertThrows(RuntimeException.class, () -> ArrayUtils.extractElementsAfterLastFour(input3));

        int[] input4 = {4, 1, 2, 3};
        int[] expected4 = {1, 2, 3};
        assertArrayEquals(expected4, ArrayUtils.extractElementsAfterLastFour(input4));
    }
}
