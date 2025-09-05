package com.a1.blog.util;

import java.util.HashSet;
import java.util.Scanner;

public class PairSum {

    //function to find a pair of numbers that add up to the target
    public static void findPair(int[] nums, int target) {
        //hashSet to store numbers we have already seen while looping
        HashSet<Integer> present = new HashSet<>();

        //loop through each number in the array
        for (int num : nums) {
            //calculate the complement 'sub' that would sum to target
            int sub = target - num;

            //check if we have already seen the complement 'sub' earlier
            if (present.contains(sub)) {
                // If yes, then we found a pair
                System.out.println("Pair found (" + num + ", " + sub + ")");
                return;  // Exit after finding the first valid pair
            }

            //otherwise, add the current number to the set of seen numbers
            present.add(num);
        }

        //if loop completes and no pair found
        System.out.println("Pair not found.");
    }

    public static void main(String[] args) {
        //Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        //Step 1: Ask user for the number of elements in the array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();  // Read the size of the array

        //Step 2: Create an array of size n
        int[] nums = new int[n];

        //Step 3: Ask user to input n numbers
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();  // Fill array with user input
        }

        //Step 4: Ask user for the target sum
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();  // Read the target value

        //Step 5: Call the function to check if a pair exists
        findPair(nums, target);

        //close the scanner to avoid memory leaks
        sc.close();
    }
}
