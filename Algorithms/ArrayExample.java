package Algorithms;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = new int[5];

        if (numbers.length < 5) {
            System.out.println("Array length is less than 5.");
            return;
        }

        // Inserting values
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // Accessing an element
        try {
            System.out.println("Element at index 2: " + numbers[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds.");
        }

        // Updating an element
        try {
            numbers[2] = 10;
            System.out.println("Updated element at index 2: " + numbers[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds.");
        }

        // Deleting an element (shifting left)
        for (int i = 2; i < numbers.length - 1; i++) {
            numbers[i] = numbers[i + 1];
        }

        try {
            System.out.println("Array after deletion: " + Arrays.toString(numbers));
        } catch (NullPointerException e) {
            System.out.println("Array is null.");
        }
    }
}
