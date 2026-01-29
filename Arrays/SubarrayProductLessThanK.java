package Arrays;

/*
 Problem: Subarray Product Less Than K
 Link: https://leetcode.com/problems/subarray-product-less-than-k
 Difficulty: Medium

 Approach:
 - Use sliding window since all elements are positive.
 - Maintain a window [left..right] and a running product.
 - Expand the window by moving `right` and multiply the product.
 - If product becomes >= k, shrink the window from  left until product < k.
 - For each valid window ending at `right`, all subarrays starting from left to right are valid.
 - Count such subarrays using (right - left + 1).
 - If k <= 1, return 0 as no valid subarray exists.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class SubarrayProductLessThanK {
    public static int nonOptimalSolution(int[] nums, int k) {
        // time complexity is O(n^2)
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
        if (k <= 1)
            return 0;
        int subarray = 0;
        int product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            /*
             * For a window [left, right], the subarrays ending at right are:
             * [nums[right]] (length 1)
             * [nums[right-1], nums[right]] (length 2)
             * ...
             * [nums[left], ..., nums[right]] (length right - left + 1)
             * index starts from zero that's why we use +1 
             */
            subarray += right - left + 1;
        }

        return subarray;
    }

    public static void main(String[] args) {

        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[] { 10, 5, 2, 6 }, 100));
        System.out.println("[2. optimalSolution] -> " + optimalSolution(new int[] { 1, 2, 3 }, 0));
        System.out.println("[3. nonOptimalSolution] -> " + nonOptimalSolution(new int[] { 10, 5, 2, 6 }, 100));
        System.out.println("[4. nonOptimalSolution] -> " + nonOptimalSolution(new int[] { 1, 2, 3 }, 0));
    }
}
