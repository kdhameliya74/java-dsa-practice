package Arrays;

import java.util.Arrays;

/*
 Problem: Remove Duplicates from Sorted Array
 Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array
 Difficulty: Easy

 Approach:
 - Same Direction Pointers (Fast & Slow)

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class RemoveDuplicatesfromSortedArray {

    public static int optimalSolution(Integer[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) { 
                // fast = 1, 0 != 0, 
                // fast = 2, 0 != 1 -> if -> slow increase by one
                slow++;
                nums[slow] = nums[fast];
            }
        }
        slow = slow + 1;
        return slow;
    }

    public static void main(String[] args) {
        Integer[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums) + " " + Arrays.toString(nums));

    }
}
