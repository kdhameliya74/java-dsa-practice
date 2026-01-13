package Arrays;

import java.util.Arrays;

/*
 Problem: Move Zeroes
 Link: https://leetcode.com/problems/move-zeroes/
 Difficulty: Easy

 Approach:
 - Use two pointers: one to read elements and one to write non-zero elements in-place.
 - When a non-zero element is found, place it at writePos and move zero to the current index.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MoveZeroes {

    public static void optimalSolution(int[] nums) {
        int writePos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { // writePos increases only for non-zero elements
                nums[writePos] = nums[i];
                nums[i] = 0;
                writePos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums1 = {0};
        
        optimalSolution(nums);
        System.out.println("[1. optimalSolution] -> " + Arrays.toString(nums));

        optimalSolution(nums1);
        System.out.println("[2. optimalSolution] -> " + Arrays.toString(nums1));
    }
}
