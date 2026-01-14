package Arrays;

/*
 Problem: Container With Most Water
 Link: https://leetcode.com/problems/container-with-most-water
 Difficulty: Medium

 Approach:
 - Use two pointers: left at start and right at end of the array.
 - Calculate area using: area = min(height[left], height[right]) * (right - left).
 - Move the pointer with the smaller height inward to try for a bigger area.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class ContainerWithMostWater {

    public static int nonOptimalSolution(int[] nums) {
        //Pointer movement is incorrect: Both pointers are controlled explicitly
        int right = nums.length - 1;
        int max = 0;
        for (int left = 0; left < nums.length; left++) {
            int width = nums.length - left - 1;
            int height = Math.min(nums[left], nums[right]);
            max = Math.max(max, height * width);
            if (nums[left] > nums[right]) {
                right--;
            }
        }
        return max;
    }

        public static int optimalSolution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(nums[left], nums[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, height * width);

            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 8, 6, 2, 5, 4, 8, 3, 7 },
                { 1, 5, 4, 3 },
                { 2, 1, 8, 6, 4, 6, 5, 5 }
        };

        for (int i = 0; i < nums.length; i++) {
            System.out.println("[" + (i + 1) + ". optimalSolution] -> " + optimalSolution(nums[i]));
        }
        System.out.println("---------------------------");

        for (int i = 0; i < nums.length; i++) {
            System.out.println("[" + (i + 1) + ". nonOptimalSolution] -> " + nonOptimalSolution(nums[i]));
        }
    }
}