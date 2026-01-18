package Arrays;

/*
 Problem: Trapping Rain Water
 Link: https://leetcode.com/problems/trapping-rain-water/
 Difficulty: Hard

 Approach:

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int totalWater = 0;
        int left = 0;
        int right = 1;

        while (left < right) {
            if(nums[left] < nums[right]) { // 0 < 1
                right++; // [2] = 0 
            }
            if(nums[left] > nums[right]) { // 0 > 0
                left++; // [1] = 1
            }
            System.out.println("lop");
        }

        System.out.println(totalWater);
    }    
}
