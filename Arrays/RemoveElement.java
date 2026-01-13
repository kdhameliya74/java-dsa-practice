package Arrays;

/*
 Problem: Remove Element
 Link: https://leetcode.com/problems/remove-element/
 Difficulty: Easy

 Approach:
 - Use two pointers: one to read elements and one to write non-target elements in-place.
 - Skip the target value and compact the array from the front.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class RemoveElement {

    public static int optimalSolution(Integer[] nums, int target) {
        int writePos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) { // writePos won't increase if target and element are same.
                nums[writePos] = nums[i];
                writePos++;
            }
        }
        return writePos; // new length after removal
    }

    public static void main(String[] args) {
        Integer[] nums = {0,1,2,2,3,0,4,2};
        int target = 2;
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums, target));
    }
}
