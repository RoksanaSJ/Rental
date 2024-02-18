package com.roxys.rental;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public boolean isPositive(int a) {
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int isMaximum(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
