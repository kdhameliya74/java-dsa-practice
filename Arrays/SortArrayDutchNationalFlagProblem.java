package Arrays;

import java.util.Arrays;

/*
 Problem: Sort an array of 0s, 1s and 2s - Dutch National Flag Problem
 Difficulty: Easy

 Approach:
 - Use three pointers: left, mid, right
 - left tracks boundary of 0s
 - mid scans the array
 - right tracks boundary of 2s
 - Swap elements to move 0s to left and 2s to right
 - 1s automatically settle in the middle

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class SortArrayDutchNationalFlagProblem {
    public static int[] optimalSolution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (mid <= right) {
            if(nums[mid] == 0) {
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            }else if(nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 0, 1, 2};
        System.out.println("[1. nonOptimalSolution] -> " + Arrays.toString(optimalSolution(nums)));
    }
}
