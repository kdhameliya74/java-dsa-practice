package Arrays;

/*
 Problem: Minimum Size Subarray Sum
 Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 Difficulty: Medium

 Approach:
 - Initialize two pointers left and right to represent the window.
 - Move the right pointer forward and keep adding elements to a running sum.
 - When the sum becomes greater than or equal to the target, try to shrink the window from the left to find the smallest possible window.
 - Update the minimum length whenever a valid window is found.
 - Continue this process until the entire array is processed.
 - If no subarray meets the condition, return 0.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MinimumSizeSubarraySum {

    public static int nonOptimalSolution(int[] nums, int target) {
        // Time Complexity: O(n^2)
        int minLen = Integer.MAX_VALUE;
        
        for(int left = 0; left < nums.length; left++) {
            int sum = 0;
            for(int right = left; right < nums.length; right++) {
                sum += nums[right];
                if(sum >= target) {
                    minLen = Math.min(minLen, right - left + 1);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0: minLen;
    } 

    public static int optimalSolution(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // sum = 0 + 2 = 2 - while false until sum is 8 upto index 3
            while (sum>=target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left]; // removing element
                left++; // shrinkin window
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[] { 2,3,1,2,4,3 }, 7));
        System.out.println("[2. optimalSolution] -> " + optimalSolution(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }, 11));
        System.out.println("[3. nonOptimalSolution] -> " + nonOptimalSolution(new int[] { 2,3,1,2,4,3 }, 7));
        System.out.println("[4. nonOptimalSolution] -> " + nonOptimalSolution(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }, 11));
    }
}