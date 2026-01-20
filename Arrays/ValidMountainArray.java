package Arrays;

/*
 Problem: Valid Mountain Array
 Link: https://leetcode.com/problems/valid-mountain-array/
 Difficulty: Easy

 Approach:

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class ValidMountainArray {
    public static void main(String[] args) {
        int[] nums = {0,3,2,1 };

        int peak = 0;
        boolean mountain = false;
        for (int num : nums) {
            peak = Math.max(peak, num);
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[0] == peak || nums[nums.length - 1] == peak) {
                mountain = false;
                break;
            }
            if(nums[i] < peak) {
                mountain = true;
            } 
            if(nums[i] > peak) {
                mountain = false;
            }
        }

        System.out.println(mountain);

    }
}
