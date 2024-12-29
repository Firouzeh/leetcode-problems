package arrays.easy;

import java.util.Arrays;

class PlusOne {
    public int[] plusOne(int[] digits) {
        // Traverse the array from the last digit to the first
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // Increment the current digit if it's less than 9
                return digits; // Return immediately as no carry is needed
            }
            // If the digit is 9, set it to 0 (carry over to the next digit)
            digits[i] = 0;
        }

        // If the loop completes, it means all digits were 9
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1; // Add 1 at the most significant position
        return newDigits;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();

        // Test cases
        int[] digits1 = {1, 2, 3};
        int[] digits2 = {4, 3, 2, 1};
        int[] digits3 = {9};
        int[] digits4 = {9, 9, 9};

        // Print results
        System.out.println("Input: [1, 2, 3] -> Output: " + Arrays.toString(solution.plusOne(digits1))); // [1, 2, 4]
        System.out.println("Input: [4, 3, 2, 1] -> Output: " + Arrays.toString(solution.plusOne(digits2))); // [4, 3, 2, 2]
        System.out.println("Input: [9] -> Output: " + Arrays.toString(solution.plusOne(digits3))); // [1, 0]
        System.out.println("Input: [9, 9, 9] -> Output: " + Arrays.toString(solution.plusOne(digits4))); // [1, 0, 0, 0]
    }
}

