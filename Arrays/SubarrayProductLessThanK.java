package Arrays;

/*
 Problem: Minimum Size Subarray Sum
 Link: https://leetcode.com/problems/subarray-product-less-than-k
 Difficulty: Medium

 Approach:
 - 

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class SubarrayProductLessThanK {
    public static int nonOptimalSolution(int[] nums, int k) {
        int subarray = 0;
        for (int left = 0; left < nums.length; left++) {
            int product = 1;
            for (int right = left; right < nums.length; right++) {
                product *= nums[right];
                if (product < k) {
                    subarray++;
                }
            }
        }
        return subarray;

        /*
         * int subarray = 0;
         * for (int right = 0; right < nums.length; right++) {
         * int left = right;
         * int product = 1;
         * while (left < nums.length) {
         * product = product * nums[left];
         * if(product < k) {
         * subarray++;
         * }
         * left++;
         * }
         * }
         * return subarray;
         * 
         */
    }

    public static int optimalSolution(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {

        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[] { 10, 5, 2, 6 }, 100));
        System.out.println("[2. optimalSolution] -> " + optimalSolution(new int[] { 1, 2, 3 }, 0));
        System.out.println("[3. nonOptimalSolution] -> " + nonOptimalSolution(new int[] { 10, 5, 2, 6 }, 100));
        System.out.println("[4. nonOptimalSolution] -> " + nonOptimalSolution(new int[] { 1, 2, 3 }, 0));
    }
}
