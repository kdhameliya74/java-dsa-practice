package Arrays;

/*
 Problem: Maximum Average Subarray I
 Link: https://leetcode.com/problems/maximum-average-subarray-i/
 Difficulty: Easy

 Approach:

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MaximumAverageSubarray1 {
     public static double nonOptimalSolution(int[] nums, int k) {
        // brute force, time complexity O(n*k);
        double maxAvg = Double.NEGATIVE_INFINITY;

        for (int i = 0; i <= nums.length - k; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int size = 4;

        System.out.println(nonOptimalSolution(nums, size));
    }
}
