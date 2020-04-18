package com.endava.algoritm;

public class Solution {

    public static int solution(int[] A) {

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (thirdMax < A[i]) {
                max = secondMax;
                secondMax = thirdMax;
                thirdMax = A[i];
            } else if (secondMax < A[i]) {
                max = secondMax;
                secondMax = A[i];
            } else if (max < A[i]) {
                max = A[i];
            }

            if (min > A[i]) {
                secondMin = min;
                min = A[i];
            } else if (secondMin > A[i]) {
                secondMin = A[i];
            }
        }
        return Math.max(thirdMax * secondMax * max, thirdMax * min * secondMin);
    }
}
