package com.codecool.seti;

import java.util.ArrayList;

public class Seti {
    /**
     * Returns the binary representation of a decimal number as an array of integers.
     */
    public static Integer[] decimalToBinary(int decimalNumber) {

        if (decimalNumber == 0) {
            return new Integer[]{0};
        }
        ArrayList<Integer> convertedNumbers = new ArrayList<>();
        while (decimalNumber != 0) {
            int helper = decimalNumber % 2;
            decimalNumber = decimalNumber / 2;
            convertedNumbers.add(helper);
        }
        Integer[] solution = new Integer[convertedNumbers.size()];
        for (int i = 0; i < convertedNumbers.size(); i++) {
            solution[i] = convertedNumbers.get(convertedNumbers.size() - i - 1);
        }
        return solution;

    }

    /**
     * Returns the decimal representation of a binary number represented by a list of 0/1 digits
     */
    public static int binaryToDecimal(Integer[] binaryDigits) {

        int base = 2;
        int length = binaryDigits.length;
        int solution = 0;
        for (int i = 0; i < length; i++) {
            solution += binaryDigits[i] * Math.pow(base, length - 1 - i);
        }
        return solution;
    }

    /**
     * Returns the digits in destinationBase representation of the decimal number
     */
    public static Integer[] decimalToBase(int decimalNumber, int destinationBase) {

        if (decimalNumber == 0) {
            return new Integer[]{0};
        }
        ArrayList<Integer> convertedNumbers = new ArrayList<>();
        while (decimalNumber != 0) {
            int helper = decimalNumber % destinationBase;
            decimalNumber = decimalNumber / destinationBase;
            convertedNumbers.add(helper);
        }
        Integer[] solution = new Integer[convertedNumbers.size()];
        for (int i = 0; i < convertedNumbers.size(); i++) {
            solution[i] = convertedNumbers.get(convertedNumbers.size() - i - 1);
        }
        return solution;
    }

    /**
     * Returns the decimal representation of an array of digits given in originalBase
     */
    public static int baseToDecimal(Integer[] digits, int originalBase) {
        int length = digits.length;
        int solution = 0;
        for (int i = 0; i < length; i++) {
            solution += digits[i] * Math.pow(originalBase, length - 1 - i);
        }
        return solution;
    }

    /**
     * Returns the string representation of an array of digits given in base
     */
    public static String digitAsString(Integer[] digits, int baseNum) throws IllegalArgumentException {
        if (baseNum > 16) {
            throw new IllegalArgumentException("This is not a right value");
        }
        StringBuilder sb = new StringBuilder();
        for (Integer digit : digits) {
            if (digit > baseNum - 1) {
                throw new IllegalArgumentException("This is not a right value");
            }

            switch (digit){
                case 10 -> sb.append("A");
                case 11 -> sb.append("B");
                case 12 -> sb.append("C");
                case 13 -> sb.append("D");
                case 14 -> sb.append("E");
                case 15 -> sb.append("F");
                default -> sb.append(digit);
            }
        }
        return sb.toString();


    }

    /**
     * Checks if all numbers in list are zeros
     */
    public static boolean isZero(Integer[] digits) {
        for (int i = 0; i < digits.length; i++) {

            if (digits[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get modulo from dividing given number (array of digits) in given original base to given destination base
     */
    public static int moduloDiv(Integer[] originalDigits, int originalBase, int destinationBase) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Conversion from any base to any other base
     */
    public static Integer[] convertBase(Integer[] originalDigits, int originalBase, int destinationBase) {
            int helper = baseToDecimal(originalDigits, originalBase);
            return decimalToBase(helper, destinationBase);
    }
}
