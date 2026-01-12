package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Problem: Running Sum of 1D Array
 Link: https://leetcode.com/problems/running-sum-of-1d-array/
 Difficulty: Easy

 Approach:
  - Maintain a variable `currentSum` initialized to 0.
  - Iterate through the array from left to right.
  - Add the current element to `currentSum`.
  - Store `currentSum` in the result list at each step.
  - Return the final list containing running sums.

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class RunningSumof1DArray {
    public static List<Integer> optimalSolution(int[] nums) {

        // If modified original array is allowed
        // for(int i = 1; i < nums.length; i++) {
        //         nums[i] += nums[i -1];
        //     }
        // System.out.println(Arrays.toString(nums));

        List<Integer> sum = new ArrayList<>();
        int currentSum = 0;

        for(int num: nums) {
            currentSum+= num;
            sum.add(currentSum);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums).toString());

        int[] nums1 = {1,1,1,1,1};
        System.out.println("[2. optimalSolution] -> " + optimalSolution(nums1).toString());

        int[] nums2 = {3,1,2,10,1};
        System.out.println("[2. optimalSolution] -> " + optimalSolution(nums2).toString());
    }
}
