package Arrays;

/*
 Problem: Maximum Subarray (Kadane)
 Description: Kadane's Algorithm efficiently finds the largest sum of a contiguous subarray in a one-dimensional array.
            : A sub-array is a contiguous (continuous) part of an array.
 Link: https://leetcode.com/problems/maximum-subarray/
 Difficulty: Medium

 Approach:
  1. Initialize two variables:
    - currentSum to track the maximum subarray sum ending at the current index
    - maxSum to track the maximum subarray sum found so far
  2. Traverse the array from left to right:
    - At each element, decide whether to:
        a) Extend the previous subarray (currentSum + element)
        b) Start a new subarray from the current element
            * max() automatically resets the subarray
    - Choose the maximum of these two options and update currentSum.
  3. Update maxSum at each step with the maximum value between
    maxSum and currentSum.

 Time Complexity: O(n)  -> Constant work per element
 Space Complexity: O(1) -> Only two variables used:maxSum, currentSum
                        -> No extra arrays or data structures
*/

public class MaximumSubarrayKadane {
    public static void main(String[] args) {
        int[] inputs = new int[] {2,3,-8,7,-1,2,3};
        int currentSum = inputs[0];
        int maxSum = inputs[0];

        for(int input: inputs) {
            currentSum = Integer.max(currentSum + input, input);
            // if(maxSum < currentSum) {
            //     maxSum = currentSum;
            // }
            maxSum = Integer.max(maxSum, currentSum);
        }
        System.out.println("[MaximumSubarrayKadane] " + maxSum);
    }
}
