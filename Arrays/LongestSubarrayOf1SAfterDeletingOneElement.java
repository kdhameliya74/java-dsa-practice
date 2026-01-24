package Arrays;

/*
 Problem: Longest Subarray of 1s After Deleting One Element
 Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 Difficulty: Medium

 Approach:

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class LongestSubarrayOf1SAfterDeletingOneElement {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        
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

        System.out.println(maxLength);

    }
}
