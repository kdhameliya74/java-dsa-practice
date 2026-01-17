package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Problem: Product of Array Except Self
 Difficulty: Medium

 Approach:
 - Use prefix product to store product of all elements before index i
 - Use suffix product to multiply elements after index i
 - First pass fills prefix products
 - Second pass multiplies suffix products in-place
 - Avoids division and extra space

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class ProductOfArrayExceptSelf {
    public static String nonOptimalSolution(int[] nums) {
        // inefficient and buggy
        List<Integer> products = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int product = 1;
            int right = len - 1;
            while (right > 0) {
                if (i != right) {
                    product *= nums[right];
                }
                right--;
            }
            products.add(product);
        }

        return products.toString();
    }

    public static String optimalSolution(int[] nums) {
        // Best approach
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }
        return Arrays.toString(result);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] nums1 = { -1, 1, 0, -3, 3 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums));
        System.out.println("------------------------------------");
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums1));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums1));
    }
}
