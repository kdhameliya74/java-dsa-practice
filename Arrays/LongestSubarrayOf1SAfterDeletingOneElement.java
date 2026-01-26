package Arrays;

/*
 Problem: Longest Subarray of 1s After Deleting One Element
 Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 Difficulty: Medium

 Approach:
 - Use two pointers (left and right) to create a sliding window.
 - Expand the window by moving right.
 - Keep a count of zeros inside the window.
 - If zeros become more than 1, shrink the window from the left until zeros ≤ 1.
 - For every valid window, calculate: window length = right - left

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class LongestSubarrayOf1SAfterDeletingOneElement {

    public static int optimalSolution(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static int nonOptimalSolution(int[] nums) {
        // 0, 1, 1, 1, 0, 1, 1, 0, 1
        // nums[i] == 0; zero increase until next zero
        // nums[4] == 0 encounter another zero so it will increase
        // if zero increased by 1, move left position

        int left = 0;
        int zero = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zero++;
            }

            if(zero > 1) {
                for(int j = zero; j > 1; j--) {
                    if(nums[left] == 0) {
                        zero--;
                    }
                    left++;
                }
            }

            maxCount = Math.max(maxCount, i - left);

        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        int[] nums1 = { 1,1,0,1 };

        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums));

    }
}
