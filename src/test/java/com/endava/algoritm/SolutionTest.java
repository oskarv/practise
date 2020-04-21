package com.endava.algoritm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void testAllZeroes() {
        int expected = 0;
        int[] array = {0, 0, 0};
        assertEquals(expected, solution.solution(array));
    }

    @Test
    void testOneIsZero() {
        int expected = 0;
        int[] array = {0, 2, 3};
        assertEquals(expected, solution.solution(array));
    }

    @Test
    void testAllOnes() {
        int expected = 1;
        int[] array = {1, 1, 1};
        assertEquals(expected, solution.solution(array));
    }

    @Test
    void testFourNumbers() {
        int expected = 24;
        int[] array = {4, 3, 2, 2};
        assertEquals(expected, solution.solution(array));
    }

    @Test
    void testFourNumbersTwoNegative() {
        int expected = 40;
        int[] array = {-5, -4, 2, 2};
        assertEquals(expected, solution.solution(array));
    }

    @Test
    void testFourNumbersTwoBigNegativeOneBigPossitive() {
        int expected = 999_000_000;
        int[] array = {-1_000, -999, 2, 1_000};
        assertEquals(expected, solution.solution(array));
    }
}
