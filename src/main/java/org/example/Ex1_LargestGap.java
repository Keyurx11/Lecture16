package org.example;

import java.util.*;

public class Ex1_LargestGap {
    private static Scanner stdin = new Scanner(System.in);
    /*
        Take an unordered group of whole numbers (you may decide the data structure).
        Find the largest gap between numerically ordered numbers.
        E.G. if provided with:
        11, 14, 10, 5, 1, 5, 12, 16, 6, 12, 10, 10, 12, 14, 4, 11
         Your function should return 4. Because when ordered numerically, the largest gap is between 6 and 10.
    */

    public static void main(String[] args) {
        int[] listOfNumber = new int[]{11, 14, 10, 5, 1, 5, 12, 16, 6, 12, 10, 10, 12, 14, 4, 11, 6, 65, 93};
        int temp = 0;
        int largestGap = 0;

        //printing original array
        System.out.println("Original array: ");
        for (int i = 0; i < listOfNumber.length; i++) {
            System.out.print(listOfNumber[i] + " ");
        }

        //storing sorted listOfNumbers
        int[] sortedListofNumbers = ArrangeListNumerically(listOfNumber, temp);

        //printing sorted array
        System.out.println("\nSorted array: ");
        for (int i = 0; i < sortedListofNumbers.length; i++) {
            System.out.print(sortedListofNumbers[i] + " ");
        }

        //finding the largest gap between numbers and printing it
        largestGap = highestGapBetweenNumbers(sortedListofNumbers, largestGap);
        System.out.printf("\nLargest Gap final is %d.", largestGap);

    }

    public static int[] ArrangeListNumerically(int[] listOfNumbers, int temp) {
        for (int i = 0; i < listOfNumbers.length; i++) {
            for (int j = i + 1; j < listOfNumbers.length; j++) {
                if (listOfNumbers[i] > listOfNumbers[j]) {
                    temp = listOfNumbers[i];
                    listOfNumbers[i] = listOfNumbers[j];
                    listOfNumbers[j] = temp;
                }
            }
        }
        return listOfNumbers;
    }

    public static int highestGapBetweenNumbers(int[] listOfNumbers, int largestGap) {
        for (int i = 0; i < listOfNumbers.length - 1; i++) {
            if (largestGap < (listOfNumbers[i + 1] - listOfNumbers[i])) {
                largestGap = listOfNumbers[i + 1] - listOfNumbers[i];
            }
        }
        return largestGap;
    }
}