package com.roxys.rental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.sum(2,3));
    }
    @Test
    public void testNegativeNumberSum() {
        Calculator calculator = new Calculator();
        assertEquals(-5, calculator.sum(-2,-3));
    }

    @Test
    public void testIsPositive() {
        Calculator calculator = new Calculator();
        assertTrue(calculator.isPositive(1));
    }
    @Test
    public void testIsNegative() {
        Calculator calculator = new Calculator();
        assertFalse(calculator.isPositive(-1));
    }
    @Test
    public void testIsZero() {
        Calculator calculator = new Calculator();
        assertFalse(calculator.isPositive(0));
    }
    @Test
    public void testIsMaximum() {
        Calculator calculator = new Calculator();
        assertEquals(8,calculator.isMaximum(new int[]{1,4,7,8,2}));
        assertEquals(100,calculator.isMaximum(new int[]{-1,12,0,33,100}));
        assertEquals(-1,calculator.isMaximum(new int[]{-2,-3,-101,-222,-1}));
        assertEquals(90,calculator.isMaximum(new int[]{0,22,-54,90,-1}));
    }


}
