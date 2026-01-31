package Arrays;

/*
 Problem: Longest Continuous Increasing Subsequence
 Link: https://leetcode.com/problems/longest-continuous-increasing-subsequence
 Difficulty: Easy

 Approach:
 - Traverse the array once.
 - If the current element is greater than the previous one, extend the sequence.
 - Otherwise, reset the length to 1.
 - Track and return the maximum length found.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class LongestContinuousIncreasingSubsequence {

    public static int optimalSolution(int[] nums) {
        // 1, 3, 5, 4, 7
        // 2, 1, 3, 5, 6

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int current = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] > nums[right - 1]) {
                current++;
                maxLen = Math.max(maxLen, current);
            } else {
                current = 1;
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[] { 1, 3, 5, 4, 7 }));
        System.out.println("[2. optimalSolution] -> " + optimalSolution(new int[] { 2, 2, 2, 2, 2 }));
        System.out.println("[2. optimalSolution] -> " + optimalSolution(new int[] { 2, 1, 3, 5, 6 }));

    }
}
