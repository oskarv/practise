package com.endava.algoritm;

public class Solution {

    public static int solution(int[] A) {
        int minMin = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxMax = Integer.MIN_VALUE;
        int maxMaxMax = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (maxMaxMax < A[i]) {
                max = maxMax;
                maxMax = maxMaxMax;
                maxMaxMax = A[i];
            } else if (maxMax < A[i]) {
                max = maxMax;
                maxMax = A[i];
            } else if (max < A[i]) {
                max = A[i];
            }

            if (minMin > A[i]) {
                min = minMin;
                minMin = A[i];
            } else if (min > A[i]) {
                min = A[i];
            }
        }
        return Math.max(maxMaxMax * maxMax * max, maxMaxMax * minMin * min);
    }
}
