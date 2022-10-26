package org.example;

import java.util.*;

public class Ex2_UniqueNumsSum {
    private static Scanner stdin = new Scanner(System.in);
    /*
        Find the sum of distinct pairs for a group of integers (you may decide the data structure).
        When a pair is detected, only sum the value once in the final output.
        Each number may only match once and should only be counted once.
        E.G. if provided with:
        22, 3, 7, 5, 4, 22, 4, 0, -5, 12, -22, 22, 7, 3, -24, 4, 4

        This should identify the duplicates: 22, 3, 7, 5, 4, 22, 4, 0, -5, 12, -22, 22, 7, 	3, -24, 4, 4 – and should therefore sum 22, 3, 7, 4, 4 to return 40.
	    Note: we only match pairs. We don’t match the third 22 because it doesn’t form part of a pair. We do, however, match the fourth 4 as two pairs.
	    Negative numbers should be supported, and should be subtracted – but a negative 	and positive of the same value will, of course, not match.
    */

    public static void main(String[] args) {
        int[] listOfNumber = {22, 3, 7, 5, 4, 22, 4, 0, -5, 12, -22, 22, 7, 3, -24, 4, 4};
        SumOfUniqueNums(findingUniqueNums(listOfNumber));
    }

    public static ArrayList<Integer> findingUniqueNums(int[] listOfNumbers) {
        //sorting it numerically first
        Arrays.sort(listOfNumbers);
        //finding distinct nums and saving it into Arraylist
        ArrayList<Integer> distinctNumbers = new ArrayList<>();
        System.out.println(Arrays.toString(listOfNumbers));
        int counter = 0;
        for (int i = 0; i < listOfNumbers.length - 1; i++) {
            for (int j = i + 1; j < listOfNumbers.length; j++) {
                if (listOfNumbers[i] == listOfNumbers[j]) {
                    distinctNumbers.add(listOfNumbers[i]);
                    i++; j++;
                }
            }
        }
        System.out.println(distinctNumbers);
        return distinctNumbers;
    }

    public static int SumOfUniqueNums(ArrayList<Integer> distinctNumbers) {
        int sum = 0;
        for (int i = 0; i < distinctNumbers.size(); i++) {
            sum = sum + distinctNumbers.get(i);
        }
        System.out.printf("Sum of unique numbers is %d", sum);
        return sum;
    }
}
