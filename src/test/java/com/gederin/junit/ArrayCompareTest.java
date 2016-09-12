package com.gederin.junit;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test arrays
 */
public class ArrayCompareTest {

    @Test
    public void testArraySort_RandomArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

}
