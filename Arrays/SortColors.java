package Arrays;

import java.util.Arrays;

/*
 Problem: Sort colors
 Link: https://leetcode.com/problems/sort-colors/
 Difficulty: Medium

 Approach:

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class SortColors {
    // public static String optimalSolution(int[] nums) {

    // }
    public static String nonOptimalSolution(int[] nums) {
        // 2,0,2,1,1,0
        // 0,0,2,1,1,2 right = 1
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] < nums[right]) {
                left++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }

        System.out.println(Arrays.toString(nums));
        return "";
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        System.out.println("[1. nonOptimalSolution] -> " + nonOptimalSolution(nums));
    }
}
