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
    public static void main(String[] args) {
        int[] nums = {5};
        int size = 1;
        double maxAvg = 0;
        int pos = 0;

        while(pos < nums.length) {
            double sum = 0;
            int current = pos;
            int currentSize = size + pos; 
            while (current < currentSize && currentSize < nums.length) {
                sum += nums[current];
                current++;
            }
            maxAvg = Math.max(maxAvg, sum/size);
            pos++;
        }

        System.out.println(maxAvg);
    }
}
