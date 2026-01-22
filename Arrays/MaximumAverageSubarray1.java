package Arrays;

/*
 Problem: Maximum Average Subarray I
 Link: https://leetcode.com/problems/maximum-average-subarray-i/
 Difficulty: Easy

 Approach:
 - Sliding Window
 -A subarray of fixed size k slides across the array.
 - Calculate the sum of the first k elements.
 - For each next window:
     → subtract the element leaving the window
     → add the new element entering the window
 - Track the maximum average during traversal.
 - This avoids recomputing sums and runs in linear time.

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
    public static double optimalSolution(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;

        // find first window sum
        // now remove i-k element from sum and add i new element to sum
        // compare max sum
        double sum = 0;
        for(int i =0; i <k; i++) {
            sum+= nums[i];
        }
        maxAvg = sum;

        for(int i=k; i< nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxAvg = Math.max(sum, maxAvg);
        }

        return maxAvg/k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int size = 4;

        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums, size));
        System.out.println("[1. nonOptimalSolution] -> " + nonOptimalSolution(nums, size));
    }
}
