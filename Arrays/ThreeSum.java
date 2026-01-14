package Arrays;

import java.util.*;

/*
 Problem: 3Sum
 Link: https://leetcode.com/problems/3sum/
 Difficulty: Medium

 Approach:
 - Sort the array
 - Fix one element (i) and use two pointers to find remaining two
 - Skip duplicates to avoid repeated triplets

 Time Complexity: O(n^2)
 Space Complexity: O(1)  (excluding result list)
*/

public class ThreeSum {

    public static List<List<Integer>> optimalSolution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate left & right values
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("[1. 3Sum] -> " + optimalSolution(nums));
    }
}
