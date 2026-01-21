package Arrays;

import java.util.Arrays;

/*
 Problem: Squares of a Sorted Array
 Link: https://leetcode.com/problems/squares-of-a-sorted-array
 Difficulty: Easy

 Approach:
 - Use two pointers at the start and end of the array.
 - Compare absolute values to find the larger square.
 - Place the larger square at the end of the result array.
 - Move pointers inward and repeat until all elements are processed.
 
 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class SquaresOfASortedArray {
    public static String nonOptimalSolution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            double lsqrt = Math.pow(nums[left], 2);
            double rsqrt = Math.pow(nums[right], 2);
            if (lsqrt < rsqrt) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        return Arrays.toString(nums);
    }

    public static String optimalSolution(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length - 1;
        int[] result = new int[nums.length];

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[pos] = nums[left] * nums[left];
                left++;
            } else {
                result[pos] = nums[right] * nums[right];
                right--;
            }
            pos--;
        }

        return Arrays.toString(result);
    }

    public static void main(String[] args) {
        int[] nums = { -7, -3, 2, 3, 11 };

        System.out.println("[1. optimalSolution] duplicate -> " + optimalSolution(nums));
        System.out.println("[2. nonOptimalSolution] duplicate -> " + nonOptimalSolution(nums));
    }
}
