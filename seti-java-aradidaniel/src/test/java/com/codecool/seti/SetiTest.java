package com.codecool.seti;

import org.junit.jupiter.api.Test;

import static com.codecool.seti.Seti.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetiTest {
    @Test
    public void testDecimalToBinary() {
        Integer[] result = decimalToBinary(20);
        Integer[] expected = {1, 0, 1, 0, 0};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBinaryToDecimal() {
        int result = binaryToDecimal(new Integer[]{1, 0, 1, 0, 0});
        int expected = 20;
        assertEquals(expected, result);
    }

    @Test
    public void testDecimalToBase() {
        Integer[] result = decimalToBase(20, 8);
        Integer[] expected = {2, 4};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBaseToDecimal() {
        int result = baseToDecimal(new Integer[]{2, 4}, 8);
        int expected = 20;
        assertEquals(expected, result);
    }

    @Test
    public void testDigitAsString() {
        String result = digitAsString(new Integer[]{2, 15, 9, 11}, 16);
        String expected = "2F9B";
        assertEquals(expected, result);
    }

    @Test
    public void testDigitAsStringTooBigBaseNum() {
        assertThrows(IllegalArgumentException.class, () -> digitAsString(new Integer[]{2, 15, 9, 11}, 36));
    }

    @Test
    public void testDigitAsStringTooBigNumInArray() {
        assertThrows(IllegalArgumentException.class, () -> digitAsString(new Integer[]{2, 15, 9, 11}, 4));
    }

    @Test
    public void testIsZeroTrue() {
        boolean result = isZero(new Integer[]{0, 0, 0, 0});
        assertTrue(result);
    }

    @Test
    public void testIsZeroFalse() {
        boolean result = isZero(new Integer[]{15, 9, 11});
        assertFalse(result);
    }

    @Test
    public void testIsZeroMixedFalse() {
        boolean result = isZero(new Integer[]{0, 9, 11});
        assertFalse(result);
    }

    @Test
    public void testConvertBase() {
        Integer[] result = convertBase(new Integer[]{1, 1, 2, 0}, 3, 2);
        Integer[] expected = {1, 0, 1, 0, 1, 0};
        assertArrayEquals(expected, result);
    }
}
