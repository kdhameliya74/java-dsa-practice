package Arrays;

/*
 Problem: Majority Element II
 Link: https://leetcode.com/problems/find-the-duplicate-number
 Difficulty: Medium

 Approach:
 - 

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class FindDuplicateNumber {
    public static int optimalSolution(int[] nums) {
        // 3, 1, 3, 4, 2
        int writePos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                System.out.println("Match");
                // nums[writePos] = nums[i];
                // writePos++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
    }
}
