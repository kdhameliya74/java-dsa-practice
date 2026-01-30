package Arrays;

/*
 Problem: Longest Continuous Increasing Subsequence
 Link: https://leetcode.com/problems/longest-continuous-increasing-subsequence
 Difficulty: Medium

 Approach:


 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class LongestContinuousIncreasingSubsequence {

    public static int optimalSolution(int[] nums) {
        int minlen = 1;
        for (int right = 0; right < nums.length - 1; right++) {

            if(nums[right] < nums[right + 1]) {
                minlen++;
            } else if(nums[right] > nums[right + 1]) {
                minlen = 1;
            }
        }
        return minlen;
    }

    public static void main(String[] args) {

        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[] { 1, 3, 5, 4, 7 }));
        System.out.println("[2. optimalSolution] -> " + optimalSolution(new int[] { 2, 2, 2, 2, 2 }));
        System.out.println("[2. optimalSolution] -> " + optimalSolution(new int[] { 2, 1, 3, 5, 6 }));

    }
}
