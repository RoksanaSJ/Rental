package com.roxys.rental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.sum(2,3));
    }
}
