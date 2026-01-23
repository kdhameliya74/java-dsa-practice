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
        
        int[] nums = {0,1,1,1,0,1,1,0,1};

        int end = 0;
        int encounterZero = 0;
        
        for(int i = 0; i < nums.length -1; i++) {
            if(nums[i] == nums[i+1]) {
                end++;
            } else {
                if (encounterZero != 1) {
                    encounterZero = 1;
                }
                end++;
            }
        }

        System.out.println(end);

    }
}
