package Arrays;

import java.util.*;

/*
 Problem: Two Sum
 Link: https://leetcode.com/problems/two-sum/
 Difficulty: Easy

 Approach:
 - Use HashMap to store value → index
 - For each element, check if (target - current) exists

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }
}
